<%@ page import="java.util.*, com.gym.model.Member" %>
<html>
<head><title>Sorted Members</title></head>
<body>
<h2>Sorted Members by Last Renewal Date</h2>
<table border="1">
    <tr><th>Name</th><th>Renewal Date</th></tr>
    <%
        List<Member> members = (List<Member>) request.getAttribute("sortedMembers");
        if (members != null) {
            for (Member m : members) {
    %>
    <tr><td><%= m.getName() %></td><td><%= m.getRenewalDate() %></td></tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
