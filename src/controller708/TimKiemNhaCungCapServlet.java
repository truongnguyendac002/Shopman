package controller708;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO708.NhaCungCap708DAO;
import model708.NhaCungCap708;
/**
 * Servlet implementation class TimKiemNhaCungCapServlet
 */
@WebServlet("/TimKiemNhaCungCapServlet")
public class TimKiemNhaCungCapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiemNhaCungCapServlet() {
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
        String keyword = request.getParameter("searchNCC");

        NhaCungCap708DAO nhaCungCapDAO = new NhaCungCap708DAO();
        List<NhaCungCap708> result = nhaCungCapDAO.searchNhaCungCap(keyword);

        HttpSession session = request.getSession();
        session.setAttribute("searchResultNCC", result);

        response.sendRedirect("view/NVQuanLy708/GDNhapHangHoa708.jsp");
    }

}
