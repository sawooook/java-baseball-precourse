package baseball.model;

import baseball.model.dto.DirectorResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
}