import management.ExecutionManager;

/**
 * Main class - program entry point.
 * Prints README if main method receives args.
 * Turns on the Execution Manager class.
 */

public class Main {
    public static void main(String[] args) {
        String invitationMessage = "\033[3;90m" +
                "Программа осуществляет управление коллекцией объектов класса Organization" + "\n" +
                "Коллекция автоматически заполняется при запуске значениями из файла" + "\n" +
                "Имя файла программа берет из переменной окружения LAB5_DATA_FILE (команды для создания переменной окружения ниже)" + "\n" +
                "export LAB5_DATA_FILE=it/is/file/path" + "\n" +
                "Если файл не найден, необходимо указать другой (уже в программе, а не в переменной окружения)" + "\n" +
                "Если данные в фалйе некорректны, можно создать новую коллекцию в этом файле, или указать другой" + "\n" +
                "Аргументы команд, указанные в справке в {фигурных скобках}, вводятся по одному, каждый с новой строки" + "\n" +
                "Остановить ввод составных объектов (в фигурных скобках) НЕВОЗМОЖНО: можно или доввести, или выйти из программы" + "\n" +
                "Все остальные аргументы команд вводятся в той же строке, что и имя команды" + "\033[0m";

        if (args.length > 0)
            System.out.println(invitationMessage);

        ExecutionManager executionManager = new ExecutionManager();
        while (true) {
            executionManager.executeNextCommand();
        }
    }
}
