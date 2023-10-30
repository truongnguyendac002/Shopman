package controller708;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO708.NhaCungCap708DAO;
import model708.NhaCungCap708;

/**
 * Servlet implementation class ThemMoiNhaCungCapServlet
 */
@WebServlet("/ThemMoiNhaCungCapServlet")
public class ThemMoiNhaCungCapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemMoiNhaCungCapServlet() {
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
               
        String tenNhaCungCap = request.getParameter("tenNhaCungCap");
        String diaChi = request.getParameter("diaChi");
        String sdt = request.getParameter("soDienThoai");
               
        NhaCungCap708 nhaCungCap = new NhaCungCap708();
        nhaCungCap.setTenNhaCungCap(tenNhaCungCap);
        nhaCungCap.setDiaChi(diaChi);
        nhaCungCap.setSdt(sdt);

        NhaCungCap708DAO nhaCungCapDAO = new NhaCungCap708DAO();
        nhaCungCapDAO.addNhaCungCap(nhaCungCap);

        response.sendRedirect("view/NVQuanLy708/ThemMoiNhaCungCap708.jsp");
        
    }

}
