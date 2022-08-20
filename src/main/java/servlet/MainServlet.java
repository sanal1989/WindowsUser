package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userFind = new String("");
        req.setAttribute("userFind",userFind);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String user = req.getParameter("name");
        String userFind = new String("Пользователь "+user+" нет");
        String[] command = { "cmd", "/c","chcp 65001 & net user"};

        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream(),"cp866"));
        String s;
        while ((s = reader.readLine()) != null) {
            String[] ar = s.split(" ");
            if(user.equals(ar[0])) userFind = "Пользователь "+user+" есть";
        }
        req.setAttribute("userFind",userFind);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
