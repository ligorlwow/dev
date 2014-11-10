package Entity;

import Framework.Anotations.DependedField;
import Framework.Anotations.IsAutoIncrement;
import Framework.Anotations.IsSimpleType;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * Событие авторизации.
 */
@Entity
public class AuthorizationEvent extends BaseEntity {

    @Column(name = "id")
    @IsSimpleType
    @IsAutoIncrement
    private int id;

    /**
     * Авторизовавшийся клиент.
     */
    @DependedField(idColumn = "studentId")
    private Student student;

    @Column(name = "studentId")
    @IsSimpleType
    private int studentId;

    /**
     * Долгота.
     */
    @Column(name = "longitude")
    @IsSimpleType
    private double longitude;

    /**
     * Время авторизации.
     */
    @Column(name = "authorizationDate")
    private Timestamp authorizationDate;

    /**
     * Широта.
     */
    @Column(name = "latitude")
    @IsSimpleType
    private double latitude;

    @Column(name = "isDeleted")
    @IsSimpleType
    private boolean isDeleted;

    public AuthorizationEvent() {
    }

    public AuthorizationEvent(Student student, double latitude, double longitude, Timestamp authorizationDate) {
        this.longitude = longitude;
        this.authorizationDate = authorizationDate;
        this.latitude = latitude;
        this.student = student;
        this.studentId = student.getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.studentId = student.getId();
        this.student = student;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public Timestamp getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAuthorizationDate(Timestamp authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String getTableName() {
        return "AuthorizationEvent";
    }
}
