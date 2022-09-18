package management;

import commands.exceptions.CommandNotFoundException;
import commands.abstractions.Command;
import commands.exceptions.CommandArgumentException;
import commands.abstractions.ServerCommand;
import data.NUZHNO_PRIDUMAT_IMYA.DataManager;
import io.Terminal;

import java.util.Arrays;


/**
 * This class manages full command execution process
 *
 * reads command from Terminal,
 * gets Command instance from CommandManager,
 * sets DataManager to the Command instance (if it's necessary)
 * runs the Command execution method
 * prints result in Terminal
 */


public class ExecutionManager {
    private final Terminal terminal;
    private final CommandManager commandManager;
    private final DataManager dataManager;


    public ExecutionManager() {
        this.terminal = new Terminal();
        this.dataManager = new DataManager(terminal);
        this.commandManager = new CommandManager(terminal);
        terminal.print("Программа запущена \nДля вывода справки по доступным командам введите \"help\"");
    }


    /**
     * Read and executes next command (including exception handling)
     */
    public void executeNextCommand() {
        try {
            Command command = readCommand();
            executeCommand(command);
        } catch (CommandNotFoundException e) {
            terminal.print(e.getMessage());
        } catch (CommandArgumentException e) {
            terminal.print(e.getMessage());
        }
    }

    private Command readCommand() throws CommandNotFoundException {
        String[] inputLine = terminal.readLineSplit();
        if (inputLine[0].equals(""))
            return readCommand();   // empty input -> read command again
        String name = inputLine[0];
        String[] args = Arrays.copyOfRange(inputLine, 1, inputLine.length);
        return commandManager.getCommand(name, args);
    }

    private void executeCommand(Command command) {
        if (command instanceof ServerCommand)
            ((ServerCommand) command).setDataManager(dataManager);
        command.execute();
        terminal.print(command.getResult());
    }
}
