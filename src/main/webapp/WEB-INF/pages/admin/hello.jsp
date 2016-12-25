<html>
<head>
	<meta charset="UTF-8">
	<% String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+':'+request.getServerPort()+path+'/';
	%>
	<script type="text/javascript" charset="utf-8" src="<%=basePath %>ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=basePath %>ueditor/ueditor.all.js"></script>
	<script type="text/javascript" charset="utf-8" src="<%=basePath %>ueditor/lang/zh-cn/zh-cn.js"></script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->

	<title>Document</title>

</head>
<body>
${message}
<div>
	<script id="editor" type="text/plain" style="width:100%;height:500px;">
	</script>
	<script>

		var ue = UE.getEditor('editor');
	</script>
</div>
</body>
</html>