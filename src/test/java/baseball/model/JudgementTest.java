package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JudgementTest {

    @ParameterizedTest
    @MethodSource("makeNumberForStrikeTest")
    @DisplayName("유저가 입력한 숫자와 랜덤숫자의 위치와 값이 일치할 경우 strike 숫자가 올라간다.")
    void strike(List<Integer> userNumber, List<Integer> randomNumber, int result) {
        System.out.println(userNumber);
        int strikeCount = new Judgement().getStrikeCount(userNumber, randomNumber);

        assertEquals(strikeCount, result);
    }

    public static Stream<Arguments> makeNumberForStrikeTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3), 3),
                Arguments.of(Arrays.asList(1, 2, 5), Arrays.asList(1, 2, 7), 2),
                Arguments.of(Arrays.asList(9, 2, 5), Arrays.asList(4, 2, 7), 1),
                Arguments.of(Arrays.asList(9, 2, 5), Arrays.asList(4, 5, 7), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("makeNumberForBallTest")
    @DisplayName("유저가 입력한 숫자와 랜덤숫자의 값이 자리만 다를 경우 ball 숫자가 올라간다.")
    void ball(List<Integer> userNumber, List<Integer> randomNumber, int result) {
        System.out.println(userNumber);
        int ballCount = new Judgement().getBallCount(userNumber, randomNumber);

        assertEquals(ballCount, result);
    }

    public static Stream<Arguments> makeNumberForBallTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(3, 4, 5), Arrays.asList(9, 8, 7), 0),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(3, 2, 4), 1),
                Arguments.of(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 1), 1),
                Arguments.of(Arrays.asList(3, 4, 5), Arrays.asList(9, 5, 3), 2),
                Arguments.of(Arrays.asList(3, 4, 5), Arrays.asList(3, 5, 4), 2),
                Arguments.of(Arrays.asList(3, 4, 5), Arrays.asList(4, 5, 3), 3)
        );
    }
}