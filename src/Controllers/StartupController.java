package Controllers;


import DAOAccessor.Services.*;
import Entity.*;
import Framework.ResultSetExtensions;
import DAOAccessor.RunMigrators;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

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
        Teacher teacher = new Teacher("Столов", "Колян", "Михайлович");
        StudySubject studySubject = new StudySubject("АиГ");
        TeacherService.Instance.add(teacher);
        StudySubjectService.Instance.add(studySubject);
        Teacher newTeacher = TeacherService.Instance.getAll().get(0);
        StudySubject newStudySubject = StudySubjectService.Instance.getAll().get(0);
        StudySubjectMapping sbm = new StudySubjectMapping(newGroup, newTeacher, newStudySubject);
        StudySubjectMappingService.Instance.add(sbm);
        ClassRoom classRoom = new ClassRoom("1013", 100.009453, 50.00956);
        ClassRoomService.Instance.add(classRoom);
        Student firstStudent = StudentsService.Instance.getAll().get(0);
        AuthorizationEvent authorizationEvent = new AuthorizationEvent(firstStudent, 100.60, 9056.00056, new Timestamp(new Date().getTime()));
        AuthorizationEventService.Instance.add(authorizationEvent);
        AuthorizationEvent newAuthEvent = AuthorizationEventService.Instance.getAll().get(0);
        Event event = new Event(newTeacher,
                newGroup,
                newStudySubject,
                ClassRoomService.Instance.getAll().get(0),
                new Timestamp(new Date().getTime()),
                new Timestamp(new Date().getTime()));
        EventService.Instance.add(event);
        Event newEvent = EventService.Instance.getAll().get(0);
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RunMigrators.tryMigrateIfNeeded();
        super.doGet(req, resp);
    }
}
