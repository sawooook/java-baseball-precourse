package baseball.model;

import baseball.model.enums.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class UserInputNumberTest {

    @Test
    @DisplayName("유저가 입력한 값을 성공적으로 변환한다")
    void inputSuccess() {
        String inputNumber = "123";

        UserInputNumber userInputNumber = new UserInputNumber(inputNumber);

        assertEquals(userInputNumber.getNumber().size(), 3);
        assertEquals(userInputNumber.getNumber().get(0), 1);
        assertEquals(userInputNumber.getNumber().get(1), 2);
        assertEquals(userInputNumber.getNumber().get(2), 3);
    }

    @Test
    @DisplayName("공백이 포함되면 오류가 발생한다")
    void blankFail() {
        String inputNumber = "12 ";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new UserInputNumber(inputNumber);
                }).withMessageMatching(ExceptionType.INVALID_BLANK_NUMBER.getMessage());
    }

    @Test
    @DisplayName("숫자가 아닌 값이 들어가면 오류가 발생한다")
    void numberFormatFail() {
        String inputNumber = "12ㄱ";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new UserInputNumber(inputNumber);
                }).withMessageMatching(ExceptionType.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("숫자 0이 들어가면 오류가 발생한다")
    void numberZeroFail() {
        String inputNumber = "120";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new UserInputNumber(inputNumber);
                }).withMessageMatching(ExceptionType.INVALID_ZERO_NUMBER.getMessage());
    }

    @Test
    @DisplayName("중복 숫자를 적을시 오류가 발생한다")
    void duplicatedFail() {
        String inputNumber = "121";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new UserInputNumber(inputNumber);
                }).withMessageMatching(ExceptionType.INVALID_DUPLICATED_NUMBER.getMessage());
    }


    @DisplayName("네자리 이상 숫자가 입력 될 경우 오류가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12345", "123456"})
    void numberSizeFail(String inputNumber) {
        
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new UserInputNumber(inputNumber);
                }).withMessageMatching(ExceptionType.INVALID_INPUT_NUMBER_SIZE.getMessage());
    }
}