package DAOAccessor.Migrators;

import DAOAccessor.DBConstants;
import DAOAccessor.DBFactory;
import DAOAccessor.DBUtils;

public class U02AddGroupTable implements IRunMigrator {

    private static final String CREATE_GROUP_TABLE =
            "CREATE  TABLE IF NOT EXISTS `%s`.`%s` (" +
                    "`id` INT(5) NOT NULL AUTO_INCREMENT," +
                    "`name` VARCHAR(45) NOT NULL," +
                    "`course` int(5) NOT NULL DEFAULT 1," +
                    "`isDeleted` BOOLEAN NOT NULL DEFAULT 0," +
                    " PRIMARY KEY (`id`) )";
    ;

    @Override
    public int getNumber() {
        return 2;
    }

    @Override
    public void migrate() {
        if (!DBUtils.tableExists(DBConstants.DB_NAME, DBConstants.TABLE_GROUP)) {
            DBFactory.executeUpdate(String.format(CREATE_GROUP_TABLE, DBConstants.DB_NAME, DBConstants.TABLE_GROUP));
        }
    }
}
