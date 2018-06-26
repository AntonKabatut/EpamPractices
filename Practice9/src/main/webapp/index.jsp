<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <title>Practice10</title>
  </head>

  <body>

  <h3>With Screplets</h3>
  <br/>

  <table border="1">
    <%
      for (int i=1;i<10;i++){
    %>

      <tr>
        <%
        for (int j=1;j<10;j++){
        %>
        <td><%=(i*j)%></td>
        <%
          }
        %>
      </tr>

    <%
      }
    %>
  </table>
  <br/>
  <a href="multiplicationTable.jsp">part2</a>
  <br/>
  <a href="authorization.jsp">part4</a>

  </body>

</html>
