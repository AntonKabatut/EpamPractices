<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>part2</title>
</head>
<body>
    <table border="1">
        <c:forEach items="${map}" var="sport">
            <tr>
                <td>${sport.key}</td>
                <td>${sport.value.countOfVoices}</td>
                <td>${sport.value.users}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="index.jsp">back</a>

</body>
</html>
