package ru.job4j;

/**
 * Класс описывает общее поведение системы Tracker.
 * В шаблоне проектирования стратегия-это Context.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 1.1
 * @since 28.11.2019
 */
public class StartUI {
    /**
     * Главный цикл программы.
     *
     * @param input      класс определяющий ввод данных.
     * @param sqlTracker класс для работы c заявками в базе данных.
     * @param actions    массив действий.
     */
    public void init(Input input, Store sqlTracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.length);
            UserAction action = actions[select];
            run = action.execute(input, sqlTracker);
        }
    }

    /**
     * Метод формирования главного меню.
     *
     * @param actions массив действий.
     */
    private void showMenu(UserAction[] actions) {
        System.out.println("=== Menu ===");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    /**
     * Точка входа в программу.
     *
     * @param args аргументы запуска программы.
     */
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        Store sqlTracker = new SqlTracker();
        sqlTracker.init();
        UserAction[] actions = {
                new CreateAction(),
                new ShowAllAction(),
                new EditAction(),
                new DeleteAction(),
                new FindIdAction(),
                new FindNameAction(),
                new ExitAction()
        };
        new StartUI().init(validate, sqlTracker, actions);
    }
}