package data.NUZHNO_PRIDUMAT_IMYA;

import data.model.FieldDefinitionException;
import data.model.Organization;

import java.util.ArrayList;
import java.util.PriorityQueue;


/**
 * Class for validation special data data.model objects fields requirements, which can't be validated by theirs constructors
 */


public class DataSpecialValidator {
    /**
     * Validates all special requirements
     */
    public void validate(PriorityQueue<Organization> collection) throws FieldDefinitionException {
        checkIdUniqueness(collection);
        checkFullNameUniqueness(collection);
    }

    private void checkIdUniqueness(PriorityQueue<Organization> collection) throws FieldDefinitionException {
        ArrayList<Integer> idList = new ArrayList<>();
        Integer id;
        for (Organization org : collection) {
            id = org.getId();
            if (idList.contains(id))
                throw new FieldDefinitionException("Обнаружен неуникальный ID: " + id);
            idList.add(id);
        }
    }

    private void checkFullNameUniqueness(PriorityQueue<Organization> collection) throws FieldDefinitionException {
        ArrayList<String> fullNameList = new ArrayList<>();
        String fullName;
        for (Organization org : collection) {
            fullName = org.getFullName();
            if (fullNameList.contains(fullName))
                throw new FieldDefinitionException("Обнаружено неуникальное полное имя организации: " + fullName);
            fullNameList.add(fullName);
        }
    }
}
