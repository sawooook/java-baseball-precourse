package baseball.model.dto;

public class DirectorResult {

    private final boolean isNothing;
    private final int strikeCount;
    private final int ballCount;

    public DirectorResult(boolean isNothing, int strikeCount, int ballCount) {
        this.isNothing = isNothing;
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public static DirectorResult of(int strikeCount, int ballCount) {
        return new DirectorResult(false, strikeCount, ballCount);
    }

    public static DirectorResult nothing() {
        return new DirectorResult(true, 0, 0);
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
}
