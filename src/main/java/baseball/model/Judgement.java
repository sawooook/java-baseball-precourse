package baseball.model;

import java.util.List;

import static baseball.utils.Constants.*;

public class Judgement {

    private int judgementCount = 0;

    public int getStrikeCount(List<Integer> userNumber, List<Integer> randomNumber) {
        for (int i = INIT_NUMBER; i < BASE_BALL_MAX_SIZE; i++) {
            judgementCount += getCountIfStrike(userNumber.get(i), randomNumber.get(i)).getCount();
        }

        return judgementCount;
    }

    public int getBallCount(List<Integer> userNumber, List<Integer> randomNumber) {
        for (int i = INIT_NUMBER; i < BASE_BALL_MAX_SIZE; i++) {
            judgementCount += getCountIfBall(userNumber.get(i), randomNumber.get(i), randomNumber).getCount();
        }

        return judgementCount;
    }

    private JudgementType getCountIfStrike(Integer userNumber, Integer randomNumber) {
        if (isStrike(userNumber, randomNumber)) {
            return JudgementType.SUCCESS;
        }

        return JudgementType.FAIL;
    }

    private Boolean isStrike(Integer userNumber, Integer randomNumber) {
        return userNumber.equals(randomNumber);
    }

    private JudgementType getCountIfBall(Integer userNumber, Integer randomNumber, List<Integer> randomNumberList) {
        if (isStrike(userNumber, randomNumber)) {
            return JudgementType.FAIL;
        }

        if (isBall(userNumber, randomNumberList)) {
            return JudgementType.SUCCESS;
        }

        return JudgementType.FAIL;
    }

    private boolean isBall(Integer userNumber, List<Integer> randomNumberList) {
        return randomNumberList.contains(userNumber);
    }
}
