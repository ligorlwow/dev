package DAOAccessor.Services;

import DAOAccessor.DBConstants;
import DAOAccessor.DBFactory;
import DAOAccessor.ResultSetMapper;
import Entity.BaseTable;
import Entity.Group;
import Framework.GenericExtensions;
import Framework.RowMapByObject;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.util.List;

public abstract class BaseDbService<T extends BaseTable> {
    private static final String GET_ALL = "SELECT * FROM %s.%s";
    private static final String GET_BY_ID = "SELECT * FROM %s.%s WHERE id = %s";
    private static final String ADD_NEW_ROW = "INSERT INTO `%s`.`%s` (%s) VALUES (%s)";

    protected final ResultSetMapper<T> mapper = new ResultSetMapper<>();
    private final Class<?> subclass;
    private final String tableName;

    public BaseDbService() {

        try {
            Type subclassType = GenericExtensions.getGenericClass(getClass());
            T entity = (T) GenericExtensions.getInstance(subclassType);
            subclass = entity.getClass();
            tableName = entity.getTableName();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> getAll() {
        ResultSet set = DBFactory.executeQuery(String.format(GET_ALL, DBConstants.DB_NAME, tableName));
        List<T> allEntitiesWithoutDependedObjects = mapper.mapRersultSetToObject(set, subclass);
        allEntitiesWithoutDependedObjects.forEach(e -> setDependedObjects(e));
        return allEntitiesWithoutDependedObjects;
    }

    public T getById(int id) {
        ResultSet set = DBFactory.executeQuery(String.format(GET_BY_ID, DBConstants.DB_NAME, tableName, id));
        T entityWithoutDependedObjects = mapper.mapRersultSetToObject(set, subclass).get(0);
        setDependedObjects(entityWithoutDependedObjects);
        return entityWithoutDependedObjects;
    }

    //TODO Написать логику по получение зависимых сущностей.
    public abstract void setDependedObjects(T object);

    public void add(T object) {
        List<RowMapByObject> rowMap = mapper.getRowMapByObject(object, subclass);

        String columns = "";
        String values = "";
        int iterator = 0;
        for (RowMapByObject map : rowMap) {
            if (!map.isSimple()) {
                values += "\"" + map.getValue() + "\"";
            } else {
                values += map.getValue();
            }
            columns += map.getColumnName();

            if (rowMap.size() - 1 != iterator) {
                columns += ", ";
                values += ", ";
            }
            iterator++;
        }
        String addQuery = String.format(ADD_NEW_ROW, DBConstants.DB_NAME, tableName, columns, values);
        DBFactory.executeUpdate(addQuery);
    }
}