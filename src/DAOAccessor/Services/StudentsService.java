package DAOAccessor.Services;

import Entity.Student;

import java.util.List;

public class StudentsService extends BaseDbService<Student> {
    public static final StudentsService Instance = new StudentsService();

    private StudentsService() {
    }

    @Override
    public List<Student> getAll() {
        List<Student> allStudents = super.getAll();
        allStudents.forEach(s -> setDependedObjects(s));
        return allStudents;
    }

    @Override
    public Student getById(int id) {
        Student student = super.getById(id);
        setDependedObjects(student);
        return student;
    }

    @Override
    public void setDependedObjects(Student object) {
        object.setGroup(GroupService.Instance.getById(object.getGroupId()));
    }
}
