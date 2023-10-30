<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model708.NhaCungCap708" %>
<%@ page import="model708.HangHoa708" %>
<%@ page import="DAO708.NhaCungCap708DAO" %>
<%@ page import="DAO708.HangHoa708DAO" %>
<%@ page import="model708.HangNhap708" %>

<%
// Lấy danh sách hàng nhập tạm thời từ session
List<HangNhap708> danhSachHangNhapTamThoi = (List<HangNhap708>) session.getAttribute("danhSachHangNhapTamThoi");
if (danhSachHangNhapTamThoi == null) {
    danhSachHangNhapTamThoi = new ArrayList<>();
    session.setAttribute("danhSachHangNhapTamThoi", danhSachHangNhapTamThoi);
}
%>

<!DOCTYPE html>
<html>
<head>
    <title>Nhập hàng hóa</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>
<body class="container">
	
    <a class="btn btn-secondary mb-3 mt-4"  href="GDChinhQL708.jsp">Quay lại</a>
    
    <h1 class="mt-2">NHẬP HÀNG HÓA</h1>

    
	<a class="btn btn-success mb-3" href="ThemMoiNhaCungCap708.jsp">Thêm mới Nhà Cung Cấp</a><br>
	
    <!-- Form tìm kiếm -->
    <form class="form-inline mb-3" action="/ShopMan/TimKiemNhaCungCapServlet" method="post">
        <label class="mr-2" for="searchNCC">Tìm kiếm nhà cung cấp:</label>
        <input class="form-control mr-2" type="text" name="searchNCC" id="searchNCC">
        <input class="btn btn-primary"  type="submit" value="Tìm kiếm">
    </form>

    <!-- Hiển thị kết quả tìm kiếm -->
    <form action="/ShopMan/XacNhanNCCServlet" method="post">
        <h2>Kết quả tìm kiếm:</h2>
        <ul class="list-unstyled">
            <% 
                List<NhaCungCap708> result = (List<NhaCungCap708>) session.getAttribute("searchResultNCC");
            	int selectedNCCId = 0;
                if(session.getAttribute("selectedNCCId") != null){ selectedNCCId = (int) session.getAttribute("selectedNCCId");}

                if (result != null && !result.isEmpty()) {
                    for (NhaCungCap708 nhaCungCap : result) {
            %>
                        <li>
                            <label>
                                <input type="radio" name="selectedNCC" value="<%= nhaCungCap.getId() %>"
                                    <%= (nhaCungCap.getId() == selectedNCCId) ? "checked" : "" %>>
                                <%= nhaCungCap.getTenNhaCungCap() %>
                            </label>
                        </li>
            <%
                    }
                } else {
            %>
                    <p>Không tìm thấy kết quả.</p>
            <%
                }
            %>
        </ul>

        <input class="btn btn-primary"  type="submit" value="Chọn nhà cung cấp">
    </form>
    
	<%
	if(session.getAttribute("selectedNCCId") != null) {
	%>
	    <a class="btn btn-success mb-3 mt-3"  href="ThemMoiHangHoa708.jsp">Thêm mới Hàng Hóa</a><br>
	
	
    <!-- Form tìm kiếm hàng hóa -->
    <form class="form-inline mb-3"  action="/ShopMan/TimKiemHangHoaServlet" method="post">
        <label class="mr-2" for="searchHH">Tìm kiếm hàng hóa:</label>
        <input class="form-control mr-2" type="text" name="searchHH" id="searchHH">
        <input class="btn btn-primary"  type="submit" value="Tìm kiếm">
    </form>

    <!-- Hiển thị kết quả tìm kiếm hàng hóa -->
    <form action="/ShopMan/ChonHangHoaServlet" method="post">
    <h2>Kết quả tìm kiếm hàng hóa:</h2>
    <ul class="list-unstyled">
        <% 
            List<HangHoa708> resultHangHoa = (List<HangHoa708>) session.getAttribute("searchResultHangHoa");
            Integer selectedHangHoaId = (Integer) session.getAttribute("selectedHangHoaId");

           
            if (resultHangHoa != null && !resultHangHoa.isEmpty()) {
                for (HangHoa708 hangHoa : resultHangHoa) {
        %>
                    <li>
                        <label>
                            <input type="radio" name="selectedHangHoa" value="<%= hangHoa.getId() %>"
                                <%= (selectedHangHoaId != null && hangHoa.getId() == selectedHangHoaId) ? "checked" : "" %>>
                            <%= hangHoa.getTen() %>
                        </label>
                    </li>
        <%
                }
            } else {
        %>
                <p>Không tìm thấy kết quả.</p>
        <%
            }
        %>
    </ul>

    <!-- Nút xác nhận -->
    <input class="btn btn-primary mb-4"  type="submit" value="Chọn hàng hóa">
</form>
	<%
	if(session.getAttribute("selectedHangHoaId") != null) {
	%>
    <!-- Form nhập thông tin hàng nhập -->
    <form class="form-inline mb-3" action="/ShopMan/ThemHangNhapServlet" method="post">
        <label  class="mr-2" for="soLuong" >Số lượng:</label>
        <input class="form-control mr-2" type="text" name="soLuong" id="soLuong" required>
        
        <label  class="mr-2" for="donGia" >Đơn giá:</label>
        <input class="form-control mr-2" type="text" name="donGia" id="donGia" required>

        <!-- Nút thêm hàng nhập -->
        <input class="btn btn-success" type="submit" value="Thêm hàng nhập">
    </form>
    <%
		} 
	%>
	<%
	} 
	%>
    <!-- Hiển thị danh sách hàng nhập tạm thời -->
	<h2 class="mt-4">Danh sách hàng nhập tạm thời:</h2>
	<table class="table">
	    <thead>
	        <tr>
	            <th scope="col">Tên hàng</th>
	            <th scope="col">Số lượng</th>
	            <th scope="col">Đơn giá</th>
	            <th scope="col">Xóa</th> 
	        </tr>
	    </thead>
	    <tbody>
	        <%
	            double tongTien = 0;
	        	int idTam = 1;
	            for (HangNhap708 hangNhap : danhSachHangNhapTamThoi) {
	                tongTien += hangNhap.getSoLuong() * hangNhap.getDonGia();
	                hangNhap.setId(idTam);
	                idTam++;
	        %>
	            <tr>
	                <td><%= hangNhap.getTen() %></td>
	                <td><%= hangNhap.getSoLuong() %></td>
	                <td><%= hangNhap.getDonGia() %> VNĐ</td>
	                <td>
                    <form action="/ShopMan/XoaHangNhapServlet" method="post">
                        <input type="hidden" name="hangNhapId" value="<%= hangNhap.getId() %>">
                        <input class="btn btn-danger" type="submit" value="Xóa">
                    </form>
                	</td>
	            </tr>
	        <%
	            }
	        %>
	    </tbody>
	</table>


	<!-- Hiển thị tổng tiền -->
	<h3 class="mt-2 mb-2 text-danger">Tổng tiền: <%= tongTien %> VNĐ</h3>
	

    <!-- Nút xác nhận thanh toán -->
    <form class="form-inline mb-3" action="/ShopMan/XacNhanThanhToanServlet" method="post">
     	<input type="hidden" name="tongTien" value="<%= tongTien %>">
        <input class="btn btn-success"  type="submit" value="Xác nhận thanh toán">
    </form>

</body>
</html>