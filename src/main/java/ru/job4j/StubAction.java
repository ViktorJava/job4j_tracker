package ru.job4j;

/**
 * Класс- заглушка реализующий интерфейс UserAction.
 * Используем для загрузки действия и проверки,
 * что мы выполнили этот тест.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 1.1
 * @since 13.12.2019
 */
public class StubAction implements UserAction {
    private boolean call = false;

    @Override
    public String name() {
        return "Stub Action";
    }

    @Override
    public boolean execute(Input input, Store sqlTracker) {
        call = true;
        return false;
    }

    public boolean isCall() {
        return call;
    }
}
