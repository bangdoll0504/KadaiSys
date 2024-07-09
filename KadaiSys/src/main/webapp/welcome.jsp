<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%
    // session変数を再宣言しない
    if (session == null || session.getAttribute("empid") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String empid = (String) session.getAttribute("empid");
    int emprole = (Integer) session.getAttribute("userRole");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome, <%= empid %>!</h1>
    <ul>
        <% if (emprole == 1) { %>
            <li><a href="e_register.jsp">従業員登録</a></li>
            <li><a href="th_register.jsp">他病院登録</a></li>
        <% } else if (emprole == 2) { %>
            <li><a href="reception_menu.jsp">受付メニュー</a></li>
        <% } else if (emprole == 3) { %>
            <li><a href="doctor_menu.jsp">医師メニュー</a></li>
        <% } %>
    </ul>
    <a href="logout.jsp">ログアウト</a>
</body>
</html>
