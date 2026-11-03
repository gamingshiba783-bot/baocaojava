<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tổng quan - Quản lý thư viện</title>
    <link rel="stylesheet" href="/admin/css/home.css">
</head>
<body>
    <section>
        <div class="menu">
            <div class="logo">Thư viện</div>
            <div class="menu-box">
                <ul>
                    <li><a class="active" href="index.html">Tổng quan</a></li>
                    <li><a href="/admin/book/edit">Sách</a></li>
                    <li><a href="docgia.html">Độc giả</a></li>
                    <li><a href="muontra.html">Mượn trả</a></li>
                    <li><a href="danhmuc.html">Danh mục</a></li>
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
            <h1>Tổng quan</h1>
            <span>Theo dõi nhanh tình hình sách, độc giả và các phiếu mượn đang diễn ra trong thư viện.</span>
        </div>
        <div class="container-number">
            <div class="number">
                <h1>0</h1>
                <p>đầu sách</p>
                <span>Trong kho</span>
            </div>
            <div class="number">
                <h1>0</h1>
                <p>độc giả</p>
                <span>Đã đăng ký</span>
            </div>
            <div class="number">
                <h1>0</h1>
                <p>đang mượn</p>
                <span>Phiếu chưa trả</span>
            </div>
            <div class="number">
                <h1>0</h1>
                <p>quá hạn</p>
                <span>Cần nhắc trả</span>
            </div>
            <div class="number">
                <h1>0</h1>
                <p>tiền phạt</p>
                <span>VNĐ đã thu</span>
            </div>
        </div>
        <div class="box-bang">
            <div class="box-tool">
                <h2>Phiếu mượn gần đây</h2>
                <a class="btn-them" href="muontra.html">Xem tất cả</a>
            </div>
            <div class="box-table">
                <table>
                    <thead>
                        <tr>
                            <th>Mã phiếu</th>
                            <th>Độc giả</th>
                            <th>Ngày mượn</th>
                            <th>Hạn trả</th>
                            <th>Trạng thái</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td>Nguyễn Văn A</td>
                            <td>2026-10-01</td>
                            <td>2026-10-15</td>
                            <td><span class="badge cam">Đang mượn</span></td>
                        </tr>
                        <tr>
                            <td class="trong" colspan="5">Không có dữ liệu</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </main>
</body>
</html>