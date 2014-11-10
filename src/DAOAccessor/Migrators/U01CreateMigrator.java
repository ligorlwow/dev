package DAOAccessor.Migrators;

import DAOAccessor.DBConstants;
import DAOAccessor.DBFactory;
import DAOAccessor.DBUtils;
import DAOAccessor.Services.MigratorService;
import Entity.Migrator;

public class U01CreateMigrator implements IRunMigrator {

    private static final String ADD_MIGRATOR_TABLE = "CREATE  TABLE IF NOT EXISTS `%s`.`%s` (`number` INT(5) NOT NULL, PRIMARY KEY (`number`) )";

    @Override
    public int getNumber() {
        return 1;
    }

    @Override
    public void migrate() {
        if (!DBUtils.tableExists(DBConstants.DB_NAME, DBConstants.TABLE_MIGRATOR)) {
            DBFactory.executeUpdate(String.format(ADD_MIGRATOR_TABLE, DBConstants.DB_NAME, DBConstants.TABLE_MIGRATOR));
            MigratorService.Instance.add(new Migrator(this.getNumber()));
        }
    }
}
