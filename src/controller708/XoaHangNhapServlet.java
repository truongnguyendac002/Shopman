package controller708;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model708.HangNhap708;

/**
 * Servlet implementation class XoaHangNhapServlet
 */
@WebServlet("/XoaHangNhapServlet")
public class XoaHangNhapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XoaHangNhapServlet() {
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
	        
	        int hangNhapId = Integer.parseInt(request.getParameter("hangNhapId"));
	
	        List<HangNhap708> danhSachHangNhapTamThoi = (List<HangNhap708>) request.getSession().getAttribute("danhSachHangNhapTamThoi");
	
	        danhSachHangNhapTamThoi.removeIf(hangNhap -> hangNhap.getId() == hangNhapId);
	
	        request.getSession().setAttribute("danhSachHangNhapTamThoi", danhSachHangNhapTamThoi);
	
	        response.sendRedirect("view/NVQuanLy708/GDNhapHangHoa708.jsp");
	    }

}
