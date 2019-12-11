<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理页面</title>
<link href="/public/css/bootstrap.min.css" rel="stylesheet">
<link href="/public/css/cms.css" rel="stylesheet">
</head>
<body>
	<nav class="nav justify-content-end" style="background-color: #563d7c;">
		  <a class="nav-link" href="#">CMS内容管理系统</a>
		  <a class="nav-link" href="http://127.0.0.1/" target="_blank">访问官网</a>
		  <a class="nav-link" href="#">管理员</a>
		  <a class="nav-link" href="#">退出</a>		  
	</nav>
	<div class="container-fluid">
		<div class="row" style="margin-top: 15px;">
		  <div class="col-3">
		    <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
		      <a class="nav-link" id="v-pills-profile-tab">后台首页</a>
		      <a class="nav-link  active" id="v-pills-profile-tab">用户管理</a>
		      <a class="nav-link" id="v-pills-profile-tab">文章管理</a>
		    </div>
		  </div>
		  <div class="col-9">
		    <div class="tab-content" id="v-pills-tabContent">
		    
		    	<form class="form-inline">
				  <div class="form-group mx-sm-3 mb-2">
				    <input type="text" class="form-control" placeholder="请输入登录名">
				  </div>
				  <div class="form-group mx-sm-3 mb-2">
				    <input type="text" class="form-control" placeholder="请输入昵称">
				  </div>
				  <button type="submit" class="btn btn-primary mb-2">查询</button>
				</form>
		    
				<table class="table">
					  <thead>
					    <tr>
					      <th scope="col">#</th>
					      <th scope="col">First</th>
					      <th scope="col">Last</th>
					      <th scope="col">Handle</th>
					      <th scope="col">操作</th>
					    </tr>
					  </thead>
					  <tbody>
					    <tr>
					      <th scope="row">1</th>
					      <td>Mark</td>
					      <td>Otto</td>
					      <td>@mdo</td>
					      <td>
					      	<button type="button" class="btn btn-primary">修改</button>
					      </td>
					    </tr>
					    <tr>
					      <th scope="row">2</th>
					      <td>Jacob</td>
					      <td>Thornton</td>
					      <td>@fat</td>
					      <td>
					      	<button type="button" class="btn btn-primary">修改</button>
					      </td>
					    </tr>
					    <tr>
					      <th scope="row">3</th>
					      <td>Larry</td>
					      <td>the Bird</td>
					      <td>@twitter</td>
					      <td>
					      	<button type="button" class="btn btn-primary">修改</button>
					      </td>
					    </tr>
					  </tbody>
					</table>
					
					<div class="row">
						<nav aria-label="Page navigation example col-5">
							<button type="button" class="btn btn-primary">添加</button>
							<button type="button" class="btn btn-primary">批删</button>
						</nav>
						<nav aria-label="Page navigation example col-4 offset-1">
						  <ul class="pagination">
						    <li class="page-item"><a class="page-link" href="#">首页</a></li>
						    <li class="page-item"><a class="page-link" href="#">上一页</a></li>
						    <li class="page-item"><a class="page-link" href="#">1</a></li>
						    <li class="page-item"><a class="page-link" href="#">2</a></li>
						    <li class="page-item"><a class="page-link" href="#">3</a></li>
						    <li class="page-item"><a class="page-link" href="#">下一页</a></li>
						    <li class="page-item"><a class="page-link" href="#">尾页</a></li>
						  </ul>
						</nav>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
</body>
</html>