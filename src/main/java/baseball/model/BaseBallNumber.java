package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Constants.RANDOM_BASE_BALL_MAX_SIZE;

public class BaseBallNumber {

    private final List<Integer> baseBallNumber;

    public BaseBallNumber() {
        baseBallNumber = new ArrayList<>();
        makeNumber();
    }

    private void makeNumber() {
        while (baseBallNumber.size() < RANDOM_BASE_BALL_MAX_SIZE) {
            int selectNumber = Randoms.pickNumberInRange(1, 9);
            addBaseBallNumberIfNotDuplicated(selectNumber);
        }
    }

    private void addBaseBallNumberIfNotDuplicated(int selectNumber) {
        if (baseBallNumber.contains(selectNumber)) {
            return;
        }

        baseBallNumber.add(selectNumber);
    }

    public List<Integer> getAnswer() {
        return baseBallNumber;
    }
}

