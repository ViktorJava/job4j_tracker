package ru.job4j;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Connection которое откатывает все commits.
 * It's used for integration tests.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 18.05.2021
 */
public class ConnectionRollback {
    /**
     * Фабричный метод, который создает Connection с autocommit=false режимом,
     * в котором метод close работает с вызовом rollback при закрытии соединения.
     *
     * @param connection Connection.
     * @return Объект Connection.
     * @throws SQLException Возможное исключение.
     */
    public static Connection create(Connection connection) throws SQLException {
        connection.setAutoCommit(false);
        return (Connection) Proxy.newProxyInstance(
                ConnectionRollback.class.getClassLoader(),
                new Class[]{Connection.class},
                (proxy, method, args) -> {
                    Object rsl = null;
                    if ("close".equals(method.getName())) {
                        connection.rollback();
                        connection.close();
                    } else {
                        rsl = method.invoke(connection, args);
                    }
                    return rsl;
                }
        );
    }
}
