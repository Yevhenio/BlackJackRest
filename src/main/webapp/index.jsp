<%--
  Created by IntelliJ IDEA.
  User: eugene
  Date: 06.10.15
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BlackJack Page</title>
</head>
<body>
<iframe name="frame" src="http://localhost:8080/black/rest/card/rand" width="300" height="300" align="left"></iframe>
<iframe name="frame" src="http://localhost:8080/black/rest/card/randD" width="300" height="300" align="right"></iframe>
<a href="http://localhost:8080/black/rest/card/get" type="submit">Get one more card</a>
<a href="http://localhost:8080/black/rest/card/start">Start</a>
<a href="http://localhost:8080/black/rest/card/res">Stand</a>

<form action="http://localhost:8080/black/rest/card/get">
    <input type="reset" >
</form>
</body>
</html>
