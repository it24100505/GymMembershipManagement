package com.gym;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/delete")
public class DeleteMemberServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));

        List<Member> list = FileUtil.readMembers();
        list.removeIf(m -> m.getId() == id);  // Use '==' to compare integers

        FileUtil.writeMembers(list);
        resp.sendRedirect("members");
    }
}
