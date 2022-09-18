package commands.local;

import commands.abstractions.Command;


public class Exit extends Command{
    public Exit() {
        this.name = "exit";
        this.description = "завершить программу (без сохранения в файл)";
    }

    @Override
    public void execute() {
        System.exit(0);
    }
}
