<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm Mới Nhà Cung Cấp</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>
<body class="container">

<a class="btn btn-secondary mb-3 mt-4"  href="GDNhapHangHoa708.jsp">Quay lại</a>

<h1 class="mt-2">Thêm Mới Nhà Cung Cấp</h1>

<form class="mb-3" action="/ShopMan/ThemMoiNhaCungCapServlet" method="post">
    <label class="mr-2" for="tenNhaCungCap">Tên Nhà Cung Cấp:</label>
    <input class="form-control mr-2" type="text" id="tenNhaCungCap" name="tenNhaCungCap" required><br>

    <label class="mr-2" for="diaChi">Địa Chỉ:</label>
    <input class="form-control mr-2" type="text" id="diaChi" name="diaChi" required><br>

    <label class="mr-2" for="soDienThoai">Số Điện Thoại:</label>
    <input class="form-control mr-2" type="text" id="soDienThoai" name="soDienThoai" required><br>

    <input class="btn btn-success"  type="submit" value="Thêm Mới">
</form>

</body>
</html>
