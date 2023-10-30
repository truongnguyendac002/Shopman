<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>
<body class="container">

    <h1 class="mt-4">Đăng nhập</h1>

    <form class="mt-4" action="/ShopMan/DangNhapServlet" method="post">
    	<label class="mr-2 mt-2" for="username">Tên tài khoản</label>
        <input class="form-control mr-2"  type="text" name="username" placeholder="Tên tài khoản" required>
        <label class="mr-2 mt-2" for="password">Mật khẩu</label>
        <input class="form-control mr-2"  type="password" name="password" placeholder="Mật khẩu" required>
        <input class="btn btn-primary mt-2 mb-2" type="submit" value="Đăng nhập">
        <a class="btn btn-success" href="GDDangKy708.jsp">Đăng ký</a>
    </form>

</body>
</html>