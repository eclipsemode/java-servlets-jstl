package ru.daniel.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bye")
public class ByeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("++INIT++");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("++SERVICE BEFORE++");
        super.service(req, resp);
        System.out.println("++SERVICE AFTER++");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("++DO GET++");
        PrintWriter out = resp.getWriter();

        out.print(
                """
                        <!DOCTYPE html>
                        <html lang="en">
                        <head>
                            <meta charset="UTF-8">
                            <meta name="viewport" content="width=device-width, initial-scale=1">
                            <title>Sign in</title>
                        </head>
                        <body>
                           <p>Bye servlet</p>
                        </body>
                        </html>
                        """
                        );
    }

    @Override
    public void destroy() {
        System.out.println("++DESTROY++");
    }
}
