<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Part3</title>
</head>
<body>
    <form name="part3" action="ListOfUsers" method="post">
        <input name="user" type="text" title="user">
        <br/>
        <button name="send" type="submit" title="send">add</button>
        <br/>
    </form>

    <table border="1">
        <c:forEach items="${list}" var="user">
            <tr>
                <td>${user}</td>
            </tr>
        </c:forEach>
    </table>

    <br/>

    <a href=${sessionScope.clear()}>remove</a>
    <br/>
    <a href="index.jsp">back</a>

</body>
</html>
