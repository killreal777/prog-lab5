package commands.abstractions;

import commands.exceptions.CommandArgumentException;

/**
 * Superclass for all Commands
 */


public abstract class Command implements Cloneable {
    protected String name;
    protected String description;
    protected String result;


    public Command() {
        this.name = "no name";
        this.description = "no description";
        this.result = "";
    }


    @Override
    public Command clone() {
        try {
            return (Command) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }


    abstract public void execute();


    public void setArgs(String[] args) {
        checkArgumentsAmount(args, 0);   // command doesn't have any arguments by default
    }

    protected void checkArgumentsAmount(String[] args, int amount) {
        if (args.length != amount)
            throw new CommandArgumentException(String.format("Неверное число аргументов (введено: %s, ожидалось: %s)",
                    args.length, amount));
    }


    public String getResult() {
        return result;
    }

    public String getHelp() {
        return String.format("%s: %s", name, description);
    }


    @Override
    public String toString() {
        return name;
    }
}
