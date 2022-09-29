package baseball.model;

import baseball.model.dto.DirectorResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class DirectorTest {

    @Test
    @DisplayName("스트라이크와 볼 둘다 존재하지 않으면 낫씽으로 판단한다.")
    void judgeNothing() {
        List<Integer> userNumber = Arrays.asList(1, 2, 3);
        List<Integer> randomNumber = Arrays.asList(4, 5, 6);

        DirectorResult judge = new Director().judge(userNumber, randomNumber);

        assertTrue(judge.isNothing());
        assertEquals(judge.getBallCount(), 0);
        assertEquals(judge.getStrikeCount(), 0);
    }

    @Test
    @DisplayName("3스트라이크일 경우 게임이 종료되었다고 판단한다.")
    void gameOver() {
        List<Integer> userNumber = Arrays.asList(1, 2, 3);
        List<Integer> randomNumber = Arrays.asList(1, 2, 3);

        DirectorResult judge = new Director().judge(userNumber, randomNumber);

        assertTrue(judge.isGameOver());
        assertFalse(judge.isNothing());
        assertEquals(judge.getBallCount(), 0);
        assertEquals(judge.getStrikeCount(), 0);
    }

    @ParameterizedTest
    @MethodSource("makeNumber")
    @DisplayName("낫씽도 스트라이크도 아닐 경우 감독이 햔재 스코어를 알려준다.")
    void getScore(List<Integer> userNumber, List<Integer> randomNumber, int strikeCount, int ballCount) {
        DirectorResult judge = new Director().judge(userNumber, randomNumber);

        assertFalse(judge.isGameOver());
        assertFalse(judge.isNothing());
        assertEquals(judge.getBallCount(), ballCount);
        assertEquals(judge.getStrikeCount(), strikeCount);
    }

    public static Stream<Arguments> makeNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, 4, 5), Arrays.asList(3, 8, 7), 1, 0),
                Arguments.of(Arrays.asList(3, 4, 9), Arrays.asList(3, 4, 7), 2, 0),
                Arguments.of(Arrays.asList(3, 4, 5), Arrays.asList(4, 3, 1), 0, 2),
                Arguments.of(Arrays.asList(3, 4, 5), Arrays.asList(3, 5, 4), 1, 2)
        );
    }
}