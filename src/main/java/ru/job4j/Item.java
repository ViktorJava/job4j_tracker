package ru.job4j;

/**
 * Класс модель Item. Item описывает бизнес модель заявки.
 * Заявка имеет 2 поля: имя и уникальный идентификатор.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 1.1
 * @since 27.10.2019
 */
public class Item {
    private int id;
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
