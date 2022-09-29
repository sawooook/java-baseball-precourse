package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.utils.Constants.BASE_BALL_MAX_SIZE;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {

    @Test
    @DisplayName("랜덤숫자는 중복되지 않아야한다.")
    void isNotDuplicatedRandomNumber() {
        RandomNumber randomNumber = new RandomNumber();

        List<Integer> result = randomNumber.getAnswer();
        Set<Integer> answer = new HashSet<>(result);

        assertEquals(answer.size(), BASE_BALL_MAX_SIZE);
    }

    @Test
    @DisplayName("랜덤숫자는 3자리여야 한다.")
    void randomNumberSize() {
        RandomNumber randomNumber = new RandomNumber();

        List<Integer> result = randomNumber.getAnswer();

        assertEquals(result.size(), BASE_BALL_MAX_SIZE);
    }
}