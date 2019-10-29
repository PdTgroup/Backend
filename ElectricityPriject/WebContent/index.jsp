<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>电网页面</title>
<style type="text/css">
/*表格样式*/
table {
	width: 90%;
	background: #ccc;
	margin: 10px auto;
	border-collapse: collapse;
	/*border-collapse:collapse合并内外边距(去除表格单元格默认的2个像素内外边距*/
}

th, td {
	height: 25px;
	line-height: 25px;
	text-align: center;
	border: 1px solid #ccc;
}

th {
	background: #eee;
	font-weight: normal;
}

tr {
	background: #fff;
}

tr:hover {
	background: #cc0;
}

td a {
	color: #06f;
	text-decoration: none;
}

td a:hover {
	color: #06f;
	text-decoration: underline;
}
</style>
</head>
<body>
<h1>手动录入数据页面</h1>

	<table>
		<tr>
			<th rowspan="2">主网测试准确率</th>
			<th>安阳</th>
			<th>鹤壁</th>
			<th>济源</th>
			<th>焦作</th>
			<th>开封</th>
			<th>洛阳</th>
			<th>漯河</th>
			<th>南阳</th>
			<th>平顶山</th>
			<th>濮阳</th>
			<th>三门峡</th>
			<th>商丘</th>
			<th>新乡</th>
			<th>信阳</th>
			<th>许昌</th>
			<th>郑州</th>
			<th>周口</th>
			<th>驻马店</th>
		</tr>
		<tr>
		<form action="${pageContext.request.contextPath}/ZHibiaoServlet" method="post">
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="text" name="text"></td>
			<td><input type="submit" name="text"  value="提交"></td>
			</form>
		</tr>
	</table>

</body>
</html>