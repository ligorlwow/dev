package DAOAccessor.Services;

import Entity.Group;

/**
 * Created by Igor Sychev on 08.11.14.
 */
public class GroupService extends BaseDbService<Group> {
    public static final GroupService Instance = new GroupService();

    private GroupService() {
    }

    @Override
    public void setDependedObjects(Group object) {

    }
}
