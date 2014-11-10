package DAOAccessor.Migrators;

import DAOAccessor.DBConstants;
import DAOAccessor.DBFactory;
import DAOAccessor.DBUtils;

public class U03AddStudentTable implements IRunMigrator {

    private static final String CREATE_STUDENT_TABLE =
            "CREATE  TABLE IF NOT EXISTS `%s`.`%s` (\n" +
                    "`id` INT(5) NOT NULL AUTO_INCREMENT,\n" +
                    "`name` VARCHAR(45) NOT NULL,\n" +
                    "`surname` VARCHAR(45) NOT NULL,\n" +
                    "`groupId` INT(5) NOT NULL,\n" +
                    "`isDeleted` BOOLEAN NOT NULL DEFAULT 0,\n" +
                    "PRIMARY KEY (`id`),\n" +
                    "FOREIGN KEY (`groupId`)\n" +
                    "REFERENCES `%s`.`%s` (`id` )\n" +
                    "ON DELETE NO ACTION\n" +
                    "ON UPDATE NO ACTION)\n";

    @Override
    public int getNumber() {
        return 3;
    }

    @Override
    public void migrate() {
        if (!DBUtils.tableExists(DBConstants.DB_NAME, DBConstants.TABLE_STUDENT)) {
            DBFactory.executeUpdate(String.format(CREATE_STUDENT_TABLE,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_STUDENT,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_GROUP));
        }
    }
}
