package controller708;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO708.HangHoa708DAO;
import model708.HangHoa708;
import model708.HangNhap708;

/**
 * Servlet implementation class ThemHangNhapServlet
 */
@WebServlet("/ThemHangNhapServlet")
public class ThemHangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemHangNhapServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    String soLuongStr = request.getParameter("soLuong");
	    String donGiaStr = request.getParameter("donGia");

	    int soLuong = Integer.parseInt(soLuongStr);
	    double donGia = Double.parseDouble(donGiaStr);
	    
	    Integer selectedHangHoaId = (Integer) session.getAttribute("selectedHangHoaId");
	    HangHoa708 selectedHangHoa = HangHoa708DAO.getHangHoaById(selectedHangHoaId);
	    System.out.println(selectedHangHoaId);
	    HangNhap708 hangNhap = new HangNhap708();
	    hangNhap.setIdHangHoa(selectedHangHoa.getId());
	    hangNhap.setTen(selectedHangHoa.getTen());
	    hangNhap.setSoLuong(soLuong);
	    hangNhap.setDonGia(donGia);

	    List<HangNhap708> danhSachHangNhapTamThoi = (List<HangNhap708>) session.getAttribute("danhSachHangNhapTamThoi");
	    danhSachHangNhapTamThoi.add(hangNhap);

	    session.setAttribute("danhSachHangNhapTamThoi", danhSachHangNhapTamThoi);

	    response.sendRedirect("view/NVQuanLy708/GDNhapHangHoa708.jsp");
	}

}
