package Entity;

import DAOAccessor.DBConstants;
import Framework.Anotations.DependedField;
import Framework.Anotations.IsAutoIncrement;
import Framework.Anotations.IsSimpleType;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Студент.
 */
@Entity
public class Student extends BaseEntity {

    @Column(name = "id")
    @IsSimpleType
    @IsAutoIncrement
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @DependedField(idColumn = "groupId")
    private Group group;

    @Column(name = "groupId")
    @IsSimpleType
    private int groupId;

    @Column(name = "isDeleted")
    @IsSimpleType
    private boolean isDeleted;

    public Student() {
    }

    public Student(String name, String surname, Group group, boolean isDeleted) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.groupId = group.getId();
        this.isDeleted = isDeleted;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        setGroupId(group.getId());
        this.group = group;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String getTableName() {
        return DBConstants.TABLE_STUDENT;
    }
}
