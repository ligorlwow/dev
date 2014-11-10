package DAOAccessor.Services;

import Entity.Migrator;

public class MigratorService extends BaseDbService<Migrator> {

    public static final MigratorService Instance = new MigratorService();

    private MigratorService() {
        super();
    }

    @Override
    public void setDependedObjects(Migrator object) {

    }
}
