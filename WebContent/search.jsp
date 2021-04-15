<%@ taglib uri="/WEB-INF/tlds/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tlds/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-logic.tld" prefix="logic" %>

<html>
<head>
<title>ABC, Inc. Human Resources Portal - Employee Search</title>
</head>
<body>

<font size="+1">
ABC, Inc. Human Resources Portal - Employee Search
</font><br>
<hr width="100%" noshade="true">

<html:errors/>

<html:form action="/search">

<table>
<tr>
<td align="right"><bean:message key="label.search.name"/>:</td>
<td><html:text property="name"/></td>
</tr>
<tr>
<td></td>
<td>-- or --</td>
</tr>
<tr>
<td align="right"><bean:message key="label.search.ssNum"/>:</td>
<td><html:text property="ssNum"/> (xxx-xx-xxxx)</td>
</tr>
<tr>
<td></td>
<td><html:submit/></td>
</tr>
</table>

</html:form>

<logic:present name="searchForm" property="results">

<hr width="100%" size="1" noshade="true">

<bean:size id="size" name="searchForm" property="results"/>
<logic:equal name="size" value="0">
<center><font color="red"><b>No Employees Found</b></font></center>
</logic:equal>

<logic:greaterThan name="size" value="0">
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
</logic:greaterThan>

</logic:present>

</body>
</html>
