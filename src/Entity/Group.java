package Entity;

import DAOAccessor.DBConstants;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Группа.
 */
@Entity
public class Group extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    public Group() {
    }

    public Group(String name, boolean isDeleted) {
        this.name = name;
        this.isDeleted = isDeleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    @Override
    public String getTableName() {
        return DBConstants.TABLE_GROUP;
    }
}
