package baseball.logic;

import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private List<Integer> computerNumbers;
    private int countStrike;
    private int countBall;

    public BaseballGame() {
        this.computerNumbers = new ArrayList<>();
        this.countStrike = 0;
        this.countBall = 0;
    }

    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomlyExtractNumber();

        Player player = new Player();
        while (true) {
            player.guess();
            markNumber(player.getGuessNumbers()); // 채점
        }
    }

    private List<Integer> randomlyExtractNumber() {
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        System.out.println("컴퓨터 숫자: "+ computerNumbers);
        return computerNumbers;
    }

    private void markNumber(List<Integer> guessNumbers) {
        for (int i = 0; i < 3; i++) {
            System.out.println("검사중인 숫자: " + guessNumbers.get(i));
            // 스트라이크 검사
            int guessNumber = guessNumbers.get(i);
            if (guessNumber == computerNumbers.get(i)) {
                countStrike++;
            }
            // 볼 검사
            if (guessNumber == computerNumbers.get((i + 1) % 3)) {
                countBall++;
            }
            if (guessNumber == computerNumbers.get((i + 2) % 3)) {
                countBall++;
            }
        }
    }

}
