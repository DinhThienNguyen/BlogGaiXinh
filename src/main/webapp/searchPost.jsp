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


	<div class="container container-user" style="margin-top: 30px">

	<div class="row">
	<div class="container-search col-md-9">

        <div class="row" style="margin-bottom: 20px;">

            <div class="col-md-12">

                <form class="form-search" method="GET" action="searchPostController">

                    <div class="row">
                        <div class="col-md-6">
                                <div class="row">
                                        <div class=" col-md-6">
                                            <label><input type="radio" name="searchtype" value="user" >Người dùng</label>
                                        </div>
                                        <div class=" col-md-6">
                                            <label><input type="radio" name="searchtype" value="post" checked>Bài viết</label>
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


				


			
		
		</div>
	</div>
	
	<div class="row">

				<c:choose>
					<c:when test="${imagePaths.isEmpty()}">
						<div class="not-image">Không có bài viết.</div>
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

	<script type="text/javascript">
		
	</script>

</body>
</html>