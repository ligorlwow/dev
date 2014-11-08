package Framework.Anotations;

/**
 * Анотацией помечаются простые типы.
 * Для того, чтобы сохранять из в БД без кавычек.
 */
@java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface IsSimpleType {
}
