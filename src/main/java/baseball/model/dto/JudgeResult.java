package baseball.model.dto;

import static baseball.utils.Constants.GAME_OVER_COUNT;
import static baseball.utils.Constants.NOT_COUNT;

public class JudgeResult {

    private final boolean isGameOver;
    private final boolean isNothing;
    private final int strikeCount;
    private final int ballCount;

    public JudgeResult(boolean isGameOver, boolean isNothing, int strikeCount, int ballCount) {
        this.isGameOver = isGameOver;
        this.isNothing = isNothing;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static JudgeResult of(int strikeCount, int ballCount) {
        return new JudgeResult(false, false, strikeCount, ballCount);
    }

    public static JudgeResult nothing() {
        return new JudgeResult(false, true, NOT_COUNT, NOT_COUNT);
    }

    public static JudgeResult gameOver() {
        return new JudgeResult(true, false, GAME_OVER_COUNT, NOT_COUNT);
    }

    public boolean isNothing() {
        return isNothing;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isGameOver() {
        return isGameOver;
    }
}
