package DAOAccessor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import Framework.Anotations.IsAutoIncrement;
import Framework.Anotations.IsSimpleType;
import Framework.RowMapByObject;
import org.apache.commons.beanutils.BeanUtils;

//TODO: Переписать под JPA + Hibernate
//TODO: На даноом этапе жизни проекта, пока можно существовать так.
public class ResultSetMapper<T> {
    @SuppressWarnings("unchecked")
    public List<T> mapRersultSetToObject(ResultSet rs, Class outputClass) {
        List<T> outputList = new ArrayList<>();
        try {
            // make sure resultset is not null
            if (rs != null) {
                // check if outputClass has 'Entity' annotation
                if (outputClass.isAnnotationPresent(Entity.class)) {
                    // get the resultset metadata
                    ResultSetMetaData rsmd = rs.getMetaData();
                    // get all the attributes of outputClass
                    Field[] fields = outputClass.getDeclaredFields();
                    while (rs.next()) {
                        T bean = (T) outputClass.newInstance();
                        for (int _iterator = 0; _iterator < rsmd
                                .getColumnCount(); _iterator++) {
                            // getting the SQL column name
                            String columnName = rsmd
                                    .getColumnName(_iterator + 1);
                            // reading the value of the SQL column
                            Object columnValue = rs.getObject(_iterator + 1);
                            // iterating over outputClass attributes to check if any attribute has 'Column' annotation with matching 'name' value
                            for (Field field : fields) {
                                if (field.isAnnotationPresent(Column.class)) {
                                    Column column = field
                                            .getAnnotation(Column.class);
                                    if (column.name().equalsIgnoreCase(
                                            columnName)
                                            && columnValue != null) {
                                        BeanUtils.setProperty(bean, field
                                                .getName(), columnValue);
                                        break;
                                    }
                                }
                            }
                        }
                        outputList.add(bean);
                    }

                } else {
                    // throw some error
                }
            } else {
                return outputList;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return outputList;
    }

    @SuppressWarnings("unchecked")
    public List<RowMapByObject> getRowMapByObject(T object, Class inputClass) {
        List<RowMapByObject> outputMap = new ArrayList<>();
        try {
            if (inputClass.isAnnotationPresent(Entity.class)) {
                Field[] fields = inputClass.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Column.class) && !field.isAnnotationPresent(IsAutoIncrement.class)) {
                        boolean isSimpleType = false;
                        if (field.isAnnotationPresent(IsSimpleType.class)) {
                            isSimpleType = true;
                        }
                        String columnName = field
                                .getAnnotation(Column.class).name();
                        outputMap.add(new RowMapByObject(columnName, BeanUtils.getProperty(object, columnName), isSimpleType));
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Cannot serialize object.");
        }
        return outputMap;
    }
}
