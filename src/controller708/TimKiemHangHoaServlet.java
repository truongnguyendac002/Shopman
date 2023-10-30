package controller708;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO708.HangHoa708DAO;
import model708.HangHoa708;
/**
 * Servlet implementation class TimKiemHangHoaServlet
 */
@WebServlet("/TimKiemHangHoaServlet")
public class TimKiemHangHoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimKiemHangHoaServlet() {
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
       
        String searchHH = request.getParameter("searchHH");
        
        int selectedNCCId = (int) request.getSession().getAttribute("selectedNCCId");
        List<HangHoa708> searchResultHangHoa = HangHoa708DAO.timKiemHangHoa(searchHH, selectedNCCId);

        request.getSession().setAttribute("searchResultHangHoa", searchResultHangHoa);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/NVQuanLy708/GDNhapHangHoa708.jsp");
        dispatcher.forward(request, response);
    }

}
