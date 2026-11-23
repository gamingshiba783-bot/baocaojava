<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
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
                    path="bookname"/>

        <button class="btn-them" type="submit">
            + Tìm kiếm
        </button>
    </form:form>
                  <a class="btn-them" href="/admin/book/edit#form-sach">+ Thêm sách</a>

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
                          <tr>
                              <td>${item.id}</td>
                              <td>${item.bookname}</td>
                              <td>${item.publisher}</td>
                              <td>${item.publishyear}</td>
                            <td>${item.author}</td>
                              <td>${item.category}</td>
                              <td>
                                  <div class="hanhdong">
                                  <input type="hidden" name="id" value="${model.id}">
                                      <a class="sua" href="/admin/book/edit-${item.id}#form-sach">Sửa</a>
                                      <button class="xoa" type="button" onclick="deleteBook(${item.id})">Xóa</button>
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
               <form:hidden path="id" id="Bookid"/>
              <div class="form-list">
                  <div class="form-box">
                      <label for="bookname">Tên sách</label>
                      <input type="text" value="${model.bookname}"
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
                      <input type="number" value="${model.publishyear}"
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
                      <form:select path="role">
                          <form:options items="${rolecode}"/>
                      </form:select>
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
                  <c:if test="${not empty model.id}">
                   <button class="btn-luu" type="submit" id="addbook">Sửa</button>
                    </c:if>
                  <c:if test="${empty model.id}">
                  <button class="btn-luu" type="submit" id="addbook">Thêm</button>
                    </c:if>
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
          type:data.id ? "PUT":"POST",
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
      });
      $('#cancel').click(function(){
          window.location.href="/admin/book/edit";
      });
        function deleteBook(id){
            $.ajax({
            type:"DELETE",
              url:"/api/book/"+id,
              //client
              data:JSON.stringify({id:id}),
              contentType:"application/json",
              //sever
              dataType:"JSON",
              success: function(respond){
                  console.log("success")
                  window.location.reload();
              },
              error: function (xhr, status, error) {
              console.log("Status:", xhr.status);
              console.log("Response:", xhr.responseText);
              console.log("Error:", error);
                }
                     })
            }
  </script>
   </body>

  </html>
