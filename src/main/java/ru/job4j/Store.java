package ru.job4j;

import java.util.List;

/**
 * Интерфейс описывающий хранилище работающее с базой данных.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 15.05.2021
 */
public interface Store extends AutoCloseable {
    /**
     * Метод инициализации базы данных.
     */
    void init();

    /**
     * Метод добавления записи в таблицу базы данных.
     *
     * @param item Запись.
     * @return Запись с присвоенным id.
     */
    Item add(Item item);

    /**
     * Метод замены заявки в базе данных. К существующему идентификатору заявки,
     * присваивается новое имя.
     *
     * @param id   Идентификатор существующей заявки в базе данных.
     * @param item Редактируемая заявка.
     * @return true в случае удачного редактирования заявки, иначе false.
     */
    boolean replace(int id, Item item);

    /**
     * Удаление заявки в базе данных.
     *
     * @param id Идентификатор заявки.
     * @return true в случае удачного удаления, иначе false.
     */
    boolean delete(int id);

    /**
     * Поиск всех заявок в базе данных.
     *
     * @return Возвращается список существующих заявок.
     */
    List<Item> findAll();

    /**
     * Поиск заявки по имени.
     *
     * @param key Имя заявки.
     * @return Список найденных заявок.
     */
    List<Item> findByName(String key);

    /**
     * Поиск заявки по идентификатору.
     *
     * @param id Идентификатор заявки.
     * @return Найденная заявка.
     */
    Item findById(int id);
}
