package baseball.model.dto;

import static baseball.utils.Constants.NOT_COUNT;

public class DirectorResult {

    private final boolean isGameOver;
    private final boolean isNothing;
    private final int strikeCount;
    private final int ballCount;

    public DirectorResult(boolean isGameOver, boolean isNothing, int strikeCount, int ballCount) {
        this.isGameOver = isGameOver;
        this.isNothing = isNothing;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static DirectorResult of(int strikeCount, int ballCount) {
        return new DirectorResult(false, false, strikeCount, ballCount);
    }

    public static DirectorResult nothing() {
        return new DirectorResult(false, true, NOT_COUNT, NOT_COUNT);
    }

    public static DirectorResult gameOver() {
        return new DirectorResult(true, false, NOT_COUNT, NOT_COUNT);
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
