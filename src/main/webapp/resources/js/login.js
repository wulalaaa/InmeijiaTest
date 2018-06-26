$(function() {

	function findAll() {
		$.ajax({
			type : "POST",
			url : "users/getAll",
			success : function(data) {
				if (data.success == true) {
					var html = template('list_template', {
						model : data.list
					});
					$(".list_context_border").html(html);
				}
			}
		});
	}

	function clearInput() {
		$("#user_id").val("");
		$("#user_name").val("");
		$("input[name='usersex']:eq(0)").prop("checked", 'checked');
		$("#user_password").val("");
	}

	$(".findall_button").on("click", function() {
		findAll();
	});

	$(".save_button").on("click", function() {
		var user_id = $("#user_id").val();
		var user_name = $("#user_name").val();
		var user_sex = $("input[name='usersex']:checked").val();
		var user_password = $("#user_password").val();
		$.ajax({
			type : "POST",
			url : "users/save",
			data : {
				user_id : user_id,
				user_name : user_name,
				user_sex : user_sex,
				user_password : user_password
			},
			success : function(data) {
				if (data.success == true) {
					alert("保存成功！");
					clearInput();
					findAll();
				} else if (data.success == false) {
					alert("用户名称重复！");
					clearInput();
				}
			}
		});
	});

	$(document).on(
			"click",
			".context_update",
			function() {
				var list_context = $(this).parents(".list_context");
				var user_id = list_context.children(".context_id").html();
				$.ajax({
					type : "POST",
					url : "users/getById",
					data : {
						user_id : user_id
					},
					success : function(data) {
						if (data.success == true) {
							var user = data.user;
							if (user == null) {
								alert("没有该用户！");
								return;
							}
							$("#user_id").val(user.user_id);
							$("#user_name").val(user.user_name);
							if (user.user_sex == "0") {
								$("input[name='usersex']:eq(0)").prop(
										"checked", 'checked');
							} else {
								$("input[name='usersex']:eq(1)").prop(
										"checked", 'checked');
							}
							$("#user_password").val(user.user_password);
						}
					}
				});
			});

	$(document).on("click", ".context_delete", function() {
		if (confirm("你确定要删除吗？")) {
			var list_context = $(this).parents(".list_context");
			var user_id = list_context.children(".context_id").html();
			$.ajax({
				type : "POST",
				url : "users/delete",
				data : {
					user_id : user_id
				},
				success : function(data) {
					if (data.success == true) {
						alert("成功删除！");
						findAll();
					}
				}
			});
		}
	});

});