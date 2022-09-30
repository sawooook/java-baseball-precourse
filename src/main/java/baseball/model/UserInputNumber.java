package baseball.model;

import baseball.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import static baseball.model.ExceptionType.*;
import static baseball.utils.Constants.*;

public class UserInputNumber {

    private final List<Integer> number;

    public UserInputNumber(String value) {
        number = new ArrayList<>();
        String[] splitNumber = splitNumber(value);
        addNumberIfValid(splitNumber);
    }

    private void addNumberIfValid(String[] splitNumber) {
        validCheckInputNumberSize(splitNumber);

        for (String value : splitNumber) {
            validCheckInputNumber(value);
            validCheckDuplicatedNumber(value);

            number.add(Integer.parseInt(value));
        }
    }

    private void validCheckInputNumberSize(String[] splitNumber) {
        if (splitNumber.length >= MAX_INPUT_NUMBER_SIZE) {
            throw new  IllegalArgumentException(INVALID_INPUT_NUMBER_SIZE.getMessage());
        }
    }

    private void validCheckDuplicatedNumber(String value) {
        if (number.contains(Integer.parseInt(value))) {
            throw new IllegalArgumentException(INVALID_DUPLICATED_NUMBER.getMessage());
        }
    }

    private String[] splitNumber(String inputNumber) {
        return inputNumber.split("");
    }

    private void validCheckInputNumber(String value) {
        validCheckBlank(value);
        validCheckNumberFormat(value);
        validCheckExceptionNumber(value);
    }

    private void validCheckNumberFormat(String value) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    private void validCheckBlank(String value) {
        if (value.equals(BLANK)) {
            throw new IllegalArgumentException(INVALID_BLANK_NUMBER.getMessage());
        }
    }

    private void validCheckExceptionNumber(String value) {
        int number = Integer.parseInt(value);
        if (number == EXCEPTION_NUMBER) {
            throw new IllegalArgumentException(INVALID_ZERO_NUMBER.getMessage());
        }
    }

    public List<Integer> getNumber() {
        return number;
    }
}
