package DAOAccessor.Services;

import Entity.Student;

import java.util.List;

public class StudentsService extends BaseDbService<Student> {
    public static final StudentsService Instance = new StudentsService();

    private StudentsService() {
    }

    @Override
    public void setDependedObjects(Student object) {
        object.setGroup(GroupService.Instance.getById(object.getGroupId()));
    }
}
