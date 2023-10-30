<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>
<body class="container mb-4">

    <h1 class="mt-4">Đăng ký khách hàng</h1>

    <form class="mt-4" action="/ShopMan/DangKyServlet" method="post">
        <div class="form-group">
            <label for="hoTen">Họ và tên</label>
            <input type="text" class="form-control" name="hoTen" placeholder="Họ và tên" required>
        </div>
        <div class="form-group">
            <label for="taiKhoan">Tên tài khoản</label>
            <input type="text" class="form-control" name="taiKhoan" placeholder="Tên tài khoản" required>
        </div>
        <div class="form-group">
            <label for="matKhau">Mật khẩu</label>
            <input type="password" class="form-control" name="matKhau" placeholder="Mật khẩu" required>
        </div>
        <div class="form-group">
            <label for="xacNhanMatKhau">Xác nhận mật khẩu</label>
            <input type="password" class="form-control" name="xacNhanMatKhau" placeholder="Xác nhận mật khẩu" required>
        </div>
        <div class="form-group">
            <label for="soDienThoai">Số điện thoại</label>
            <input type="text" class="form-control" name="soDienThoai" placeholder="Số điện thoại" required>
        </div>
        <div class="form-group">
            <label for="diaChi">Địa chỉ</label>
            <input type="text" class="form-control" name="diaChi" placeholder="Địa chỉ" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" name="email" placeholder="Email" required>
        </div>
        <button type="submit" class="btn btn-success">Đăng ký</button>
        <a class="btn btn-primary"  href="GDDangNhap708.jsp">Đăng Nhập</a>
    </form>

    


</body>
</html>
