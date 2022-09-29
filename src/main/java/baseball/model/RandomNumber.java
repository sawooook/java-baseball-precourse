package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Constants.BASE_BALL_MAX_SIZE;

public class RandomNumber {

    private final List<Integer> randomNumber;

    public RandomNumber() {
        randomNumber = new ArrayList<>();
        makeNumber();
    }

    private void makeNumber() {
        while (randomNumber.size() < BASE_BALL_MAX_SIZE) {
            int selectNumber = Randoms.pickNumberInRange(1, 9);
            addBaseBallNumberIfNotDuplicated(selectNumber);
        }
    }

    private void addBaseBallNumberIfNotDuplicated(int selectNumber) {
        if (randomNumber.contains(selectNumber)) {
            return;
        }

        randomNumber.add(selectNumber);
    }

    public List<Integer> getAnswer() {
        return randomNumber;
    }
}

