<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/searchAll">

<input type="submit">

</form>

<table border="1">
<tr>
<th>Employee ID</th>
<th>Name</th>

</tr>
<logic:iterate id="result" name="searchForm" property="results">
<tr>
<td><bean:write name="result" property="ssNum"/></td>
<td><bean:write name="result" property="name"/></td>

</tr>
</logic:iterate>
</table>

</body>
</html>