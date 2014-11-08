package DAOAccessor.Services;

import DAOAccessor.DBConstants;
import DAOAccessor.DBFactory;
import DAOAccessor.ResultSetMapper;
import Entity.BaseEntity;
import Framework.GenericExtensions;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDbService<T extends BaseEntity> {
    private static final String GET_ALL = "SELECT * FROM %s.%s";
    private static final String ADD_NEW_ROW = "INSERT INTO `%s`.`%s` (%s) VALUES (%s)";

    protected final ResultSetMapper<T> mapper = new ResultSetMapper<>();
    private final Class<?> CurrentSubclass;
    private final String TableName;

    public BaseDbService() {

        try {
            Type subclassType = GenericExtensions.getGenericClass(getClass());
            T entity = (T) GenericExtensions.getInstance(subclassType);
            CurrentSubclass = entity.getClass();
            TableName = entity.getTableName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> getAll() {
        ResultSet set = DBFactory.executeQuery(String.format(GET_ALL, DBConstants.DB_NAME, TableName));
        return mapper.mapRersultSetToObject(set, CurrentSubclass);
    }

    public void add(T object) {
        HashMap<String, String> columnsWithValues = mapper.getRowMapByObject(object, CurrentSubclass);

        String columns = "";
        String values = "";
        int iterator = 0;
        for (Map.Entry<String, String> map : columnsWithValues.entrySet()) {
            // Предпологаем, что для всех таблиц стоит автогенирация id.
            if (map.getKey() == "id")
                continue;

            columns += "" + map.getKey() + "";
            values += "" + map.getValue() + "";

            if (columnsWithValues.size() - 1 != iterator) {
                columns += ", ";
                values += ", ";
            }

        }
        String addQuery = String.format(ADD_NEW_ROW, DBConstants.DB_NAME, TableName, columns, values);
        DBFactory.executeUpdate(addQuery);
    }
}
