<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới Hàng Hóa</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
</head>
<body class="container">

<a class="btn btn-secondary mb-3 mt-4"  href="GDNhapHangHoa708.jsp">Quay lại</a>

<h1 class="mt-2">Thêm mới Hàng Hóa</h1>


<form class="mb-3" action="/ShopMan/ThemMoiHangHoaServlet" method="post">
    <label class="mr-2" for="ten">Tên Hàng Hóa:</label>
    <input class="form-control mr-2"  type="text" id="ten" name="ten" required><br>

    <label class="mr-2" for="loai">Loại Hàng Hóa:</label>
    <select class="form-control mr-2"  id="loai" name="loai" required>
        <option value="DoUong">Đồ Uống</option>
        <option value="DoAn">Đồ Ăn</option>
        <option value="DoChoi">Đồ Chơi</option>
        <option value="DoNoiThat">Đồ Nội Thất</option>
        <option value="MyPham">Mỹ Phẩm</option>
        <option value="HocTap">Học Tập</option>
        <option value="DoTheThao">Đồ Thể Thao</option>
        <option value="VuKhi">Vũ Khí</option>
    </select><br>

    <label class="mr-2" for="mota">Mô tả:</label>
    <textarea class="form-control mr-2"  id="mota" name="mota" required></textarea><br>

    <input type="hidden" id="nhaCungCapID" name="nhaCungCapID" value="<%= session.getAttribute("selectedNCCId") %>">

    <input class="btn btn-success"  type="submit" value="Thêm mới">
</form>

</body>
</html>
