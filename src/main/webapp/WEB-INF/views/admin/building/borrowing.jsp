<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="list" value="/admin/book/borrow"/>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mượn trả - Quản lý thư viện</title>
    <link rel="stylesheet" href="/admin/css/borrowing.css">
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
        <h1>Mượn trả sách</h1>
        <span>Lập phiếu mượn, theo dõi hạn trả và ghi nhận chi tiết sách khi độc giả trả lại.</span>
    </div>
    <div class="box-bang">
        <div class="box-tool">
            <h2>Phiếu mượn</h2>
            <form:form modelAttribute="modelloan" action="${list}" method="GET">
            <form:input class="timkiem" type="text" placeholder="Tìm kiếm..." path="readers"/>
            </form:form>
            <a class="btn-them" href="#form-phieumuon">+ Lập phiếu mượn</a>
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
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <!-- dòng mẫu: thay bằng dữ liệu thật -->
                <c:forEach var="item" items="${listmodelloan}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.readers}</td>
                    <td>${item.borrowdate}</td>
                    <td>${item.duedate}</td>
                    <c:choose>
                        <c:when test="${item.statuscode==0}">
                        <td><span class="badge quahan">${item.statusname}</span></td>
                        </c:when>
                          <c:when test="${item.statuscode==1}">
                        <td><span class="badge dangmuon">${item.statusname}</span></td>
                        </c:when>
                    </c:choose>
                    <td>
                        <div class="hanhdong">
                            <input type="hidden" name="id" value="${item.id}">
                            <a class="sua" href="/admin/book/borrow-${item.id}#form-phieumuon">Sửa</a>
                            <button class="xoa" type="button" onclick="deleteloan(${item.id})">Xóa</button>
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
            <h2>Chi tiết mượn</h2>
            <form:form modelAttribute="modelloandetail" action="${list}" method="get">
            <form:input class="timkiem" type="text" placeholder="Tìm kiếm..." path="loanid"/>
            </form:form>
            <a class="btn-them" href="#form-ctmuon">+ Thêm chi tiết</a>
        </div>
        <div class="box-table">
            <table>
                <thead>
                <tr>
                    <th>Mã CT</th>
                    <th>Mã phiếu mượn</th>
                    <th>Sách</th>
                    <th>Ngày trả thực tế</th>
                    <th>Tình trạng khi trả</th>
                    <th>Tiền phạt</th>
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <!-- dòng mẫu: thay bằng dữ liệu thật -->
                <c:forEach var="item" items="${listmodelloandetail}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.loanid}</td>
                    <td>${item.books}</td>
                    <td>${item.actualReturnDate}</td>
                    <td>${item.returnname}</td>
                    <td>
                        <div class="hanhdong">
                        <input type="hidden" name="id" value="${modelloandetail.id}">
                            <a class="sua" href="/admin/loandetail/borrow-${item.id}#form-ctmuon">Sửa</a>
                            <button class="xoa" type="button" onclick="deletedetail(${item.id})">Xóa</button>
                        </div>
                    </td>
                    <td>0</td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</main>
<div class="modal" id="form-phieumuon">
    <div class="modal-box">
        <h1>Thông tin phiếu mượn</h1>
        <form:form modelAttribute="modelloan" id="listloan" method="GET">
        <form:hidden path="id"/>
            <div class="form-list">
                <div class="form-box">
                    <label>Độc giả</label>
                    <form:select path="readerid">
                        <form:option value="">-- Chọn --</form:option>
                          <form:options items="${listreader}"/>
                    </form:select>
                </div>
                <div class="form-box">
                    <label>Ngày mượn</label>
                    <input type="date" name="borrowdate" value="${modelloan.borrowdate}" required>
                </div>
                <div class="form-box">
                    <label>Hạn trả</label>
                    <input type="date" name="duedate" value="${modelloan.duedate}" required>
                </div>
                <div class="form-box">
                    <label>Trạng thái</label>
                    <form:select path="status">
                        <form:options items="${liststatus}"/>
                    </form:select>
                </div>
            </div>
            <div class="modal-nut">
                <a class="btn-huy" id="cancel">Hủy</a>
                <c:if test="${not empty modelloan.id}">
                    <button class="btn-luu" type="submit">Sửa</button>
                </c:if>
                <c:if test="${empty modelloan.id}">
                    <button class="btn-luu" type="submit">Thêm</button>
                </c:if>
            </div>
        </form:form>
    </div>
</div>
<div class="modal" id="form-ctmuon">
    <div class="modal-box">
        <h1>Thông tin chi tiết mượn</h1>
        <form:form modelAttribute="modelloandetail" id="listloandetails" method="get">
            <form:hidden path="id"/>
            <div class="form-list">
                <div class="form-box">
                    <label>Mã phiếu mượn</label>
                    <form:select path="loanid">
                        <form:option value="">-- Chọn --</form:option>
                        <form:options items="${listloan}"/>
                    </form:select>
                </div>
                <div class="form-box">
                    <label>Sách</label>
                    <form:select path="bookid">
                        <form:option value="">-- Chọn --</form:option>
                        <form:options items="${listbook}"/>
                    </form:select>
                </div>
                <div class="form-box">
                    <label>Ngày trả thực tế</label>
                    <input type="date" name ="actualReturnDate" value="${modelloandetail.actualReturnDate}" required >
                </div>
                <div class="form-box">
                    <label>Tình trạng khi trả</label>
                    <form:select path="returnCondition">
                        <form:option value="">-- Chọn --</form:option>
                        <form:options items="${listreturn}"/>
                    </form:select>
                </div>
            </div>
            <div class="modal-nut">
                <a class="btn-huy" id="cancels">Hủy</a>
                <c:if test="${not empty modelloan.id}">
                    <button class="btn-luu" type="submit">Sửa</button>
                </c:if>
                 <c:if test="${empty modelloan.id}">
                    <button class="btn-luu" type="submit">Thêm</button>
                </c:if>
            </div>
        </form:form>
    </div>
</div>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script>
  $('#listloan').submit(function (event) {
    event.preventDefault();
    var data={};
    var formdata = $('#listloan').serializeArray();
    $.each(formdata, function (i, v) {
        data["" + v.name + ""]=v.value;
    })
    if (!data.id) delete data.id;
    $.ajax({
        type: data.id ? "PUT" : "POST",
        url: "/api/loan",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        success: function(respond){
              window.location.href="/admin/book/borrow";
          },
          error: function (xhr, status, error) {
          console.log("Status:", xhr.status);
          console.log("Response:", xhr.responseText);
          console.log("Error:", error);
    }
  })
  })
   function deleteloan(id) {
  $.ajax({
    type: "DELETE",
    url: "/api/loan/"+id,
    dataType: "json",
    data: JSON.stringify({id:id}),
    dataType: "json",
    success: function(respond){
        window.location.href="/admin/book/borrow";
    }
  })
  }
  $('#listloandetails').submit(function (event) {
    event.preventDefault();
    var data={};
    var formdata = $('#listloandetails').serializeArray();
    $.each(formdata, function (i, v) {
        data["" + v.name + ""]=v.value;
    })
     if (!data.id) delete data.id;
     $.ajax({
        type: data.id ? "PUT" : "POST",
        url: "/api/loandetail",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        success: function(respond){
              window.location.href="/admin/book/borrow";
          },
          error: function (xhr, status, error) {
          console.log("Status:", xhr.status);
          console.log("Response:", xhr.responseText);
          console.log("Error:", error);
    }
  })
  })
  function deletedetail(id){
     $.ajax({
        type: "DELETE",
        url: "/api/loandetail/"+id,
        dataType: "json",
        data: JSON.stringify({id:id}),
        contentType: "application/json",
        success: function(respond){
            window.location.href="/admin/book/borrow";
        },
        error: function (xhr, status, error) {
              console.log("Status:", xhr.status);
              console.log("Response:", xhr.responseText);
              console.log("Error:", error);
        }
      })
   }
   $('#cancel').click(function(){
          window.location.href="/admin/book/borrow";
   });
  $('#cancels').click(function(){
          window.location.href="/admin/book/borrow";
   });
</script>
</body>
