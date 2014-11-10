package DAOAccessor.Services;

import Entity.AuthorizationEvent;

public class AuthorizationEventService extends BaseDbService<AuthorizationEvent> {
    public static final AuthorizationEventService Instance = new AuthorizationEventService();

    @Override
    public void setDependedObjects(AuthorizationEvent object) {
        object.setStudent(StudentsService.Instance.getById(object.getStudentId()));
    }
}
