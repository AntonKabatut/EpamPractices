<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Part2</title>
</head>

<body>

    <h3>With JSTL</h3>
    <br/>

    <table border="1">
        <c:forEach begin="1" end="9" step="1" var="begin1">
            <tr>
                <c:forEach begin="1" end="9" step="1" var="begin">
                    <td>${begin*begin1}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>

    <br/>
    <a href="index.jsp">back</a>

</body>

</html>
