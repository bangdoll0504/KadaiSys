<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome to Employee Management System</h1>
    
    <%-- ユーザー名やその他の歓迎メッセージを表示する --%>
    <% 
        String empid = (String) session.getAttribute("empid");
        Integer userRole = (Integer) session.getAttribute("userRole");
    %>
    
    <p>Welcome, <%= empid %>!</p>
    
    <%-- 役割に基づいてリンクを表示する --%>
    <% if (userRole != null) { %>
        <% if (userRole == 1) { %>
            <p><a href="e_register.jsp">従業員登録</a></p>
        <% } %>
        <!-- 他の役割に応じたリンクや操作をここに追加できます -->
    <% } %>
    
    <p><a href="logout.jsp">Logout</a></p>
</body>
</html>
