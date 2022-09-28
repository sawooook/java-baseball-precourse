package baseball.model;

import java.util.List;

import static baseball.utils.Constants.*;

public class JudgeGame {

    private int judgementCount = 0;

    public int getStrikeCount(List<Integer> userNumber, List<Integer> randomNumber) {
        for (int i = 0; i < RANDOM_BASE_BALL_MAX_SIZE; i++) {
            judgementCount += getCountIfStrike(userNumber.get(i), randomNumber.get(i));
        }

        return judgementCount;
    }

    public int getBallCount(List<Integer> userNumber, List<Integer> randomNumber) {
        for (int i = 0; i < RANDOM_BASE_BALL_MAX_SIZE; i++) {
            judgementCount += getCountIfBall(userNumber.get(i), randomNumber.get(i), randomNumber);
        }

        return judgementCount;
    }

    private int getCountIfStrike(Integer userNumber, Integer randomNumber) {
        if (isStrike(userNumber, randomNumber)) {
            return 1;
        }

        return 0;
    }

    private Boolean isStrike(Integer userNumber, Integer randomNumber) {
        return userNumber.equals(randomNumber);
    }

    private int getCountIfBall(Integer userNumber, Integer randomNumber, List<Integer> randomNumberList) {
        if (isStrike(userNumber, randomNumber)) {
            return 0;
        }

        if (isBall(userNumber, randomNumberList)) {
            return 1;
        }


        return 0;
    }

    private boolean isBall(Integer userNumber, List<Integer> randomNumberList) {
        return randomNumberList.contains(userNumber);
    }
}
