<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng ký tài khoản</title>
  <link rel="stylesheet" href="/admin/css/register.css">
</head>
<body>

<section class="box">
  <div class="box-form">

    <div class="logo">Thư viện</div>
    <p class="tieude">Đăng ký tài khoản hệ thống quản lý thư viện</p>

    <form action="dangnhap.html" method="get">

      <div class="form-box">
        <label>Họ tên</label>
        <input type="text" name="hoten"
               placeholder="Nhập họ tên" required>
      </div>

      <div class="form-box">
        <label>Số điện thoại</label>
        <input type="tel" name="sdt"
               placeholder="Nhập số điện thoại"
               pattern="[0-9]{9,11}"
               title="Số điện thoại gồm 9 đến 11 chữ số"
               required>
      </div>

      <div class="form-box">
        <label>Tên đăng nhập</label>
        <input type="text" name="taikhoan"
               placeholder="Nhập tên đăng nhập" required>
      </div>

      <div class="form-box">
        <label>Mật khẩu</label>
        <input type="password" name="matkhau"
               placeholder="Ít nhất 6 ký tự"
               minlength="6" required>
      </div>

      <div class="form-box">
        <label>Nhập lại mật khẩu</label>
        <input type="password" name="nhaplai"
               placeholder="Nhập lại mật khẩu"
               minlength="6" required>
      </div>

      <button class="btn-gui" type="submit">
        Đăng ký
      </button>

      <p class="chuyen">
        Đã có tài khoản?
        <a href="dangnhap.html">Đăng nhập ngay</a>
      </p>

    </form>
  </div>
</section>

</body>
</html>