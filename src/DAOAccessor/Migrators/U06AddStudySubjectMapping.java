package DAOAccessor.Migrators;

import DAOAccessor.DBConstants;
import DAOAccessor.DBFactory;
import DAOAccessor.DBUtils;

/**
 * Created by Igor Sychev on 10.11.14.
 */
public class U06AddStudySubjectMapping implements IRunMigrator {
    private static final String CREATE_STUDY_SUBJECT_MAPPING_TABLE =
            "CREATE  TABLE IF NOT EXISTS `%s`.`%s` (" +
                    "`id` INT(5) NOT NULL AUTO_INCREMENT," +
                    "`groupId` INT(5) NOT NULL," +
                    "`studySubjectId` INT(5) NOT NULL," +
                    "`teacherId` INT(5) NOT NULL," +
                    "`isDeleted` BOOLEAN NOT NULL DEFAULT 0," +
                    "PRIMARY KEY (`id`)," +
                    "FOREIGN KEY (`groupId`) " + "REFERENCES `%s`.`%s` (`id` ) " + "ON DELETE NO ACTION " + "ON UPDATE NO ACTION, " +
                    "FOREIGN KEY (`studySubjectId`) " + "REFERENCES `%s`.`%s` (`id` ) " + "ON DELETE NO ACTION  " + "ON UPDATE NO ACTION,  " +
                    "FOREIGN KEY (`teacherId`) " + "REFERENCES `%s`.`%s` (`id` ) " + "ON DELETE NO ACTION " + "ON UPDATE NO ACTION)";
    ;

    @Override
    public int getNumber() {
        return 6;
    }

    @Override
    public void migrate() {
        if (!DBUtils.tableExists(DBConstants.DB_NAME, DBConstants.TABLE_STUDY_SUBJECT_MAPPING_TABLE)) {
            DBFactory.executeUpdate(String.format(CREATE_STUDY_SUBJECT_MAPPING_TABLE,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_STUDENT,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_GROUP,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_STUDY_SUBJECT,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_TEACHER));
        }
    }
}
