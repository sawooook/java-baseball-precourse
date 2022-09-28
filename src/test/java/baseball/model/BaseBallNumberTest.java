package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.utils.Constants.RANDOM_BASE_BALL_MAX_SIZE;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallNumberTest {

    @Test
    @DisplayName("랜덤숫자는 중복되지 않아야한다.")
    void isNotDuplicatedRandomNumber() {
        BaseBallNumber baseBallNumber = new BaseBallNumber();

        List<Integer> result = baseBallNumber.getAnswer();
        Set<Integer> answer = new HashSet<>(result);

        assertEquals(answer.size(), RANDOM_BASE_BALL_MAX_SIZE);
    }

    @Test
    @DisplayName("랜덤숫자는 3자리여야 한다.")
    void randomNumberSize() {
        BaseBallNumber baseBallNumber = new BaseBallNumber();

        List<Integer> result = baseBallNumber.getAnswer();

        assertEquals(result.size(), RANDOM_BASE_BALL_MAX_SIZE);
    }
}