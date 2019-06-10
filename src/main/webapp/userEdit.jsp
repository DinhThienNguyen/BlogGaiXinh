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

		<div style="margin-top: 30px">
			<div class="row">

				<div class="box-change col-xs-12">
					<div class="col-xs-3">
						<!-- required for floating -->
						<!-- Nav tabs -->
						<ul class="nav nav-tabs tabs-left sideways">
							<li class="active"><a class="link-tab" href="#home-v"
								data-toggle="tab">Sửa tài khoản</a></li>
							<li><a class="link-tab" href="#profile-v" data-toggle="tab">Đổi
									mật khẩu</a></li>

						</ul>
					</div>

					<div class="col-xs-9 col-tab-right">
						<!-- Tab panes -->
						<div class="tab-content">
							<div class="tab-pane active" id="home-v">
								<form class="form-horizontal">
									<fieldset>

										<div class="form-group">
											<label class="col-md-3 control-label" for="fullName">
												<img alt="User Pic"
												src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg"
												id="profile-image1" class="img-circle user-image-tab">
											</label>
											<div class="col-md-6">
												<span class="lable-tab">mtSiniChi</span>

											</div>
										</div>

										<!-- Text input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="fullName">Họ
												tên</label>
											<div class="col-md-6">
												<input id="fullName" name="fullName" type="text"
													placeholder="" class="form-control input-md">

											</div>
										</div>

										<!-- Text input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="username">Tài
												khoản</label>
											<div class="col-md-6">
												<input id="username" name="username" type="text"
													placeholder="" class="form-control input-md">

											</div>
										</div>

										<!-- Text input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="email">Email</label>
											<div class="col-md-6">
												<input id="email" name="email" type="text" placeholder=""
													class="form-control input-md">

											</div>
										</div>

										<!-- Textarea -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="bio">Bio</label>
											<div class="col-md-6">
												<textarea class="form-control" id="bio" name="bio"></textarea>
											</div>
										</div>

										<!-- Select Basic -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="gender">Giới
												tính</label>
											<div class="col-md-3">
												<select id="gender" name="gender" class="form-control">
													<option value="0">Nam</option>
													<option value="1">Nữ</option>
													<option value="2">Khác</option>
												</select>
											</div>
										</div>

										<!-- Button -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="btnSubmit"></label>
											<div class="col-md-6">
												<button id="btnSubmit" name="btnSubmit"
													class="btn btn-default">Gửi</button>
											</div>
										</div>

									</fieldset>
								</form>

							</div>
							<div class="tab-pane" id="profile-v">
								<form class="form-horizontal">
									<fieldset>

										<div class="form-group">
											<label class="col-md-3 control-label" for="fullName">
												<img alt="User Pic"
												src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg"
												id="profile-image1" class="img-circle user-image-tab">
											</label>
											<div class="col-md-6">
												<span class="lable-tab">mtSiniChi</span>

											</div>
										</div>

										<!-- Text input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="fullName">Mật
												khẩu cũ</label>
											<div class="col-md-6">
												<input id="pass-old" name="fullName" type="text"
													placeholder="" class="form-control input-md">

											</div>
										</div>

										<!-- Text input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="username">Mật
												khẩu mới</label>
											<div class="col-md-6">
												<input id="pass-new" name="username" type="text"
													placeholder="" class="form-control input-md">

											</div>
										</div>

										<!-- Text input-->
										<div class="form-group">
											<label class="col-md-3 control-label" for="email">Nhập
												lại</label>
											<div class="col-md-6">
												<input id="pass-re" name="email" type="text" placeholder=""
													class="form-control input-md">

											</div>
										</div>

										<!-- Button -->
										<div class="form-group">
											<label class="col-md-3 control-label" for="btnSubmit"></label>
											<div class="col-md-6">
												<button id="btnSubmitPass" name="btnSubmit"
													class="btn btn-default">Gửi</button>
											</div>
										</div>

									</fieldset>
								</form>

							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

</body>
</html>