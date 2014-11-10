package Entity;

import Framework.Anotations.IsAutoIncrement;
import Framework.Anotations.IsSimpleType;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Аудтитория.
 */
@Entity
public class ClassRoom extends BaseEntity {

    @Column(name = "id")
    @IsSimpleType
    @IsAutoIncrement
    private int id;

    @Column(name = "name")
    private String name;

    /**
     * Долгота.
     */
    @Column(name = "longitude")
    @IsSimpleType
    private double longitude;

    /**
     * Широта.
     */
    @Column(name = "latitude")
    @IsSimpleType
    private double latitude;

    @Column(name = "isDeleted")
    @IsSimpleType
    private boolean isDeleted;

    public ClassRoom() {
    }

    public ClassRoom(String name, double longitude, double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
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
        return "ClassRoom";
    }
}
