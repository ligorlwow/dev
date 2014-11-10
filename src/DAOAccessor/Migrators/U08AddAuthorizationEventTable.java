package DAOAccessor.Migrators;

import DAOAccessor.DBConstants;
import DAOAccessor.DBFactory;
import DAOAccessor.DBUtils;

/**
 * Created by Igor Sychev on 11.11.14.
 */
public class U08AddAuthorizationEventTable implements IRunMigrator {
    private static final String CREATE_AUTHORIZATION_EVENT_TABLE =
            "CREATE  TABLE IF NOT EXISTS `%s`.`%s` (" +
                    "`id` INT(5) NOT NULL AUTO_INCREMENT," +
                    "`studentId` INT NOT NULL," +
                    "`longitude` DOUBLE NOT NULL," +
                    "`latitude` DOUBLE NOT NULL," +
                    "`authorizationDate` TIMESTAMP NOT NULL," +
                    "`isDeleted` BOOLEAN NOT NULL DEFAULT 0," +
                    " PRIMARY KEY (`id`)," +
                    " FOREIGN KEY (`studentId`) " + "REFERENCES `%s`.`%s` (`id` ) " + "ON DELETE NO ACTION " + "ON UPDATE NO ACTION)";
    ;

    @Override
    public int getNumber() {
        return 8;
    }

    @Override
    public void migrate() {
        if (!DBUtils.tableExists(DBConstants.DB_NAME, DBConstants.TABLE_AUTHORIZATION_EVENT)) {
            DBFactory.executeUpdate(String.format(CREATE_AUTHORIZATION_EVENT_TABLE,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_AUTHORIZATION_EVENT,
                    DBConstants.DB_NAME,
                    DBConstants.TABLE_STUDENT));
        }
    }
}
