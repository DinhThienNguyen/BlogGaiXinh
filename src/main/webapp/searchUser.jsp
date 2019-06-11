<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">

<script src="resources/js/jquery-1.11.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/script.js"></script>
<style>
.col-right-search {
	padding-left: 57px;
}
.input-search{
    margin-bottom: 43px;
}

.img-search{
    width: 100%;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<a class="navbar-brand" href="MainPage.xhtml">BlogGaiXinh</a>
			

			
		</nav>

	<div class="container container-user" style="margin-top: 30px">

		<div class="container-search col-md-9">

        <div class="row" style="margin-bottom: 20px;">

            <div class="col-md-12">

                <form class="form-search" method="GET" action="searchUserController">

                    <div class="row">
                        <div class="col-md-6">
                                <div class="row">
                                        <div class=" col-md-6">
                                            <label><input type="radio" name="searchtype" value="user" checked>Người dùng</label>
                                        </div>
                                        <div class=" col-md-6">
                                            <label><input type="radio" name="searchtype" value="post">Bài viết</label>
                                        </div>
                                    </div>
                        </div>
                        <div class="col-md-6">
                                <div class="input-append">
                                        <input type="text" name="keyword" class="span2">
                                        <button type="submit" class="btn">Tìm kiếm</button>
                                    </div>
                        </div>
                    </div>

                    
                </form>

            </div>
        </div>


				<c:choose>
					<c:when test="${listUserEntity.isEmpty()}">
						<div class="not-image">Không có người dùng.</div>
					</c:when>
					<c:otherwise>
						
							<c:forEach items="${listUserEntity}" var="userEntity">
							
								<div class="row well">
									<div class="col-md-3">
										<img
											src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg"
											class="img-circle img-search">
									</div>
					
									<div class="col-md-9 col-right-search">
					
					
										<h3>${userEntity.getUsername()}</h3>
										<h6>Họ tên: ${userEntity.getFullname()}</h6>
										<h6>Email: ${userEntity.getEmail()}</h6>
										<h6>Giới tính:
											 ${userEntity.getGender() == 'male' ? 'Nam' : ''}
											 ${userEntity.getGender() == 'female' ? 'Nữ' : ''}
											 ${userEntity.getGender() == 'select' ? 'Không xác định' : ''}
										</h6>
										<h6>
											<a href="userDetailController?userID=${userEntity.getId()}">Xem thêm... </a>
										</h6>
					
					
									</div>
								</div>
							</c:forEach>
					
					</c:otherwise>
				</c:choose>


			
		
		</div>


	</div>

	<script type="text/javascript">
		
	</script>

</body>
</html>