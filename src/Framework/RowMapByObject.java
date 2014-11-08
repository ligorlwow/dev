package Framework;

public class RowMapByObject {

    private String columnName;
    private String value;
    private boolean isSimple;

    public RowMapByObject(String columnName, String value, boolean isSimple) {
        this.columnName = columnName;
        this.value = value;
        this.isSimple = isSimple;
    }

    public String getColumnName() {
        return columnName;
    }

    public String getValue() {
        return value;
    }

    public boolean isSimple() {
        return isSimple;
    }
}
