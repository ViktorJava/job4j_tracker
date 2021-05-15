package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование метода FindNameAction().
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 19.12.2019
 */
public class FindNameActionTest {
    @Test
    public void findByName() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        MemTracker memTracker = new MemTracker();
        Item item = new Item("fix bug");
        memTracker.add(item);
        FindNameAction act = new FindNameAction();
        act.execute(new StubInput(new String[]{"fix bug"}), memTracker);
        String expect = new StringJoiner(System.lineSeparator(), System.lineSeparator(), System.lineSeparator())
                .add("--- Find items by name ---")
                .add("Enter item name: ")
                .add("please wait...")
                .add("[name]: " + item.getName() + " [id]: " + item.getId())
                .add("(Info) search over" + System.lineSeparator())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
