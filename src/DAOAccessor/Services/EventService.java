package DAOAccessor.Services;

import Entity.Event;

/**
 * Created by Igor Sychev on 11.11.14.
 */
public class EventService extends BaseDbService<Event> {
    public static final EventService Instance = new EventService();

    private EventService() {
    }

    @Override
    public void setDependedObjects(Event object) {
        object.setClassRoom(ClassRoomService.Instance.getById(object.getClassRoomId()));
        object.setTeacher(TeacherService.Instance.getById(object.getTeacherId()));
        object.setGroup(GroupService.Instance.getById(object.getGroupId()));
        object.setStudySubject(StudySubjectService.Instance.getById(object.getStudySubjectId()));
    }
}
