package Controllers;


import DAOAccessor.RunMigrators;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Представляет собой контроллер старта сервера.
 */
@WebServlet(name = "StartupController", urlPatterns = {"/testDB"})
public class StartupController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        RunMigrators.tryMigrateIfNeeded();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RunMigrators.tryMigrateIfNeeded();
        super.doGet(req, resp);
    }
}
