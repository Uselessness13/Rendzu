package Rendzu.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Useless on 15.05.2017.
 */
public class BOT {
    Random random;

    public BOT() {
        random = new Random();
    }

    public int[] calculateStep(Board board) {
        int[] answer = new int[2];
//        answer[0] = random.nextInt(15);
//        answer[1] = random.nextInt(15);

        Board newBoard = new Board(board);
        int maxPlayers = 0, maxBots = 0;
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                if (newBoard.getIJ(i, j) != 0) {
                    if (newBoard.getIJ(i, j) == 1) {
                        int[] currentWays = newBoard.get8Ways(i, j, 1);
                        for (int k = 0; k < 8; k++) {
                            if (currentWays[k] >= maxPlayers) {
                                maxPlayers = currentWays[k];
                                int x = k == 0 ? i + 1 : k == 1 ? i + 1 : k == 2 ? i + 1 : k == 3 ? i : k == 4 ? i - 1 : k == 5 ? i - 1 : k == 6 ? i - 1 : i;
                                int y = k == 0 ? j + 1 : k == 1 ? j : k == 2 ? j - 1 : k == 3 ? j - 1 : k == 4 ? j - 1 : k == 5 ? j : k == 6 ? j + 1 : j + 1;
                                x = x > 14 ? 14 : x < 0 ? 0 : x;
                                y = y > 14 ? 14 : y < 0 ? 0 : y;
                                if (newBoard.getIJ(x, y) == 0) {
                                    answer = (new int[]{x, y});
                                    if (maxPlayers >= 2) {
                                        return answer;
                                    }
                                }
                            }
                        }
                    } else {
                        int[] currentWays = newBoard.get8Ways(i, j, -1);
                        for (int k = 0; k < 8; k++) {
                            if (currentWays[k] >= maxBots) {
                                maxBots = currentWays[k];
                                int x = k == 0 ? i + 1 : k == 1 ? i + 1 : k == 2 ? i + 1 : k == 3 ? i : k == 4 ? i - 1 : k == 5 ? i - 1 : k == 6 ? i - 1 : i;
                                int y = k == 0 ? j + 1 : k == 1 ? j : k == 2 ? j - 1 : k == 3 ? j - 1 : k == 4 ? j - 1 : k == 5 ? j : k == 6 ? j + 1 : j + 1;
                                x = x > 14 ? 14 : x < 0 ? 0 : x;
                                y = y > 14 ? 14 : y < 0 ? 0 : y;
                                if (newBoard.getIJ(x, y) == 0) {
                                    answer = new int[]{x, y};
                                    if (maxBots >= 3)
                                        return answer;
                                }
                            }
                        }
                    }
                }

        answer[0] = answer[0] > 14 ? 14 : answer[0] < 0 ? 0 : answer[0];
        answer[1] = answer[1] > 14 ? 14 : answer[1] < 0 ? 0 : answer[1];

        if (board.getIJ(answer[0], answer[1]) == 0 && board.rulesCheck(answer[0], answer[1], -1)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(answer[0] + ";" + answer[1]);
            return answer;
        } else return null;
    }
}
