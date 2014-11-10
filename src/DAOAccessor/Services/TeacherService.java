package DAOAccessor.Services;

import Entity.Teacher;

public class TeacherService extends BaseDbService<Teacher> {

    public static final TeacherService Instance = new TeacherService();

    private TeacherService() {
    }

    @Override
    public void setDependedObjects(Teacher object) {

    }
}
