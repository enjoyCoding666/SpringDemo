<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.Connection" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/5/9
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        try {
            System.out.println("<------------------开始数据源测试");
            String DSNMAE="java:comp/env/dao/worker";
            Context ctx=new InitialContext();
            DataSource ds=(DataSource)ctx.lookup(DSNMAE);
            Connection conn=ds.getConnection();
            System.out.println("<----------------结束数据源测试");
     %>
           <%=conn%>
           <% conn.close();%>
     <%
        }catch (Exception e) {
             e.printStackTrace();
        }

    %>

</body>
</html>
