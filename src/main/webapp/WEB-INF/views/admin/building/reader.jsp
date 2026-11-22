<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="List" value="/admin/book/reader"/>
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
            <form:form modelAttribute="modelreader" action="${List}" method="get">
                <form:input class="timkiem" type="text" placeholder="Tìm kiếm..." path="fullname"/>

            </form:form>
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
                <c:forEach var="item" items="${readersevice}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.fullname}</td>
                    <td>${item.dataofbirth}</td>
                    <td>${item.gendername}</td>
                    <td>${item.address}</td>
                    <td>${item.phone}</td>
                    <td>${item.registrationdate}</td>
                    <td>${item.expirydate}</td>
                    <c:choose>
                        <c:when test="${item.statusCode==0}">
                        <td><span class="badge offline">${item.statusName}</span></td>
                        </c:when>
                        <c:when test="${item.statusCode==1}">
                        <td><span class="badge xanh">${item.statusName}</span></td>
                        </c:when>
                         <c:when test="${item.statusCode==2}">
                        <td><span class="badge ban">${item.statusName}</span></td>
                        </c:when>
                    </c:choose>
                    <td>
                        <div class="hanhdong">
                         <input type="hidden" name="id" value="${modelreader.id}">
                            <a class="sua" href="/admin/book/reader-${item.id}#form-docgia">Sửa</a>
                            <button class="xoa" type="button" id="delete" onclick="deletereader(${item.id}) " >Xóa</button>
                        </div>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
<div class="modal" id="form-docgia">
    <div class="modal-box">
        <h1>Thông tin độc giả</h1>
        <form:form modelAttribute="modelreader" id="reader" method="get">
        <form:hidden path="id"/>
            <div class="form-list">
                <div class="form-box">
                    <label>Họ tên</label>
                    <form:input type="text" path="fullname" />
                </div>
                <div class="form-box">
                    <label>Ngày sinh</label>
                    <input type="date" name="dataofbirth" value="${modelreader.dataofbirth}" required/>
                </div>
                <div class="form-box">
                    <label>Giới tính</label>
                    <form:select path="gender">
                        <form:options items="${readergender}"/>
                    </form:select>
                </div>
                <div class="form-box">
                    <label>Địa chỉ</label>
                    <form:input type="text" path="address"/>
                </div>
                <div class="form-box">
                    <label>SĐT</label>
                    <form:input type="text" path="phone"/>
                </div>
                <div class="form-box">
                    <label>Ngày đăng ký</label>
                    <input type="date" name="registrationdate" value="${modelreader.registrationdate}" required/>
                </div>
                <div class="form-box">
                    <label>Ngày hết hạn</label>
                    <input type="date" name="expirydate" value="${modelreader.expirydate}" required/>
                </div>
                <div class="form-box">
                    <label>Trạng thái</label>
                    <form:select path="status">
                        <form:options items="${readerstatus}"/>
                    </form:select>
                </div>
            </div>
            <div class="modal-nut">
                <a type="button" class="btn-huy" id="cancel">Hủy</a>
                <c:if test="${not empty modelreader.id}">
                    <button class="btn-luu" type="submit">Sửa</button>
                </c:if>
                <c:if test="${empty modelreader.id}">
                    <button class="btn-luu" type="submit">Thêm</button>
                </c:if>
            </div>
        </form:form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
    $('#reader').submit(function (event) {
        event.preventDefault();
        var data={};
        var formdata = $('#reader').serializeArray();
        $.each(formdata, function (i, v) {
            if(v.name){
                data["" + v.name + ""] = v.value;
            }
        })
        if (!data.id) delete data.id;
        $.ajax({
            type:data.id ?"PUT" : "POST",
            url:"/api/reader",
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify(data),
            success: function(respond){
            console.log("cập nhật");
          },
          error: function (xhr, status, error) {
          console.log("Status:", xhr.status);
          console.log("Response:", xhr.responseText);
          console.log("Error:", error);
          }
        })
    })
    function deletereader(id){
             $.ajax({
            type:"DELETE",
            dataType:"json",
            contentType:"application/json",
            data:{id:id},
            url:"/api/reader/"+id,
            ssuccess: function () {
            alert("Xóa thành công!");
            window.location.href = "/admin/book/reader";
            },
        error: function (xhr, status, error) {
              console.log("Status:", xhr.status);
              console.log("Response:", xhr.responseText);
              console.log("Error:", error);
                }
        })
        }
    $("#cancel").click(function () {
        window.location.href="/admin/book/reader";
    })
</script>
</body>
</html>
