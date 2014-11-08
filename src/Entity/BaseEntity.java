package Entity;

public class BaseEntity extends BaseTable {

    @Override
    public String getTableName() {
        throw new RuntimeException("BaseEntity is not entity :)");
    }
}
