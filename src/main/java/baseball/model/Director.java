package baseball.model;

import baseball.model.dto.DirectorResult;

import java.util.List;

public class Director {

    public DirectorResult judge(List<Integer> userNumber, List<Integer> randomNumber) {
        int strikeCount = new JudgeGame().getStrikeCount(userNumber, randomNumber);
        int ballCount = new JudgeGame().getBallCount(userNumber, randomNumber);

        if (isNothing(ballCount, strikeCount)) {
            return DirectorResult.nothing();
        }

        return DirectorResult.of(strikeCount, ballCount);
    }

    private boolean isNothing(int ballCount, int strikeCount) {
        return ballCount == 0 && strikeCount == 0;
    }
}
