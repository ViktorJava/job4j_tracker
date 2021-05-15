package ru.job4j;

/**
 * Класс реализации удаления записи.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 1.1
 * @since 12.12.2019
 */
public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    /**
     * Удаление записи.
     *
     * @param input      объект пользовательского ввода
     * @param sqlTracker объект доступа к классу Tracker
     * @return флаг выхода.
     */
    @Override
    public boolean execute(Input input, Store sqlTracker) {
        System.out.println("\n--- Delete item ---");
        int id = input.askInt("Enter item id: ");
        if (sqlTracker.delete(id)) {
            System.out.println("(OK) Item deleted");
        } else {
            System.out.println("(Error) Item not found");
        }
        System.out.println();
        return true;
    }
}
