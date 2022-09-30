package baseball.controller;

import baseball.model.RandomNumber;
import baseball.model.Referee;
import baseball.model.UserInputNumber;
import baseball.model.dto.JudgeResult;
import baseball.utils.MakeScoreUtil;
import baseball.view.InputMessage;
import baseball.view.OutputMessage;

import java.util.List;


public class BaseBallGame {

    public boolean PLAY_THE_GAME = true;

    public void start() {
        playTheGame(makeRandomNumber());
    }

    private void playTheGame(RandomNumber randomNumber) {
        while (PLAY_THE_GAME) {
            String inputNumber = InputMessage.printNumber();

            List<Integer> userNumber = new UserInputNumber(inputNumber).getNumber();

            // 판단 결과
            JudgeResult result = new Referee().judge(userNumber, randomNumber.getAnswer());

            // 스코어 메세지 생성
            StringBuilder scoreMessage = makeScoreMessage(result);

            OutputMessage.printScore(scoreMessage);

            checkGameOver(result);
        }
    }

    private StringBuilder makeScoreMessage(JudgeResult result) {
        if (result.isNothing()) {
            return MakeScoreUtil.makeNothing();
        }

        return MakeScoreUtil.makeName(result.getStrikeCount(), result.getBallCount());
    }

    private void checkGameOver(JudgeResult result) {
        if (result.isGameOver()) {
            OutputMessage.printGameOver();

            String selectType = InputMessage.printContinueGame();
            continueGame(selectType);
        }
    }

    private RandomNumber makeRandomNumber() {
        return new RandomNumber();
    }

    private void continueGame(String selectType) {
        if (selectType.equals("2")) {
            PLAY_THE_GAME = false;
            return;
        }

        playTheGame(makeRandomNumber());
    }
}
