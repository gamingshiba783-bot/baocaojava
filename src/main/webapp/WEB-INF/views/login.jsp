<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Đăng nhập</title>
  <link rel="stylesheet" href="/admin/css/login.css">
</head>
<body>
<section>
  <div class="box">
    <div class="box-form">
      <div class="logo">Thư viện</div>
      <p class="tieude">Hệ thống quản lý thư viện</p>
      <input type="radio" name="tab" id="tab-dn" checked hidden>
      <input type="radio" name="tab" id="tab-dk" hidden>
      <div class="tab-box">
        <label class="tab tab-dn" for="tab-dn">Đăng nhập</label>
        <label class="tab tab-dk" for="tab-dk">Đăng ký</label>
      </div>
      <form class="form form-dn" action="index.html">
        <div class="form-box">
          <label>Tên đăng nhập</label>
          <input type="text" name="taikhoan" placeholder="Nhập tên đăng nhập" required>
        </div>
        <div class="form-box">
          <label>Mật khẩu</label>
          <input type="password" name="matkhau" placeholder="Nhập mật khẩu" required>
        </div>
        <button class="btn-gui" type="submit">Đăng nhập</button>
        <p class="chuyen">Chưa có tài khoản? <label class="link" for="tab-dk">Đăng ký ngay</label></p>
      </form>
      <form class="form form-dk" action="dangnhap.html">
        <div class="form-box">
          <label>Họ tên</label>
          <input type="text" name="hoten" placeholder="Nhập họ tên" required>
        </div>
        <div class="form-box">
          <label>Số điện thoại</label>
          <input type="text" name="sdt" placeholder="Nhập số điện thoại" pattern="[0-9]{9,11}" title="Số điện thoại gồm 9 đến 11 chữ số" required>
        </div>
        <div class="form-box">
          <label>Tên đăng nhập</label>
          <input type="text" name="taikhoan" placeholder="Nhập tên đăng nhập" required>
        </div>
        <div class="form-box">
          <label>Mật khẩu</label>
          <input type="password" name="matkhau" placeholder="Ít nhất 6 ký tự" minlength="6" required>
        </div>
        <div class="form-box">
          <label>Nhập lại mật khẩu</label>
          <input type="password" name="nhaplai" placeholder="Nhập lại mật khẩu" minlength="6" required>
        </div>
        <button class="btn-gui" type="submit">Đăng ký</button>
        <p class="chuyen">Đã có tài khoản? <label class="link" for="tab-dn">Đăng nhập</label></p>
      </form>
    </div>
  </div>
</section>
</body>
</html>
