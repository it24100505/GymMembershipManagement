package com.gym;

import java.io.*;
import java.util.*;

public class FileUtil {
    private static final String FILE_PATH = "C:\\Users\\Juu\\Other\\Downloads\\GymMemberCRUD\\GymMemberCRUD\\web\\WEB-INF\\members.txt";

    public static List<Member> readMembers() {
        List<Member> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length == 4)
                    list.add(new Member(Integer.parseInt(p[0]), p[1], Integer.parseInt(p[2]), p[3]));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void writeMembers(List<Member> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Member m : list)
                bw.write(m.getId() + "," + m.getName() + "," + m.getAge() + "," + m.getRenewalDate() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
