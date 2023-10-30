<%@ page import="java.util.List" %>
<%@ page import="DAO708.*" %>
<%@ page import="model708.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>In Hóa Đơn</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>
<body class="container">

<a class="btn btn-secondary mb-3 mt-4"  href="view/NVQuanLy708/GDNhapHangHoa708.jsp">Quay lại</a>

<%
    int idHoaDonNhap = (int) request.getAttribute("idHoaDonNhap");
    HoaDonNhapHang708DAO hoadonDAO = new HoaDonNhapHang708DAO();
    HoaDonNhapHang708 hoaDonNhap = hoadonDAO.getHoaDonNhapById(idHoaDonNhap);

    // Lấy danh sách hàng nhập từ ID hoá đơn nhập
    HangNhap708DAO hangNhapDAO = new HangNhap708DAO();
    List<HangNhap708> danhSachHangNhap = hangNhapDAO.getHangNhapByHoaDonId(idHoaDonNhap);
%>

<p class="font-weight-bold">ID Hóa Đơn Nhập: <%= hoaDonNhap.getId() %></p>
<p class="font-italic">Ngày Nhập Hàng: <%= hoaDonNhap.getNgayNhapHang() %></p>
<p class="text-danger">Tổng Tiền: <%= hoaDonNhap.getTongTien() %></p>

<table class="table table-bordered mt-3" >
    <thead class="thead-dark">
        <tr>
            <th>Tên Hàng Hóa</th>
            <th>Đơn Giá</th>
            <th>Số Lượng</th>
        </tr>
    </thead>
    <tbody>
        <% for (HangNhap708 hangNhap : danhSachHangNhap) { %>
            <tr>
                <td><%= hangNhap.getTen() %></td>
                <td><%= hangNhap.getDonGia() %></td>
                <td><%= hangNhap.getSoLuong() %></td>
            </tr>
        <% } %>
    </tbody>
</table>

<button class="btn btn-primary mt-3"class="btn btn-primary mt-3"class="btn btn-primary mt-3"class="btn btn-primary mt-3" onclick="window.print()">In Hóa Đơn</button>

</body>
</html>
