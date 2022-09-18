package management;

import commands.exceptions.CommandNotFoundException;
import commands.abstractions.*;
import commands.local.*;
import commands.server.simple.*;
import commands.server.creation.*;
import io.Terminal;

import java.util.HashMap;


public class CommandManager {
    private final HashMap<String, Command> commands;
    private final CommandHistory history;


    public CommandManager(Terminal terminal) {
        this.commands = new HashMap<>();
        this.history = new CommandHistory();

        // local commands
        commands.put("history", new History(history));
        commands.put("execute_script", new ExecuteScript(terminal));
        commands.put("help", new Help(commands));
        commands.put("exit", new Exit());

        // server creation commands
        commands.put("add", new Add(terminal));
        commands.put("add_if_max", new AddIfMax(terminal));
        commands.put("update", new Update(terminal));
        commands.put("remove_any_by_official_address", new RemoveByAddress(terminal));

        // server simple commands
        commands.put("remove_by_id", new RemoveByID());
        commands.put("clear", new Clear());
        commands.put("show", new Show());
        commands.put("head", new Head());
        commands.put("print_ascending", new PrintAscending());
        commands.put("filter_starts_with_name", new FilterStartsWithName());
        commands.put("info", new Info());
        commands.put("save", new Save());
    }


    public Command getCommand(String name, String[] args) throws CommandNotFoundException {
        if (!commands.containsKey(name))
            throw new CommandNotFoundException(name);
        Command command = commands.get(name).clone();
        command.setArgs(args);
        history.addCommand(command);
        return command;
    }
}
