package DAOAccessor.Migrators;

import DAOAccessor.DBConstants;
import DAOAccessor.DBFactory;
import DAOAccessor.DBUtils;

public class U07AddClassRoomTable implements IRunMigrator {
    private static final String CREATE_CLASS_ROOM_TABLE =
            "CREATE  TABLE IF NOT EXISTS `%s`.`%s` (" +
                    "`id` INT(5) NOT NULL AUTO_INCREMENT," +
                    "`name` VARCHAR(45) NOT NULL," +
                    "`longitude` DOUBLE NOT NULL," +
                    "`latitude` DOUBLE NOT NULL," +
                    "`isDeleted` BOOLEAN NOT NULL DEFAULT 0," +
                    " PRIMARY KEY (`id`) )";
    ;

    @Override
    public int getNumber() {
        return 7;
    }

    @Override
    public void migrate() {
        if (!DBUtils.tableExists(DBConstants.DB_NAME, DBConstants.TABLE_CLASS_ROOM)) {
            DBFactory.executeUpdate(String.format(CREATE_CLASS_ROOM_TABLE, DBConstants.DB_NAME, DBConstants.TABLE_CLASS_ROOM));
        }
    }
}
