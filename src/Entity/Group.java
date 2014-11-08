package Entity;

import DAOAccessor.DBConstants;
import Framework.Anotations.IsAutoIncrement;
import Framework.Anotations.IsSimpleType;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Группа.
 */
@Entity
public class Group extends BaseEntity {

    @Column(name = "id")
    @IsSimpleType
    @IsAutoIncrement
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "isDeleted")
    @IsSimpleType
    private boolean isDeleted;

    public Group() {
    }

    public Group(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsDeleted() {
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
