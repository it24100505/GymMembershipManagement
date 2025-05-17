<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Member</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 30px;
        }

        h2 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: auto;
            background-color: #f9f9f9;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
            margin-top: 12px;
        }

        input[type="text"], input[type="number"], input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-top: 4px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .btn {
            margin-top: 18px;
            background-color: #28a745;
            color: white;
            padding: 10px 18px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 15px;
        }

        .btn:hover {
            background-color: #218838;
        }

        .back-link {
            display: block;
            margin-top: 20px;
            text-align: center;
        }

        .back-link a {
            text-decoration: none;
            color: #007bff;
        }

        .back-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h2>Add New Member</h2>
<form action="add" method="post">
    <label for="id">Member ID:</label>
    <input type="text" name="id" id="id" required>

    <label for="name">Name:</label>
    <input type="text" name="name" id="name" required>

    <label for="age">Age:</label>
    <input type="number" name="age" id="age" required>

    <label for="renewalDate">Renewal Date:</label>
    <input type="date" name="renewalDate" id="renewalDate" required>

    <button type="submit" class="btn">Add Member</button>
</form>

<div class="back-link">
    <a href="members">← Back to Members</a>
</div>
</body>
</html>
