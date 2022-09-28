package baseball.model;

import baseball.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.ExceptionType.*;
import static baseball.utils.Constants.*;

public class UserInputNumber {

    private List<Integer> number;

    public UserInputNumber(String value) {
        number = new ArrayList<>();
        String[] splitNumber = splitNumber(value);
        addNumberIfValid(splitNumber);
    }

    private void addNumberIfValid(String[] splitNumber) {
        for (String value : splitNumber) {
            validCheckInputNumber(value);
            checkDuplicatedNumber(value);
            number.add(Integer.parseInt(value));
        }
    }

    private void checkDuplicatedNumber(String value) {
        if (number.contains(Integer.parseInt(value))) {
            throw new IllegalArgumentException(INVALID_DUPLICATED_NUMBER.getMessage());
        }
    }

    private String[] splitNumber(String inputNumber) {
        return inputNumber.split("");
    }

    private void validCheckInputNumber(String value) {
        checkBlank(value);
        checkNumberFormat(value);
        checkZeroNumber(value);
    }

    private void checkNumberFormat(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void checkBlank(String value) {
        System.out.println(value);
        if (value.equals(BLANK)) {
            throw new IllegalArgumentException(INVALID_BLANK_NUMBER.getMessage());
        }
    }

    private void checkZeroNumber(String value) {
        int number = Integer.parseInt(value);
        if (number == 0) {
            throw new IllegalArgumentException(INVALID_ZERO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumber() {
        return number;
    }
}
