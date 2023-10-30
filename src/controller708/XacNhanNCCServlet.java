package controller708;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class XacNhanNCCServlet
 */
@WebServlet("/XacNhanNCCServlet")
public class XacNhanNCCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanNCCServlet() {
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
        String selectedNCCId = request.getParameter("selectedNCC");

        if (selectedNCCId != null && !selectedNCCId.isEmpty()) {
            int nccId = Integer.parseInt(selectedNCCId);

            HttpSession session = request.getSession();
            session.setAttribute("selectedNCCId", nccId);

            response.sendRedirect("view/NVQuanLy708/GDNhapHangHoa708.jsp");
        } else {
            response.getWriter().println("Không có nhà cung cấp được chọn.");
        }
    }

}
