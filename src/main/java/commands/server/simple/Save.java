package commands.server.simple;

import commands.abstractions.ServerCommand;
import io.TextFormatter;

import java.io.FileNotFoundException;


public class Save extends ServerCommand {
    public Save() {
        this.name = "save";
        this.description = "сохранить коллекцию в файл";
    }

    @Override
    public void execute() {
        try {
            this.dataManager.saveData();
            result = "Коллекция сохранена";
            result = TextFormatter.format(result, TextFormatter.Format.GREEN);
        } catch (FileNotFoundException e) {
            result = "Невозможно сохранить коллекцию в файл: недостаточно прав";
            result = TextFormatter.format(result, TextFormatter.Format.RED);
        }
    }
}
