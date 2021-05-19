package ru.job4j;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Интеграционный тест (использующий внешние ресурсы) удовлетворяющий принципу FIRST.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 18.05.2021
 */
public class TrackerSQLTest {
    public Connection init() {
        try (InputStream in = SqlTracker.class
                .getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void whenCreateItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }

    @Test
    public void whenReplaceItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("Item");
            tracker.add(item);
            int id = item.getId();
            Item newItem = new Item("New Item");
            tracker.replace(id, newItem);
            assertThat(tracker.findById(id).getName(), is("New Item"));
        }
    }

    @Test
    public void whenDeleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("Item_1");
            tracker.add(item);
            int id = item.getId();
            assertThat(tracker.delete(id), is(true));
        }
    }

    @Test
    public void whenFindAllItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Item_1"));
            tracker.add(new Item("Item_2"));
            assertThat(tracker.findAll().size(), is(2));
        }
    }

    @Test
    public void whenFindByNameItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("Item_1"));
            tracker.add(new Item("Item_1"));
            assertThat(tracker.findByName("Item_1").size(), is(2));
        }
    }

    @Test
    public void whenFindByIdItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item = new Item("Item_1");
            tracker.add(item);
            assertThat(tracker.findById(item.getId()).getName(), is("Item_1"));
        }
    }
}
