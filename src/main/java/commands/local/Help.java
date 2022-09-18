package commands.local;

import commands.abstractions.Command;
import io.TextFormatter;

import java.util.HashMap;


public class Help extends Command {
    private final HashMap<String, Command> commands;


    public Help(HashMap<String, Command> commands) {
        this.name = "help";
        this.description = "вывести справку по доступным командам";
        this.commands = commands;
    }


    @Override
    public void execute() {
        for (Command command : commands.values()) {
            String help = command.getHelp();
            String coloredHelp = highlightCommandName(help);
            if (result != "")
                result += "\n";
            result += (coloredHelp);
        }
    }


    private String highlightCommandName(String help) {
        String divider = ": ";
        String name = help.split(divider)[0];
        String description = help.split(divider)[1];

        name = TextFormatter.format(name, TextFormatter.Format.YELLOW);     // highlight

        return name + divider + description;
    }
}
