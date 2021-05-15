package ru.job4j;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты демонстрирующие сортировку данных по возрастанию и по убыванию.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 19.05.2020
 */
public class ItemTest {
    @Test
    public void thenNameSortIncrease() {
        MemTracker memTracker = new MemTracker();
        Item item3 = new Item("Item3");
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        memTracker.findAll().sort(new NameSortInc());
        assertThat(memTracker.findAll(), is(Arrays.asList(item1, item2, item3)));
    }

    @Test
    public void thenNameSortDecrease() {
        MemTracker memTracker = new MemTracker();
        Item item3 = new Item("Item3");
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        memTracker.add(item1);
        memTracker.add(item2);
        memTracker.add(item3);
        memTracker.findAll().sort(new NameSortDec());
        assertThat(memTracker.findAll(), is(Arrays.asList(item3, item2, item1)));
    }
}
