package Controllers;


import DAOAccessor.Services.GroupService;
import DAOAccessor.Services.StudentsService;
import Entity.Group;
import Entity.Student;
import Framework.ResultSetExtensions;
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
        Group group = new Group("91-112", 1);
        GroupService.Instance.add(group);
        Group newGroup = GroupService.Instance.getAll().get(0);
        Student student1 = new Student("Булат", "Насрулин", newGroup, false);
        Student student2 = new Student("Игорь", "Карпов", newGroup, false);
        Student student3 = new Student("Ильмира", "Халилова", newGroup, false);
        Student student4 = new Student("Игорь", "Сычев", newGroup, false);
        StudentsService.Instance.add(student1);
        StudentsService.Instance.add(student2);
        StudentsService.Instance.add(student3);
        StudentsService.Instance.add(student4);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RunMigrators.tryMigrateIfNeeded();
        super.doGet(req, resp);
    }
}
