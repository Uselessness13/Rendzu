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

    public int[] calculate(Board board) {
        int[] answer = new int[2];
        answer[0] = random.nextInt(15);
        answer[1] = random.nextInt(15);

        ArrayList<int[]> availibleMovesForWin = new ArrayList<>();
        ArrayList<int[]> availibleMovesForDefence = new ArrayList<>();
        ArrayList<Integer> botsMaxes = new ArrayList<>();
        ArrayList<Integer> playersMaxes = new ArrayList<>();
        Board newBoard = new Board(board);
        int counter = 0;
        int ii, jj;
        int iip, jjp;
        int botMax;
        int playerMax;
        int max = 0;
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (newBoard.getIJ(i, j) != 0) {
                    if (newBoard.getIJ(i, j) == 1) {
                        int[] currentWays = newBoard.get8Ways(i, j, 1);
                        for (int k = 0; k < 8; k++) {
                            if (currentWays[k] >= max) {
                                max = currentWays[k];
                                int x = k == 0 ? i + 1 : k == 1 ? i + 1 : k == 2 ? i + 1 : k == 3 ? i : k == 4 ? i - 1 : k == 5 ? i - 1 : k == 6 ? i - 1 : i;
                                int y = k == 0 ? j + 1 : k == 1 ? j : k == 2 ? j - 1 : k == 3 ? j - 1 : k == 4 ? j - 1 : k == 5 ? j : k == 6 ? j + 1 : j + 1;
                                x = x > 14 ? 14 : x < 0 ? 0 : x;
                                y = y > 14 ? 14 : y < 0 ? 0 : y;
                                if (newBoard.getIJ(x, y) == 0)
                                    answer = new int[]{x, y};
                            }
                        }
                    }
                }
            }
        }

        answer[0] = answer[0] > 14 ? 14 : answer[0] < 0 ? 0 : answer[0];
        answer[1] = answer[1] > 14 ? 14 : answer[1] < 0 ? 0 : answer[1];

//                botMax = 0;
//                playerMax = 0;
//                if (newBoard.getIJ(i, j) != 0) {
//                    counter++;
//                    System.out.println("counter = " + counter);
//                    if (newBoard.getIJ(i, j) == -1) {
//                        int[] current = newBoard.get8Ways(i, j, -1);
//                        for (int k = 0; k < 8; k++)
//                            if (current[k] >= botMax) {
//                                ii = k < 3 ? i - 1 : k > 3 && k < 7 ? i + 1 : i;
//                                jj = k < 1 || k > 5 ? j - 1 : k > 1 && k < 5 ? j + 1 : j;
//                                botMax = current[k] + 1;
//                                botsMaxes.add(botMax);
//                                availibleMovesForWin.add(new int[]{ii, jj});
//                                availibleMovesForDefence.add(null);
//                            }
//                    } else {
//                        int[] currentPlayers = newBoard.get8Ways(i, j, 1);
//                        for (int k = 0; k < 8; k++) {
//                            if (currentPlayers[k] >= playerMax) {
//                                iip = k < 3 ? i - 1 : k > 3 && k < 7 ? i + 1 : i;
//                                jjp = k < 1 || k > 5 ? j - 1 : k > 1 && k < 5 ? j + 1 : j;
//                                playerMax = currentPlayers[k] + 1;
//                                playersMaxes.add(playerMax);
//                                availibleMovesForDefence.add(new int[]{iip, jjp});
//                                availibleMovesForWin.add(null);
//                            }
//                        }
//                    }
//                    System.out.println(Arrays.deepToString(availibleMovesForWin.toArray()));
//                    System.out.println(Arrays.deepToString(availibleMovesForDefence.toArray()));
//                }
//            }
//        }
//        playerMax = 0;
//        botMax = 0;
//        int indBot = 0;
//        int indPlayer = 0;
//        for (int i = 0; i < botsMaxes.size(); i++) {
//            Integer bm = botsMaxes.get(i);
//            if (bm > botMax) {
//                botMax = bm;
//                indBot = i;
//            }
//        }
//        for (int i = 0; i < playersMaxes.size(); i++) {
//            Integer pm = playersMaxes.get(i);
//            if (pm > playerMax) {
//                playerMax = pm;
//                indPlayer = i;
//            }
//        }
//        System.out.println(answer.toString() + " 1");
//        if (botMax > playerMax) {
//            answer = availibleMovesForWin.get(indBot) == null ? answer : availibleMovesForWin.get(indBot);
//        } else
//            answer = availibleMovesForDefence.get(indPlayer) == null ? answer : availibleMovesForDefence.get(indPlayer);
//        System.out.println(answer.toString() + "2");

        if (board.getIJ(answer[0], answer[1]) == 0 && board.rulesCheck(answer[0], answer[1], -1)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return answer;
        } else return null;
    }
}
