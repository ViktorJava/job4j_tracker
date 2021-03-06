package ru.job4j;

/**
 * Интерфейс описывает все действия системы Tracker.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 1.1
 * @since 12.12.2019
 */
public interface UserAction {
    String name();

    boolean execute(Input input, Store sqlTracker);
}
