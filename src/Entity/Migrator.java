package Entity;

import DAOAccessor.DBConstants;
import Framework.Anotations.IsSimpleType;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Мигратор базы данных.
 */
@Entity
public class Migrator extends BaseTable {

    @Column(name = "number")
    @IsSimpleType
    private int number;

    public Migrator() {
    }

    public Migrator(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String getTableName() {
        return DBConstants.TABLE_MIGRATOR;
    }
}
