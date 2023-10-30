package controller708;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO708.HangHoa708DAO;
import model708.HangHoa708;

/**
 * Servlet implementation class ThemMoiHangHoaServlet
 */
@WebServlet("/ThemMoiHangHoaServlet")
public class ThemMoiHangHoaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThemMoiHangHoaServlet() {
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
        request.setCharacterEncoding("UTF-8");

        String tenHangHoa = request.getParameter("ten");
        String loaiHangHoa = request.getParameter("loai");
        String moTa = request.getParameter("mota");
        int nhaCungCapID = Integer.parseInt(request.getParameter("nhaCungCapID"));

        HangHoa708 hangHoa = new HangHoa708();
        hangHoa.setTen(tenHangHoa);
        hangHoa.setLoai(loaiHangHoa);
        hangHoa.setMota(moTa);
        hangHoa.setNhaCungCapID(nhaCungCapID);

        HangHoa708DAO hangHoaDAO = new HangHoa708DAO();
        hangHoaDAO.addHangHoa(hangHoa);

        response.sendRedirect("view/NVQuanLy708/ThemMoiHangHoa708.jsp");
    }


}
