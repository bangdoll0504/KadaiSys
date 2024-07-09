<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hospital Registration</title>
</head>
<body>
    <h1>Register a Hospital</h1>
    <form action="th_register" method="post">
        <label for="tabyouinid">ID:</label>
        <input type="text" id="tabyouinid" name="tabyouinid" required><br>
        <label for="tabyouinmei">Name:</label>
        <input type="text" id="tabyouinmei" name="tabyouinmei" required><br>
        <label for="tabyouinaddress">Address:</label>
        <input type="text" id="tabyouinaddress" name="tabyouinaddress" required><br>
        <label for="tabyouintel">Telephone:</label>
        <input type="text" id="tabyouintel" name="tabyouintel" required><br>
        <label for="tabyouinshihonkin">Capital:</label>
        <input type="number" id="tabyouinshihonkin" name="tabyouinshihonkin" required><br>
        <label for="kyukyu">Emergency Service (0 or 1):</label>
        <input type="number" id="kyukyu" name="kyukyu" min="0" max="1" required><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
