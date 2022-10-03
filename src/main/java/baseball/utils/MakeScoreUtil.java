package baseball.utils;

public class MakeScoreUtil {

    public static StringBuilder makeName(int strikeCount, int ballCount) {
        StringBuilder builder = new StringBuilder();
        if (ballCount != 0) {
            builder.append(ballCount).append("볼").append(" ");
        }

        if (strikeCount != 0) {
            builder.append(strikeCount).append("스트라이크");
        }

        return builder;
    }

    public static StringBuilder makeNothing() {
        return new StringBuilder().append("낫싱");
    }
}
