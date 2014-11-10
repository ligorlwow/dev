package DAOAccessor.Migrators;

import DAOAccessor.DBConstants;
import DAOAccessor.DBFactory;
import DAOAccessor.DBUtils;

/**
 * Created by Igor Sychev on 10.11.14.
 */
public class U04AddStudySubjectTable implements IRunMigrator {

    private static final String CREATE_SUBJECT_TABLE =
            "CREATE  TABLE IF NOT EXISTS `%s`.`%s` (" +
                    "`id` INT(5) NOT NULL AUTO_INCREMENT," +
                    "`name` VARCHAR(45) NOT NULL," +
                    "`isDeleted` BOOLEAN NOT NULL DEFAULT 0," +
                    " PRIMARY KEY (`id`) )";
    ;

    @Override
    public int getNumber() {
        return 4;
    }

    @Override
    public void migrate() {
        if (!DBUtils.tableExists(DBConstants.DB_NAME, DBConstants.TABLE_STUDY_SUBJECT)) {
            DBFactory.executeUpdate(String.format(CREATE_SUBJECT_TABLE, DBConstants.DB_NAME, DBConstants.TABLE_STUDY_SUBJECT));
        }
    }
}
