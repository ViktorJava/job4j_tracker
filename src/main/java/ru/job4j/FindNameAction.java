package ru.job4j;

/**
 * Класс реализации поиска записи по имени.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 1.1
 * @since 12.12.2019
 */
public class FindNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    /**
     * Поиск записи по имени.
     *
     * @param input      объект пользовательского ввода
     * @param sqlTracker объект доступа к классу Tracker
     * @return флаг выхода.
     */
    @Override
    public boolean execute(Input input, Store sqlTracker) {
        System.out.println();
        System.out.println("--- Find items by name ---");
        String name = input.askStr("Enter item name: ");
        System.out.println("please wait...");
        for (Item item: sqlTracker.findByName(name)) {
            System.out.println(String.format("[name]: %s [id]: %s",
                    item.getName(), item.getId()));
        }
        System.out.println("(Info) search over");
        System.out.println();
        return true;
    }
}
