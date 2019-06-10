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

</head>
<body>

	<div class="container container-user">
		<div class="row">
			<div class="panel panel-default">

				<div class="panel-body panel-user">
					<div class="col-image col-md-4 col-xs-12 col-sm-6 col-lg-4">
						<img alt="User Pic"
							src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg"
							id="profile-image1"
							class="img-circle img-responsive user-image-profile">

					</div>

					<div class="col-md-8 col-xs-12 col-sm-6 col-lg-8">
						<div>
							<h2 class="name-profile">${userEntity.getUsername()}</h2>
							<c:if test="${(userIDLogin != null) && (userIDLogin == userID)}">
								<a class="btn btn-default edit-profile" href="userEditController">Edit
									Profile</a>
							</c:if>

						</div>

						<hr>

						<ul class="user-list-tool">
							<li class="Y8-fY "><span class="-nal3 "><span
									class="g47SY ">115</span> posts</span></li>
							<li class="Y8-fY "><a class="-nal3 "
								href="/mtsinichi/followers/"><span class="g47SY " title="80">80</span>
									up votes</a></li>
							<li class="Y8-fY "><a class="-nal3 "
								href="/mtsinichi/following/"><span class="g47SY ">498</span>
									down votes</a></li>
						</ul>

						<div class="details">
							<span>${userEntity.getBio()}</span>
						</div>
					</div>
				</div>
			</div>

			<div class="row">

				<c:choose>
					<c:when test="${imagePaths.isEmpty()}">
						<div class="not-image">Don't have image.</div>
					</c:when>
					<c:otherwise>
						<div class="images">
							<c:forEach items="${imagePaths}" var="path">
								<div class="image-item">
									<img
										alt="Image may contain: sky, ocean, twilight, outdoor, nature and water"
										class="FFVAD" decoding="auto" sizes="293px"
										src="<c:out value="${path}"/>" style="object-fit: cover;">
								</div>
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
</body>
</html>