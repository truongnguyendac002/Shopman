<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Trang chủ</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>
<body class="container">
	<form action="/ShopMan/DangXuatServlet" method="post">
    <input class="btn btn-secondary mb-3 mt-4"  type="submit" value="Đăng Xuất"> 
	</form>
    <h1 class="mt-2">GIAO DIỆN QUẢN LÝ</h1>
    <ul class="list-unstyled">
        <li><a class="btn btn-success mb-3 mt-4" href="GDNhapHangHoa708.jsp">Nhập hàng hóa</a></li>
        <li><a class="btn btn-primary mb-3 mt-4" href="#">Thống kê</a></li>
        <li><a class="btn btn-primary mb-3 mt-4" href="#">Quản lý thông tin hàng hóa</a></li>
        <li><a class="btn btn-primary mb-3 mt-4" href="#">Quản lý thông tin nhà cung cấp</a></li>
    </ul>

</body>
</html>