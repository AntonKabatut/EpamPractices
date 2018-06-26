<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Part4</title>
</head>

<body>

    <form name="part4" action="Authorization" method="post">

        <input name="login" type="text" title="login">
        <br/>
        <input name="password" type="text" title="password">
        <br/>
        <button type="submit" name="send" title="send">log in</button>
        <br/>

    </form>
    ${error}
    <br/>
    <a href="index.jsp">back</a>

</body>
</html>
