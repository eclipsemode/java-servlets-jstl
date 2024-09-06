package ru.daniel.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.daniel.servlets.exception.EmptyFieldException;
import ru.daniel.servlets.exception.UserIsAlreadyExistsException;
import ru.daniel.servlets.service.AccountService;
import ru.daniel.servlets.util.ObjectFactory;

import java.io.IOException;

public class HelloServlet extends HttpServlet {
    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        try {
            accountService = ObjectFactory.getInstance().create(AccountService.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("accounts", accountService.allAccounts().values());
        req.getRequestDispatcher("/view/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            accountService.saveAccount(req.getParameter("name"), req.getParameter("password"), Double.parseDouble(req.getParameter("balance")));
        } catch (UserIsAlreadyExistsException e) {
            req.setAttribute("userExistsError", true);
        } catch (EmptyFieldException e) {
            req.setAttribute("emptyField", true);
        } finally {
            doGet(req, resp);
        }
    }

    @Override
    public void destroy() {
        System.out.println("===Destroying Servlet===");
    }
}
