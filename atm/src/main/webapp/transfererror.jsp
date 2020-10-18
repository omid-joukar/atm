<%--
  Created by IntelliJ IDEA.
  User: omid
  Date: 10/7/2020
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Transfer Error</title>
</head>
<body>
<%String errorMessage = (String) request.getAttribute("errorMessage");
if (errorMessage == null){
    response.sendError(HttpServletResponse.SC_BAD_REQUEST);
    return;
}else {%>
<h1><%=errorMessage%></h1>
<%}%>
<a href="<%=request.getServletContext().getContextPath()%>/customerAbil.html">Back To Customer Menu</a>
</body>
</html>
