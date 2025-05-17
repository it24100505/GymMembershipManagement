package com.gym;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.util.*;

@WebServlet("/add")
public class AddMemberServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Member> list = FileUtil.readMembers();
        int id = list.size() + 1;
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String renewalDate = req.getParameter("renewalDate");


        list.add(new Member(id, name, age, renewalDate));
        FileUtil.writeMembers(list);

        resp.sendRedirect("members");
    }
}
