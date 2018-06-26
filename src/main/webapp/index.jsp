<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inmeijia demo</title>
<link href="<%=request.getContextPath()%>/resources/css/style_log.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/userpanel.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/jquery.ui.all.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/google_jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/template-web.js"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/login.js"></script>
</head>
<body class="login" mycollectionplug="bind">
	<div class="login_m div-inline">

		<div class="login_boder">

			<div class="login_padding" id="login_model">

				<h2>用户名</h2>
				<input type="hidden" id="user_id" value="">
				<label> <input type="text" id="user_name"
					class="txt_input txt_input2">
				</label>

				<h2>性别</h2>
				<label> <input type="radio" name="usersex" id="user_sex"
					value="0" checked>男&nbsp;&nbsp;&nbsp;&nbsp;
				</label> <label> <input type="radio" name="usersex" id="user_sex"
					value="1">女
				</label>

				<h2>密码</h2>
				<label> <input type="password" name="textfield2"
					id="user_password" class="txt_input">
				</label>

				<div class="rem_sub">
					<div class="rem_sub_l">

						<label><input type="button" class="save_button" value="保存"
							style="opacity: 0.7;"></label>
					</div>
					<label> <input type="button" class="findall_button"
						value="查询所有用户" style="opacity: 0.7;">
					</label>
				</div>
			</div>

			<!--login_padding  Sign up end-->
		</div>
		<!--login_boder end-->
	</div>
	<!--login_m end-->

	<div class="list div-inline">
		<div class="list_boder">
			<div class="list_padding">
				<div class="list_title">&nbsp;&nbsp;用户查询列表</div>
				<div style="padding-top: 10px;">
					<div class="list_attr">序号</div>
					<div class="list_attr">用户名</div>
					<div class="list_attr">性别</div>
					<div class="list_attr">操作</div>
				</div>
				<div class="list_context_border">
					
				</div>

			</div>
		</div>
	</div>

	<script id="list_template" type="text/html">
	{{each model as item i }}
        <div class="list_context">
			<div class="context_fl context_sequence">{{ i+1 }}</div>
			<div class="context_id" hidden>{{item.user_id}}</div>
			<div class="context_fl context_name">{{item.user_name}}</div>
			<div class="context_fl context_sex">{{if item.user_sex == 0}} 男  {{else if item.user_sex == 1}} 女 {{/if}}</div>
		    <div class="context_fl">
				<span class="context_update oper_style">修改&nbsp;</span>
				<span class="context_delete oper_style">删除</span>
			</div>			
		</div>
    {{/each}}
	</script>

</body>
</html>