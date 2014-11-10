package DAOAccessor.Migrators;

import DAOAccessor.DBConstants;
import DAOAccessor.DBFactory;
import DAOAccessor.DBUtils;

/**
 * Created by Igor Sychev on 11.11.14.
 */
public class U09AddEventTable implements IRunMigrator {

    private static final String CREATE__EVENT_TABLE =
            "CREATE  TABLE IF NOT EXISTS `%s`.`%s` (" +
                    "`id` INT(5) NOT NULL AUTO_INCREMENT," +
                    "`teacherId` INT NOT NULL," +
                    "`groupId` INT NOT NULL," +
                    "`classRoomId` INT NOT NULL," +
                    "`studySubjectId` INT NOT NULL," +
                    "`startDate` TIMESTAMP NOT NULL," +
                    "`endDate` TIMESTAMP NOT NULL," +
                    "`isDeleted` BOOLEAN NOT NULL DEFAULT 0," +
                    " PRIMARY KEY (`id`)," +
                    " FOREIGN KEY (`teacherId`) " + "REFERENCES `%s`.`%s` (`id` ) " + "ON DELETE NO ACTION " + "ON UPDATE NO ACTION," +
                    " FOREIGN KEY (`groupId`) " + "REFERENCES `%s`.`%s` (`id` ) " + "ON DELETE NO ACTION " + "ON UPDATE NO ACTION," +
                    " FOREIGN KEY (`classRoomId`) " + "REFERENCES `%s`.`%s` (`id` ) " + "ON DELETE NO ACTION " + "ON UPDATE NO ACTION," +
                    " FOREIGN KEY (`studySubjectId`) " + "REFERENCES `%s`.`%s` (`id` ) " + "ON DELETE NO ACTION " + "ON UPDATE NO ACTION)";
    ;

    @Override
    public int getNumber() {
        return 9;
    }

    @Override
    public void migrate() {
        if (!DBUtils.tableExists(DBConstants.DB_NAME, DBConstants.TABLE__EVENT)) {
            DBFactory.executeUpdate(String.format(CREATE__EVENT_TABLE,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE__EVENT,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_TEACHER,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_GROUP,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_CLASS_ROOM,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_STUDY_SUBJECT));
        }
    }
}
