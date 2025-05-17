<%@ page import="java.util.*, com.gym.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gym Members</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #f4f4f4;
        }

        a.button {
            text-decoration: none;
            background-color: #28a745;
            color: white;
            padding: 8px 14px;
            border-radius: 4px;
            margin-bottom: 10px;
            display: inline-block;
        }

        a.button:hover {
            background-color: #218838;
        }

        .btn-edit {
            background-color: #007bff;
        }

        .btn-edit:hover {
            background-color: #0069d9;
        }

        .btn-delete {
            background-color: #dc3545;
        }

        .btn-delete:hover {
            background-color: #c82333;
        }

        .btn-sort {
            background-color: #ffc107;
            color: black;
        }

        .btn-sort:hover {
            background-color: #e0a800;
        }

    </style>
</head>
<body>

<h2>Gym Members</h2>
<a href="addMember.jsp" class="button">+ Add Member</a>

<%
    List<Member> members = (List<Member>) request.getAttribute("members");
    if (members != null && !members.isEmpty()) {
%>

<!-- Button for sorting members by Renewal Date -->
<form action="members" method="get">
    <button type="submit" name="sort" value="insertionSort" class="button btn-sort" style="margin-top: 10px;">
        Sort by Renewal Date
    </button>
</form>


<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>Renewal Date</th>
        <th>Actions</th>
    </tr>
    <%
        for (Member m : members) {
    %>
    <tr>
        <td><%= m.getId() %></td>
        <td><%= m.getName() %></td>
        <td><%= m.getAge() %></td>
        <td><%= m.getRenewalDate() %></td>
        <td>
<%--            <a href="editMember.jsp?id=<%= m.getId() %>" class="button btn-edit">Edit</a>--%>
    <a href="edit?id=<%= m.getId() %>" class="button btn-edit">Edit</a>
    <a href="delete?id=<%= m.getId() %>" class="button btn-delete" onclick="return confirm('Are you sure you want to delete this member?')">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
<%
} else {
%>
<p>No members found.</p>
<% } %>

</body>
</html>
