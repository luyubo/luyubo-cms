<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>后台页面</title>
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<link href="/public/css/cms.css" rel="stylesheet">
</head>
<body>
	<div class="container-fluid">
		<div class="col-md-4 offset-4" style="margin-top: 100px;">
			<h3>CMS登录页面</h3>
			<form action="/admin/home">
			  <div class="form-group">
			    <label for="exampleInputEmail1">用户名</label>
			    <input type="email" class="form-control" placeholder="请输入用户名...">
			    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">密码</label>
			    <input type="password" class="form-control" placeholder="请输入密码..." id="exampleInputPassword1">
			  </div>
			  <div class="form-group form-check">
			    <input type="checkbox" class="form-check-input" id="exampleCheck1">
			    <label class="form-check-label" for="exampleCheck1">是否保存密码</label>
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
			  <label for="exampleInputPassword1">没有账号,去<a href="/">注册</a></label>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
</body>
</html>