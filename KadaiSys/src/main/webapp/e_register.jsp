<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <form action="e_register" method="post">
        <label for="empid">Employee ID:</label>
        <input type="text" id="empid" name="empid" required><br><br>
        
        <label for="empfname">First Name:</label>
        <input type="text" id="empfname" name="empfname"><br><br>
        
        <label for="emplname">Last Name:</label>
        <input type="text" id="emplname" name="emplname"><br><br>
        
        <label for="emppasswordd">Password:</label>
        <input type="password" id="emppasswordd" name="emppasswordd" required><br><br>
        
        <label for="emprole">Role:</label>
        <select id="emprole" name="emprole" required>
            <option value="1">Administrator</option>
            <option value="2">Receptionist</option>
            <option value="3">Doctor</option>
        </select><br><br>
        
        <input type="submit" value="Register">
    </form>
</body>
</html>
