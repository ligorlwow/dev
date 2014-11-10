package DAOAccessor.Services;

import Entity.ClassRoom;

/**
 * Created by Igor Sychev on 11.11.14.
 */
public class ClassRoomService extends BaseDbService<ClassRoom> {
    public static final ClassRoomService Instance = new ClassRoomService();

    private ClassRoomService() {
    }

    @Override
    public void setDependedObjects(ClassRoom object) {

    }
}
