package commands.server.creation;

import data.creators.OrganizationCreator;
import io.Terminal;
import commands.abstractions.ServerCommand;
import io.TextFormatter;
import data.model.Organization;

import java.time.LocalDateTime;


public class Add extends ServerCommand {
    protected final Terminal terminal;
    protected Organization organization;


    public Add(Terminal terminal) {
        this.name = "add {element}";
        this.description = "добавить новый элемент в коллекцию";
        this.terminal = terminal;
    }


    @Override
    public void execute() {
        initOrganization();
        addOrganizationToTheCollection();
    }

    protected void initOrganization() {
        OrganizationCreator creator = new OrganizationCreator(terminal, dataManager.getCollection());
        organization = creator.create();
        organization.setCreationDate(LocalDateTime.now());
    }

    protected void addOrganizationToTheCollection() {
        int id = dataManager.getIdGenerator().generateId();
        organization.setId(id);
        this.dataManager.getCollection().add(organization);
        this.dataManager.getCollectionInfo().incrementElementsAmount();
        this.result = TextFormatter.format("Элемент успешно добавлен", TextFormatter.Format.GREEN);
    }
}
