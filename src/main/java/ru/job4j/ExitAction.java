package ru.job4j;

/**
 * Класс реализации выхода из программы.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 1.1
 * @since 13.12.2019
 */
public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "Exit";
    }

    /**
     * Выход из программы
     *
     * @param input      объект пользовательского ввода
     * @param sqlTracker объект доступа к классу Tracker
     * @return флаг выхода.
     */
    @Override
    public boolean execute(Input input, Store sqlTracker) {
        System.out.println("Exit the Program");
        return false;
    }
}
