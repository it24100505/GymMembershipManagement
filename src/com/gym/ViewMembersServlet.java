package com.gym;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;

@WebServlet("/members")
public class ViewMembersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Member> members = FileUtil.readMembers();

        // Check if we need to sort by renewal date
        String sortAction = req.getParameter("sort");
        if (sortAction != null && sortAction.equals("insertionSort")) {
            members = insertionSortByRenewalDate(members);
        }

        req.setAttribute("members", members);
        RequestDispatcher rd = req.getRequestDispatcher("/view.jsp");
        rd.forward(req, resp);
    }

    private List<Member> insertionSortByRenewalDate(List<Member> list) {
        for (int i = 1; i < list.size(); i++) {
            Member current = list.get(i);
            String currentRenewalDate = current.getRenewalDate();
            int j = i - 1;

            // Move elements of list[0..i-1], that are greater than currentRenewalDate, to one position ahead
            while (j >= 0 && list.get(j).getRenewalDate().compareTo(currentRenewalDate) > 0) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, current);
        }
        return list;
    }
}
