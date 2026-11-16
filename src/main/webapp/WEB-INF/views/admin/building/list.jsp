<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="list" value="/admin/list/alllist"/>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Danh mục - Quản lý thư viện</title>
  <link rel="stylesheet" href="/admin/css/list.css">
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
    <h1>Danh mục</h1>
    <span>Quản lý tác giả, thể loại và nhà xuất bản dùng chung cho toàn bộ kho sách.</span>
  </div>
  <div class="box-bang">
    <div class="box-tool">
      <h2>Tác giả</h2>
      <form:form id="author" modelAttribute="modelauthor" action="${list}" method="get">
      <form:input class="timkiem"  placeholder="Tìm kiếm..." path="authorname"/>
       <button class="btn-them" type="submit">+ Tìm kiếm</button>
      </form:form>
       <a class="btn-them" href="#form-tacgia">+ Thêm tác giả</a>
    </div>
    <div class="box-table">
      <table>
        <thead>
        <tr>
          <th>Mã</th>
          <th>Tên tác giả</th>
          <th>Năm sinh</th>
          <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <!-- dòng mẫu -->
        <c:forEach var="item" items="${listmodelauthor}">
        <tr>

          <td>${item.id}</td>
          <td>${item.authorname}</td>
          <td>${item.birthyear}</td>
          <td>
            <div class="hanhdong">
            <input type="hidden" name="id" value="${modelauthor.id}">
              <a class="sua" href="/admin/author/list-${item.id}#form-tacgia">Sửa</a>
              <button class="xoa" type="button" onclick="deleteauthor(${item.id})">Xóa</button>
            </div>
          </td>

        </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  <div class="box-bang">
    <div class="box-tool">
      <h2>Thể loại</h2>
      <form:form modelAttribute="modelcategory" action="${list}" method="get">
      <form:input class="timkiem" type="text" placeholder="Tìm kiếm..." path="categoryname"/>
      <a class="btn-them" href="#form-theloai">+ Thêm thể loại</a>
      </form:form>
    </div>
    <div class="box-table">
      <table>
        <thead>
        <tr>
          <th>Mã</th>
          <th>Tên thể loại</th>
          <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="item" items="${listmodelcategory}">
        <!-- dòng mẫu -->
        <tr>
          <td>${item.id}</td>
          <td>${item.categoryname}</td>
          <td>
            <div class="hanhdong">
            <input type="hidden" name="id" value="${modelcategory.id}">
              <a class="sua" href="/admin/category/list-${item.id}#form-theloai">Sửa</a>
              <button class="xoa" type="button" onclick="deletecategory(${item.id})">Xóa</button>
            </div>
          </td>
        </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  <div class="box-bang">
    <div class="box-tool">
      <h2>Nhà xuất bản</h2>
      <form:form modelAttribute="modelpublish" action="${list}" method="get">
      <form:input class="timkiem" type="text" placeholder="Tìm kiếm..." path="publishername"/>
      <a class="btn-them" href="#form-nxb">+ Thêm nhà xuất bản</a>
      </form:form>
    </div>
    <div class="box-table">
      <table>
        <thead>

        <tr>
          <th>Mã</th>
          <th>Tên NXB</th>
          <th>Địa chỉ</th>
          <th>Điện thoại</th>
          <th>Email</th>
          <th>Thao tác</th>
        </tr>
        </thead>
        <tbody>
        <!-- dòng mẫu -->
        <tr>
        <c:forEach var="item" items="${listmodelpublish}">
          <td>${item.id}</td>
          <td>${item.publishername}</td>
          <td>${item.address}</td>
          <td>${item.phone}</td>
          <td>${item.email}</td>
          <td>
            <div class="hanhdong">
            <input type="hidden" name="id" value="${modelpublish.id}">
              <a class="sua" href="/admin/publisher/list-${item.id}#form-nxb">Sửa</a>
              <button class="xoa" type="button" onclick="deletepublish(${item.id}) ">Xóa</button>
            </div>
          </td>
        </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</main>
<div class="modal" id="form-tacgia">
  <div class="modal-box">

    <h1>Thông tin tác giả</h1>
    <form:form modelAttribute="modelauthor" id="listauthor" method="get">
     <form:hidden path="id"/>
      <div class="form-list">
        <div class="form-box">
          <label>Tên tác giả</label>
          <form:input type="text" path="authorname"/>
        </div>
        <div class="form-box">
          <label>Năm sinh</label>
          <form:input  path="birthyear" type="number"/>
        </div>
      </div>
      <div class="modal-nut">
        <a class="btn-huy" id="cancel">Hủy</a>
        <c:if test="${not empty modelauthor.id}">
        <button class="btn-luu" type="submit">Sửa</button>
        </c:if>
        <c:if test="${empty modelauthor.id}">
        <button class="btn-luu" type="submit">Thêm</button>
        </c:if>
      </div>
    </form:form>
  </div>
</div>
<div class="modal" id="form-theloai">
  <div class="modal-box">
    <h1>Thông tin thể loại</h1>
    <form:form modelAttribute="modelcategory" id="listcategory" method="get">
     <form:hidden path="id"/>
      <div class="form-list">
        <div class="form-box">
          <label>Tên thể loại</label>
          <form:input type="text" path="categoryname"/>
        </div>
      </div>
      <div class="modal-nut">
        <a class="btn-huy" id="cancel">Hủy</a>
        <c:if test="${not empty modelcategory.id}">
        <button class="btn-luu" type="submit">Sửa</button>
        </c:if>
         <c:if test="${empty modelcategory.id}">
        <button class="btn-luu" type="submit">Thêm</button>
        </c:if>
      </div>
      </form:form>
  </div>
</div>
<div class="modal" id="form-nxb">
  <div class="modal-box">
    <h1>Thông tin nhà xuất bản</h1>
    <form:form modelAttribute="modelpublish" id="listpublish" method="get">
     <form:hidden path="id"/>
      <div class="form-list">
        <div class="form-box">
          <label>Tên NXB</label>
          <form:input type="text" path="publishername"/>
        </div>
        <div class="form-box">
          <label>Địa chỉ</label>
          <form:input type="text" path="address"/>
        </div>
        <div class="form-box">
          <label>Điện thoại</label>
          <form:input type="text" path="phone"/>
        </div>
        <div class="form-box">
          <label>Email</label>
          <form:input type="text" path="email"/>
        </div>
      </div>
      <div class="modal-nut">
        <a class="btn-huy" id="cancel">Hủy</a>
         <c:if test="${not empty modelpublish.id}">
        <button class="btn-luu" type="submit">Sửa</button>
        </c:if>
         <c:if test="${empty modelpublish.id}">
        <button class="btn-luu" type="submit">Thêm</button>
        </c:if>
      </div>
    </form:form>
  </div>
</div>
</body>
</html>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script>
      $('#listauthor').submit(function(event){
          event.preventDefault();
          var data = {};
          var formData = $('#listauthor').serializeArray();
          $.each(formData,function(i,v){
              if(v.name){
                  data["" + v.name + ""]=v.value;
              }
          })
        if (!data.id) delete data.id;
        $.ajax({
          type: data.id ? "PUT" : "POST",
          url:"/api/author",
          data: JSON.stringify(data),
          contentType: "application/json",
          dataType: "json",
          success: function(respond){
            console.log("cập nhật");
          },
          error: function (xhr, status, error) {
          console.log("Status:", xhr.status);
          console.log("Response:", xhr.responseText);
          console.log("Error:", error);
          }
        })
      });

      $('#listcategory').submit(function(event){
        event.preventDefault();
        var data = {};
        var formData = $('#listcategory').serializeArray();
        $.each(formData,function(i,v){
          if(v.name){
            data["" + v.name + ""]=v.value;
          }
        })
        if (!data.id) delete data.id;
        $.ajax({
          type: data.id ? "PUT" : "POST",
          url:"/api/category",
          data: JSON.stringify(data),
          contentType: "application/json",
          dataType: "json",
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
      $('#listpublish').submit(function(event){
        event.preventDefault();
        var data = {};
        var formData = $('#listpublish').serializeArray();
        $.each(formData,function(i,v){
          if(v.name){
          data["" + v.name + ""]=v.value;
          }
        })
        if (!data.id) delete data.id;
         $.ajax({
          type: data.id ? "PUT" : "POST",
          url:"/api/publish/",
          data: JSON.stringify(data),
          contentType: "application/json",
          dataType: "json",
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
      $('.btn-huy').click(function (e) {
    e.preventDefault();
    window.location.href = "/admin/list/alllist";
    });
    function deleteauthor(id){
      $.ajax({
        type: "DELETE",
        dataType: "json",
        data: {id:id},
        contentType: "application/json",
        url: "/api/author/"+id,
        success: function(respond){
          console.log("xoa");
          window.location.reload();
        },
        error: function (xhr, status, error) {
              console.log("Status:", xhr.status);
              console.log("Response:", xhr.responseText);
              console.log("Error:", error);
                }
      })

    }
    function deletecategory(id){
      $.ajax({
        type: "DELETE",
        dataType: "json",
        data: {id:id},
        contentType: "application/json",
        url: "/api/category/"+id,
        success: function(respond){
          console.log("xoa");
          window.location.reload();
        },
        error: function (xhr, status, error) {
              console.log("Status:", xhr.status);
              console.log("Response:", xhr.responseText);
              console.log("Error:", error);
                }
      })
      }
      function deletepublish(id){
      $.ajax({
        type: "DELETE",
        dataType: "json",
        data: {id:id},
        contentType: "application/json",
        url: "/api/publish/"+id,
        success: function(){
          console.log("xoa");
          window.location.reload();
        },
        error: function (xhr, status, error) {
              console.log("Status:", xhr.status);
              console.log("Response:", xhr.responseText);
              console.log("Error:", error);
                }
      })
    }
    $('#cancel').click(function () {
      window.location.href = "/admin/list/alllist"
    })
  </script>