<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="bookList" value="/admin/book/edit"/>
  <!DOCTYPE html>
  <html lang="vi">
  <head>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>Sách - Quản lý thư viện</title>
      <link rel="stylesheet" href="/admin/css/sach.css">
  </head>
  <body>
      <section>
          <div class="menu">
              <div class="logo">Thư viện</div>
              <div class="menu-box">
                  <ul>
                      <li><a href="web/home">Tổng quan</a></li>
                      <li><a class="active" href="sach.html">Sách</a></li>
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
              <h1>Quản lý sách</h1>
              <span>Thông tin đầu sách, nhà xuất bản, tác giả và thể loại của từng cuốn.</span>
          </div>
          <div class="box-bang">
              <div class="box-tool">
                  <h2>Danh sách sách</h2>
                      <form:form id="listbook"
               modelAttribute="model"
               action="${bookList}"
               method="GET">

        <form:input class="timkiem"
                    type="text"
                    placeholder="Tìm kiếm..."
                    id="searchbook"
                    path="booktitle"/>

        <button class="btn-them" type="submit">
            + Tìm kiếm
        </button>
    </form:form>
                  <a class="btn-them" href="#form-sach">+ Thêm sách</a>

              </div>
              <div class="box-table" id="listform">
                  <table>
                      <thead>
                          <tr>
                              <th>Mã</th>
                              <th>Tên sách</th>
                              <th>Nhà xuất bản</th>
                              <th>Năm xuất bản</th>
                              <th>Tác giả</th>
                              <th>Thể loại</th>
                              <th>Thao tác</th>
                          </tr>
                      </thead>
                      <tbody>
                        <c:forEach var="item" items="${listmodel}">
                          <!-- dòng mẫu: thay bằng dữ liệu thật -->
                          <tr>
                              <td>${item.id}</td>
                              <td>${item.bookname}</td>
                              <td>${item.publisher}</td>
                              <td>${item.publishyear}</td>
                            <td>${item.author}</td>
                              <td>${item.category}</td>
                              <td>
                                  <div class="hanhdong">
                                      <a class="sua" href="#form-sach">Sửa</a>
                                      <button class="xoa" type="button">Xóa</button>
                                  </div>
                              </td>
                          </tr>
                          </c:forEach>
                      </tbody>
                  </table>
              </div>
          </div>
      </main>
      <div class="modal" id="form-sach">
      <div class="modal-box" id="form-book">
          <h1>Thông tin sách</h1>
          <form:form modelAttribute="model" id="listBook" method="get">

              <div class="form-list">
                  <div class="form-box">
                      <label for="bookname">Tên sách</label>
                      <input type="text" id="bookname"
                             name="bookname" required>
                  </div>

                  <div class="form-box">
                      <label for="publisherid">Nhà xuất bản</label>
                      <form:select path="publisherid">
                          <form:option value="">-- Chọn --</form:option>
                          <form:options items="${Listpublishers}"/>
                      </form:select>
                  </div>

                  <div class="form-box">
                      <label for="publishyear">Năm xuất bản</label>
                      <input type="number" id="publishyear"
                             name="publishyear" required>
                  </div>

                  <div class="form-box">
                      <label for="authorid">Tác giả</label>
                      <form:select path="author">
                          <form:option value="">-- Chọn --</form:option>
                           <form:options items="${listauthor}"/>
                      </form:select>
                  </div>

                  <div class="form-box">
                      <label for="role">Vai trò tác giả</label>
                      <select id="role" name="role">
                          <option value="Tác giả chính">Tác giả chính</option>
                          <option value="Đồng tác giả">Đồng tác giả</option>
                          <option value="Dịch giả">Dịch giả</option>
                      </select>
                  </div>
                  <div class="form-box">
                      <label for="categoryid">Thể loại</label>
                      <form:select path="category">
                          <form:option value="">-- Chọn --</form:option>
                           <form:options items="${listcategory}"/>
                      </form:select>
                  </div>
                  <div class="form-box">
                      <label for="booktilte">Tiêu đề sách</label>
                      <input type="text" id="booktilte" name="booktitle">

                  </div>
              </div>

              <div class="modal-nut">
                  <a class="btn-huy" id="cancel" href="#">Hủy</a>
                  <button class="btn-luu" type="submit" id="addbook">Lưu</button>
              </div>
          </form:form>
      </div>
  </div>
  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script>
      $('#listBook').submit(function(event){
          event.preventDefault();
          var data = {};
          var formData = $('#listBook').serializeArray();
          $.each(formData,function(i,v){
              if(v.name){
                  data["" + v.name + ""]=v.value;
              }
          })
          //call api
      $.ajax({
          type: "POST",
          url:"/api/book",
          //client
          data:JSON.stringify(data),
          contentType:"application/json",
          //sever
          dataType:"JSON",
          success: function(respond){
              console.log("success")
          },
          error: function (xhr, status, error) {
          console.log("Status:", xhr.status);
          console.log("Response:", xhr.responseText);
          console.log("Error:", error);
  }
      })
      $.ajax({
      type:"GET",
      url:"http://localhost:8081/api/book",
      data:JSON.stringify(data),
      contentType:"application/json",
      dataType:"JSON",
      success: function(respond){
        var row="";
        $.each(respond,function(i,v){
            row += "<tr>";
            row += "<td>"+v.id+"</td>";
            row += "<td>"+v.bookname+"</td>";
            row += "<td>"+v.publisherid+"</td>";
            row += "<td>"+v.publishyear+"</td>";
            row += "<td>"+v.author+"</td>";
            row += "<td>"+v.category+"</td>";
            row += "</tr>";
        });
          $('#bookTable tbody').html(row);
      }})
      });
      $('#cancel').click(function(){
          window.location.href="/admin/book/edit";
      });

  </script>
   </body>

  </html>
