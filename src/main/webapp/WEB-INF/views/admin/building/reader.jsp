<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Độc giả - Quản lý thư viện</title>
    <link rel="stylesheet" href="/admin/css/reader.css">
</head>
<body>
<section>
    <div class="menu">
        <div class="logo">Thư viện</div>
        <div class="menu-box">
            <ul>
                <li><a href="/admin/book">Tổng quan</a></li>
                <li><a href="/admin/book/edit">Sách</a></li>
                <li><a href="/admin/book/reader">Độc giả</a></li>
                <li><a href="/admin/book/borrow">Mượn trả</a></li>
                <li><a href="/admin/list/alllist">Danh mục</a></li>
            </ul>
        </div>
        <div class="user-box">
            <p>Quản trị viên</p>
            <a class="btn-dangxuat" href="dangnhap.html">Đăng xuất</a>
        </div>
    </div>
</section>
<main class="trang">
    <div class="box-title">
        <h1>Quản lý độc giả</h1>
        <span>Hồ sơ độc giả, ngày đăng ký, ngày hết hạn thẻ và trạng thái hoạt động.</span>
    </div>
    <div class="box-bang">
        <div class="box-tool">
            <h2>Danh sách độc giả</h2>
            <input class="timkiem" type="text" placeholder="Tìm kiếm...">
            <a class="btn-them" href="#form-docgia">+ Thêm độc giả</a>
        </div>
        <div class="box-table">
            <table>
                <thead>
                <tr>
                    <th>Mã</th>
                    <th>Họ tên</th>
                    <th>Ngày sinh</th>
                    <th>Giới tính</th>
                    <th>Địa chỉ</th>
                    <th>SĐT</th>
                    <th>Ngày đăng ký</th>
                    <th>Ngày hết hạn</th>
                    <th>Trạng thái</th>
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <!-- dòng mẫu: thay bằng dữ liệu thật -->
                <tr>
                    <td>1</td>
                    <td>Nguyễn Văn A</td>
                    <td>2004-05-12</td>
                    <td>Nam</td>
                    <td>Hà Nội</td>
                    <td>0901234567</td>
                    <td>2026-01-10</td>
                    <td>2027-01-10</td>
                    <td><span class="badge xanh">Hoạt động</span></td>
                    <td>
                        <div class="hanhdong">
                            <a class="sua" href="#form-docgia">Sửa</a>
                            <button class="xoa" type="button">Xóa</button>
                        </div>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</main>
<div class="modal" id="form-docgia">
    <div class="modal-box">
        <h1>Thông tin độc giả</h1>
        <form action="#">
            <div class="form-list">
                <div class="form-box">
                    <label>Họ tên</label>
                    <input type="text" required>
                </div>
                <div class="form-box">
                    <label>Ngày sinh</label>
                    <input type="date">
                </div>
                <div class="form-box">
                    <label>Giới tính</label>
                    <select>
                        <option>Nam</option>
                        <option>Nữ</option>
                        <option>Khác</option>
                    </select>
                </div>
                <div class="form-box">
                    <label>Địa chỉ</label>
                    <input type="text">
                </div>
                <div class="form-box">
                    <label>SĐT</label>
                    <input type="text" pattern="[0-9]{9,11}" title="Số điện thoại gồm 9 đến 11 chữ số">
                </div>
                <div class="form-box">
                    <label>Ngày đăng ký</label>
                    <input type="date">
                </div>
                <div class="form-box">
                    <label>Ngày hết hạn</label>
                    <input type="date">
                </div>
                <div class="form-box">
                    <label>Trạng thái</label>
                    <select>
                        <option>Hoạt động</option>
                        <option>Hết hạn</option>
                        <option>Khóa</option>
                    </select>
                </div>
            </div>
            <div class="modal-nut">
                <a class="btn-huy" href="#">Hủy</a>
                <button class="btn-luu" type="submit">Lưu</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
