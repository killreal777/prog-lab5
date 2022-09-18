package commands.server.creation;

import io.TextFormatter;
import data.model.Organization;
import io.Terminal;


public class AddIfMax extends Add {
    public AddIfMax(Terminal terminal) {
        super(terminal);
        this.name = "add_if_max {element}";
        this.description = "добавить новый элемент в коллекцию, " +
                "если его значение превышает значение наибольшего элемента этой коллекции";
    }


    @Override
    public void execute() {
        initOrganization();
        for (Organization org : dataManager.getCollection()) {
            if (this.organization.compareTo(org) <= 0) {
                result = "Значение элемента не превышает значение наибольщего элемента в коллекции";
                result = TextFormatter.format(result, TextFormatter.Format.RED);    // highlight
                return;
            }
        }
        addOrganizationToTheCollection();
    }
}
