package ru.job4j;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тесты класса Tracker
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 1.2
 * @since 14.11.2019
 */
public class MemTrackerTest {

    /**
     * Тест метода add.
     * Формируем заявку в трекере.
     * Ищем заявку по id, запрашиваем её имя.
     * Сверяем имена созданной заявки и найденной заявки в трекере.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("Item1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Тест замены заявки.
     * Создаём новые заявки (item1,item2).
     * Добавляем заявки в трекер, присваивается id.
     * Создаем новую заявку (newItem) без id.
     * Проставляем старый id, заявки item2, в новую заявку newItem.
     * Обновляем заявку в трекере.
     * Проверяем, что имя заявки изменилось с item2 на newItem.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        MemTracker memTracker = new MemTracker();
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        memTracker.add(item1);
        memTracker.add(item2);
        Item newItem = new Item("newItem");
        memTracker.replace(item2.getId(), newItem);
        assertThat(memTracker.findById(item2.getId()).getName(), is("newItem"));
    }

    /**
     * Тест удаления заявки.
     * Создаём две заявки и отправляем в трекер, присваивая
     * заявкам id. Удаляем первую заявку (по id).
     * Ищем все оставшиеся заявки в трекере.
     */
    @Test
    public void deleteItem() {
        MemTracker memTracker = new MemTracker();
        Item test1 = new Item("test1");
        Item test2 = new Item("test2");
        memTracker.add(test1);
        memTracker.add(test2);
        assertThat(memTracker.delete(test1.getId()), is(true));
        Item[] expected = {test2};
        assertThat(memTracker.findAll(), is(Arrays.asList(expected)));
    }

    /**
     * Тест поиска заявки по имени.
     * Формируем три заявки (test1,test2,test3).
     * Добавляем четыре заявки в трекер, две заявки с одинаковым именем.
     * Ищем заявку по имени. Проверяем поиск двух заявок с одинаковым именем.
     */
    @Test
    public void findItemByName() {
        MemTracker memTracker = new MemTracker();
        Item test1 = new Item("test1");
        Item test2 = new Item("test2");
        Item test3 = new Item("test3");
        memTracker.add(test1);
        memTracker.add(test2);
        memTracker.add(test3);
        memTracker.add(test1);
        Item[] expected = {test1, test1};
        assertThat(memTracker.findByName(test1.getName()), is(Arrays.asList(expected)));
    }

    /**
     * Тест поиска заявки по id.
     * Формируем три заявки. Добавляем в трекер.
     * Ищем вторую заявку по id
     */
    @Test
    public void findItemById() {
        MemTracker memTracker = new MemTracker();
        Item test1 = new Item("test1");
        Item test2 = new Item("test2");
        Item test3 = new Item("test3");
        memTracker.add(test1);
        memTracker.add(test2);
        memTracker.add(test3);
        assertThat(memTracker.findById(test2.getId()), is(test2));
    }

    /**
     * Тест поиска всех заявок в трекере.
     * Создаём три заявки, добавляем в трекер четыре заявки,
     * из них две копии (test2).
     * Находим в трекере четыре заявки.
     */
    @Test
    public void whenFindAllThenFindAll() {
        MemTracker memTracker = new MemTracker();
        Item test1 = new Item("test1");
        Item test2 = new Item("test2");
        Item test3 = new Item("test3");
        memTracker.add(test1);
        memTracker.add(test2);
        memTracker.add(test3);
        memTracker.add(test2);
        Item[] expected = {test1, test2, test3, test2};
        assertThat(memTracker.findAll(), is(Arrays.asList(expected)));
    }
}
