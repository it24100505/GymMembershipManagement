package com.gym;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;

@WebServlet("/edit")
public class EditMemberServlet extends HttpServlet {

    // Handles the GET request to show the edit form with existing member details
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id")); // Get ID from query param
        List<Member> list = FileUtil.readMembers(); // Read existing members

        for (Member m : list) {
            if (m.getId() == id) {
                req.setAttribute("member", m); // Set the member in request scope
                break;
            }
        }

        RequestDispatcher rd = req.getRequestDispatcher("editMember.jsp");
        rd.forward(req, resp); // Forward to the JSP
    }

    // Handles the POST request to update the member
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String renewalDate = req.getParameter("renewalDate");

        List<Member> list = FileUtil.readMembers();
        for (Member m : list) {
            if (m.getId() == id) {
                m.setName(name);
                m.setAge(age);
                m.setRenewalDate(renewalDate);
                break;
            }
        }

        FileUtil.writeMembers(list); // Write updated list back to file
        resp.sendRedirect("members"); // Redirect to the members page
    }
}
