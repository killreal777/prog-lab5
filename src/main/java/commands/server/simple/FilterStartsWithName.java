package commands.server.simple;

import commands.abstractions.ServerCommand;
import data.model.Organization;

import java.util.regex.Pattern;


public class FilterStartsWithName extends ServerCommand {
    private Pattern nameRegex;


    public FilterStartsWithName() {
        this.name = "filter_starts_with_name name";
        this.description = "вывести элементы, значение поля name которых начинается с заданной подстроки";
    }


    @Override
    public void setArgs(String[] args) {
        checkArgumentsAmount(args, 1);
        this.nameRegex = Pattern.compile("^" + args[0] + ".*");
    }


    @Override
    public void execute() {
        for (Organization organization : dataManager.getCollection()) {
            if (!nameRegex.matcher(organization.getName()).matches())
                continue;
            if (!result.equals(""))
                result += "\n";
            result += organization.toString();
        }
        if (result.equals(""))
            result = "В коллекции нет элементов, значение поля name которых начинается с заданной подстроки";
    }
}
