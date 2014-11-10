package Entity;

import Framework.Anotations.IsAutoIncrement;
import Framework.Anotations.IsSimpleType;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Teacher extends BaseEntity {

    @Column(name = "id")
    @IsSimpleType
    @IsAutoIncrement
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "isDeleted")
    @IsSimpleType
    private boolean isDeleted;

    public Teacher() {
    }

    public Teacher(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
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
        return "Teacher";
    }
}
