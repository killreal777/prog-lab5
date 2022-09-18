package commands.server.simple;

import commands.abstractions.ServerCommand;
import io.TextFormatter;
import data.model.Organization;

public abstract class Remove extends ServerCommand {
    protected void removeOrganizationFromDataCollection(Organization organization) {
        dataManager.getCollection().remove(organization);
        dataManager.getIdGenerator().setToRemoved(organization.getId());
        dataManager.getCollectionInfo().decrementElementsAmount();
    }

    protected void setGoodResult(String deletedOrganizationName) {
        result = String.format("Удалена оганизация \"%s\"", deletedOrganizationName);
        result = TextFormatter.format(result, TextFormatter.Format.GREEN);      // highlighting
    }

    protected void setBadResult() {
        result = "В коллекции нет подходящего элемента";
        result = TextFormatter.format(result, TextFormatter.Format.RED);      // highlighting
    }
}
