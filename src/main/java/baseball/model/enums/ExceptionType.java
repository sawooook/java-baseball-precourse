package baseball.model.enums;

public enum ExceptionType {
    INVALID_INPUT_NUMBER_SIZE("3자리 이상의 숫자를 입력 하셨습니다"),
    INVALID_NUMBER_FORMAT("유효하지 않은 숫자입니다."),
    INVALID_BLANK_NUMBER("공백이 포함되어있습니다."),
    INVALID_ZERO_NUMBER("숫자 0이 입력 되었습니다."),
    INVALID_DUPLICATED_NUMBER("중복 숫자가 입력되었습니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
