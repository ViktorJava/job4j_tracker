package ru.job4j;

/**
 * Класс реализации поиска записи
 * по индивидуальному идентификатору.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 1.1
 * @since 12.12.2019
 */
public class FindIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    /**
     * Поиск записи по ID.
     *
     * @param input      объект пользовательского ввода
     * @param sqlTracker объект доступа к классу Tracker
     * @return флаг выхода.
     */
    @Override
    public boolean execute(Input input, Store sqlTracker) {
        System.out.println("\n--- Find item by Id ---");
        int id = input.askInt("Enter item id: ");
        System.out.println("please wait...");
        Item item = sqlTracker.findById(id);
        if (item != null) {
            System.out.println("(OK) Item found");
            System.out.println("[name]: " + item.getName()
                    + " [id]: " + item.getId());
        } else {
            System.out.println("(Info) Item not found");
        }
        System.out.println();
        return true;
    }
}
