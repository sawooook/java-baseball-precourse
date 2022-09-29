package baseball.controller;

import baseball.model.Director;
import baseball.model.RandomNumber;
import baseball.model.UserInputNumber;
import baseball.model.dto.DirectorResult;
import baseball.view.PrintMessage;

import java.util.List;


public class BaseBallGame {

    public static boolean PLAY_THE_GAME = true;

    public void start() {
        playTheGame(getRandomNumber());
    }

    private void playTheGame(RandomNumber randomNumber) {
        while (PLAY_THE_GAME) {
            String inputNumber = PrintMessage.inputNumber();
            List<Integer> userNumber = new UserInputNumber(inputNumber).getNumber();

            DirectorResult result = new Director().judge(userNumber, randomNumber.getAnswer());

            checkGameOver(result);
        }
    }

    private void checkGameOver(DirectorResult result) {
        if (result.isGameOver()) {
            PrintMessage.inputContinueGame();
        }
    }

    private RandomNumber getRandomNumber() {
        return new RandomNumber();
    }
}
