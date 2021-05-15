package ru.job4j;

/**
 * Класс реализации редактирования записи.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 1.1
 * @since 12.12.2019
 */
public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    /**
     * Редактирование записи.
     *
     * @param input      объект пользовательского ввода
     * @param sqlTracker объект доступа к классу Tracker
     * @return флаг выхода.
     */
    @Override
    public boolean execute(Input input, Store sqlTracker) {
        System.out.println("\n--- Edit item ---");
        int id = input.askInt("Enter old id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (sqlTracker.replace(id, item)) {
            System.out.println("(OK) Item changed");
            System.out.println("[name]: " + item.getName()
                    + " [id]: " + item.getId());
        } else {
            System.out.println("(Error) Item not found");
        }
        System.out.println();
        return true;
    }
}
