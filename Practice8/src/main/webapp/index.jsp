<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

  <head>
    <title>Part1</title>
  </head>

  <body>

    <form name="part1" action="calculator" method="post">

      <input name="number1" type="number" title="number1">

      <label>
        <select name="operation" title="operation">
          <option disabled>Select operation</option>
          <option value="+">+</option>
          <option value="-">-</option>
        </select>
      </label>

      <input name="number2" type="number" title="number2">

      <button type="submit" name="operation" title="operation">calculate</button>

    </form>

  <br/>

  <form name="part2" action="voting" method="post">

    <c:forEach items="${applicationScope.map}" var="sports">
      <label>${sports.key}</label><input type="radio" name="${sports.key}" value="${sports.key}" title="${sports.key}">
      <br/>
    </c:forEach>
    <input name="user" type="text" title="user">
    <br/>
    <button type="submit" value="choose" name="choose" >choose your sport</button>
  </form>
  ${error}

  </body>
</html>
