package commands.server.creation;

import data.creators.AddressCreator;
import commands.server.simple.Remove;
import data.model.Address;
import data.model.Organization;
import io.Terminal;


public class RemoveByAddress extends Remove {
    private final AddressCreator creator;
    private Address address;


    public RemoveByAddress(Terminal terminal) {
        this.name = "remove_any_by_official_address {officialAddress}";
        this.description = "удалить из коллекции один элемент, " +
                "значение поля officialAddress которого эквивалентно заданному";
        this.creator = new AddressCreator(terminal);
    }


    @Override
    public void setArgs(String[] args) {
        checkArgumentsAmount(args, 0);
        address = creator.create();
    }

    @Override
    public void execute() {
        for (Organization organization : dataManager.getCollection()) {
            if (!organization.getOfficialAddress().equals(address))
                continue;
            removeOrganizationFromDataCollection(organization);
            setGoodResult(organization.getName());
            return;
        }
        setBadResult();
    }
}
