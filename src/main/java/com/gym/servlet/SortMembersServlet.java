package com.gym.servlet;

import com.gym.model.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.RequestDispatcher;

import java.io.*;
import java.util.*;

@WebServlet("/sortMembers")
public class SortMembersServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Member> members = readMembersFromFile("C:\\Users\\Juu\\IdeaProjects\\GymMembershipManagement\\members.txt");

        // Insertion Sort by renewal date
        for (int i = 1; i < members.size(); i++) {
            Member key = members.get(i);
            int j = i - 1;

            while (j >= 0 && members.get(j).getRenewalDate().compareTo(key.getRenewalDate()) > 0) {
                members.set(j + 1, members.get(j));
                j--;
            }
            members.set(j + 1, key);
        }

        request.setAttribute("sortedMembers", members);
        RequestDispatcher dispatcher = request.getRequestDispatcher("sortMembers.jsp");
        dispatcher.forward(request, response);
    }

    //reading part
    private List<Member> readMembersFromFile(String filepath) {
        List<Member> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    list.add(new Member(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
