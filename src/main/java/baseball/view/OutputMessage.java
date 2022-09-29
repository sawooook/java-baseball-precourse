package baseball.view;


public class OutputMessage {

    public static void printGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printScore(StringBuilder scoreMessage) {
        System.out.println(scoreMessage);
    }
}
