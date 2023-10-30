package controller708;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO708.HangNhap708DAO;
import DAO708.HoaDonNhapHang708DAO;
import model708.HangNhap708;
import model708.HoaDonNhapHang708;
/**
 * Servlet implementation class XacNhanThanhToanServlet
 */
@WebServlet("/XacNhanThanhToanServlet")
public class XacNhanThanhToanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanThanhToanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<HangNhap708> danhSachHangNhapTamThoi = (List<HangNhap708>) request.getSession().getAttribute("danhSachHangNhapTamThoi");

     
        double tongTien = Double.parseDouble(request.getParameter("tongTien"));

        LocalDate ngayNhapHang = LocalDate.now();

        HoaDonNhapHang708 hoaDonNhapHang = new HoaDonNhapHang708();
        hoaDonNhapHang.setNgayNhapHang(ngayNhapHang);
        hoaDonNhapHang.setTongTien(tongTien);

        try {
            HoaDonNhapHang708DAO hoadonDAO = new HoaDonNhapHang708DAO();
            int idHoaDonNhap = hoadonDAO.luuHoaDonNhapHang(hoaDonNhapHang);
            request.setAttribute("idHoaDonNhap", idHoaDonNhap);

            for (HangNhap708 hangNhap : danhSachHangNhapTamThoi) {
                hangNhap.setIdHoaDon(idHoaDonNhap);
                HangNhap708DAO hangNhapDAO = new HangNhap708DAO();
                hangNhapDAO.addHangNhap(hangNhap);
            }

            request.getSession().removeAttribute("danhSachHangNhapTamThoi");

            RequestDispatcher dispatcher = request.getRequestDispatcher("view/NVQuanLy708/InHoaDon708.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("view/NVQuanLy708/ThanhToanThatBai708.jsp");
        } finally {
            HoaDonNhapHang708DAO hoadonDAO = new HoaDonNhapHang708DAO();
            hoadonDAO.closeConnection();

            HangNhap708DAO hangNhapDAO = new HangNhap708DAO();
            hangNhapDAO.closeConnection();
        }
    }


}
