package data.creators;

import data.model.Coordinates;
import data.model.FieldDefinitionException;
import io.Terminal;

public class CoordinatesCreator extends Creator<Coordinates> {
    private enum CoordinatesArgument {X, Y}
    private CoordinatesArgument lastSetArgument;


    public CoordinatesCreator(Terminal terminal) {
        super(terminal);
        this.lastSetArgument = CoordinatesArgument.Y;
    }


    @Override
    protected Coordinates createNewInstance() {
        return new Coordinates();
    }

    @Override
    protected void defineFields() throws FieldDefinitionException {
        switch (lastSetArgument) {
            case Y: defineX();
            case X: defineY();
        }
    }


    private void defineX() throws RuntimeException {
        String[] input = terminal.readLineSplit("Введите координату X организации: " + formatRequirements("int, > -535"));
        checkArgumentsAmount(input, 1);
        try {
            creatingObject.setX(Integer.parseInt(input[0]));
        } catch (NumberFormatException e) {
            throw new FieldDefinitionException("Ожидалось целое число (int)");
        }
        this.lastSetArgument = CoordinatesArgument.X;
    }

    private void defineY() {
        String[] input = terminal.readLineSplit("Введите координату Y организации: " + formatRequirements("int, <= 630"));
        checkArgumentsAmount(input, 1);
        try {
            creatingObject.setY(Integer.parseInt(input[0]));
        } catch (NumberFormatException e) {
            throw new FieldDefinitionException("Ожидалось целое число (int)");
        }
        this.lastSetArgument = CoordinatesArgument.Y;
    }
}
