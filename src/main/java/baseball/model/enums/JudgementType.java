package baseball.model.enums;

public enum JudgementType {
    SUCCESS(1), FAIL(0);

    private final int count;

    JudgementType(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
