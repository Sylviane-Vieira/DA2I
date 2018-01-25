<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html>

	<head>
		<title><bean:message key='index.title'/></title>
	</head>

	<body>

	<html:errors />

	<html:form action="/login">

		<table width="45%" border="0">
			<tr>
				<td><bean:message key='index.username' /></td>
				<td><html:text property="nom" /></td>
			</tr>
			<tr>
				<td><bean:message key='index.password' /></td>
				<td><html:password property="pass" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><html:submit /></td>
			</tr>
		</table>
	</html:form>

	<a href="addUser.jsp"><bean:message key='addUser'/></a>

	</body>

</html>
