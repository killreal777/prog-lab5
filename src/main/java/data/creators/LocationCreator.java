package data.creators;

import data.model.FieldDefinitionException;
import data.model.Location;
import io.Terminal;


public class LocationCreator extends Creator<Location> {
    private enum LocationArgument {X, Y, Z, NAME}
    private LocationArgument lastSetArgument;


    public LocationCreator(Terminal terminal) {
        super(terminal);
        this.lastSetArgument = LocationArgument.NAME;
    }


    @Override
    protected Location createNewInstance() {
        return new Location();
    }

    @Override
    protected void defineFields() {
        switch (lastSetArgument) {
            case NAME: defineX();
            case X: defineY();
            case Y: defineZ();
            case Z: defineName();
        }
    }


    private void defineX() throws RuntimeException {
        String[] input = terminal.readLineSplit("Введите координату X локации: " + formatRequirements("Long, not null"));
        checkArgumentsAmount(input, 1);
        try {
            creatingObject.setX(Long.parseLong(input[0]));
        } catch (NumberFormatException e) {
            throw new FieldDefinitionException("Ожидалось целое число (Long)");
        }
        this.lastSetArgument = LocationArgument.X;
    }

    private void defineY() {
        String[] input = terminal.readLineSplit("Введите координату Y локации: " + formatRequirements("int"));
        checkArgumentsAmount(input, 1);
        try {
            creatingObject.setY(Integer.parseInt(input[0]));
        } catch (NumberFormatException e) {
            throw new FieldDefinitionException("Ожидалось целое число (int)");
        }
        this.lastSetArgument = LocationArgument.Y;
    }

    private void defineZ() {
        String[] input = terminal.readLineSplit("Введите координату Z локации: " + formatRequirements("float"));
        checkArgumentsAmount(input, 1);
        try {
            creatingObject.setZ(Float.parseFloat(input[0]));
        } catch (NumberFormatException e) {
            throw new FieldDefinitionException("Ожидалось число с плавающей запятой (float)");
        }
        this.lastSetArgument = LocationArgument.Z;
    }

    private void defineName() {
        String input = terminal.readLineEntire("Введите название локации: " + formatRequirements("String, not null"));
        creatingObject.setName(input);
        this.lastSetArgument = LocationArgument.NAME;
    }
}



