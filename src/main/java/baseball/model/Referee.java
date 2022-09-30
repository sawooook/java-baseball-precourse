package baseball.model;

import baseball.model.dto.JudgeResult;

import java.util.List;

import static baseball.utils.Constants.GAME_OVER_COUNT;
import static baseball.utils.Constants.NOT_COUNT;

public class Referee {

    public JudgeResult judge(List<Integer> userNumber, List<Integer> randomNumber) {
        int strikeCount = new Judgement().getStrikeCount(userNumber, randomNumber);
        int ballCount = new Judgement().getBallCount(userNumber, randomNumber);

        if (isNothing(ballCount, strikeCount)) {
            return JudgeResult.nothing();
        }

        if (isGameOver(strikeCount)) {
            return JudgeResult.gameOver();
        }

        return JudgeResult.of(strikeCount, ballCount);
    }

    private boolean isNothing(int ballCount, int strikeCount) {
        return ballCount == NOT_COUNT && strikeCount == NOT_COUNT;
    }

    private boolean isGameOver(int strikeCount) {
        return strikeCount == GAME_OVER_COUNT;
    }
}
