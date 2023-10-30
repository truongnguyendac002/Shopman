package controller708;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO708.KhachHang708DAO;
import DAO708.ThanhVien708DAO;
import model708.KhachHang708;
import model708.ThanhVien708;

/**
 * Servlet implementation class DangKyServlet
 */
@WebServlet("/DangKyServlet")
public class DangKyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangKyServlet() {
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
        
        String taiKhoan = request.getParameter("taiKhoan");
        String matKhau = request.getParameter("matKhau");
        String xacNhanMatKhau = request.getParameter("xacNhanMatKhau");
        String soDienThoai = request.getParameter("soDienThoai");
        String diaChi = request.getParameter("diaChi");
        String email = request.getParameter("email");

       
        if (!matKhau.equals(xacNhanMatKhau)) {
            response.sendRedirect("view/ThanhVien708/GDDangKy708.jsp?error=MatKhauKhongKhop");
            return;
        }

        ThanhVien708 thanhVien = new ThanhVien708(0, taiKhoan, matKhau, "KhachHang");

        KhachHang708 khachHang = new KhachHang708(0, diaChi, email, soDienThoai);

        ThanhVien708DAO thanhVienDAO = new ThanhVien708DAO();
        KhachHang708DAO khachHangDAO = new KhachHang708DAO();

        thanhVienDAO.addThanhVien(thanhVien);

        int thanhVienId = thanhVienDAO.getIdByTaiKhoan(taiKhoan);

        khachHang.setId(thanhVienId);
        khachHangDAO.addKhachHang(khachHang);

        response.sendRedirect("view/ThanhVien708/GDDangKy708.jsp?success=true");
    }

}
