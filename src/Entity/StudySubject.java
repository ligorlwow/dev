package Entity;


import Framework.Anotations.IsAutoIncrement;
import Framework.Anotations.IsSimpleType;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Предмет.
 */
@Entity
public class StudySubject extends BaseEntity {

    @Column(name = "id")
    @IsSimpleType
    @IsAutoIncrement
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "isDeleted")
    @IsSimpleType
    private boolean isDeleted;

    public StudySubject() {
    }

    public StudySubject(String name) {
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
        return "StudySubject";
    }
}
