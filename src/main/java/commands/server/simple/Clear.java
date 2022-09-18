package commands.server.simple;

import commands.abstractions.ServerCommand;
import io.TextFormatter;
import data.model.Organization;


public class Clear extends ServerCommand {
    public Clear() {
        this.name = "clear";
        this.description = "очистить коллекцию";
    }

    @Override
    public void execute() {
        for (Organization organization : dataManager.getCollection())
            dataManager.getIdGenerator().setToRemoved(organization.getId());
        dataManager.getCollection().clear();
        dataManager.getCollectionInfo().setElementsAmount(0);
        result = TextFormatter.format("Коллекция очищена", TextFormatter.Format.GREEN);
    }
}
