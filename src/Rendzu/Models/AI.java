package Rendzu.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Useless on 15.05.2017.
 */
public class AI {
    Random random;

    public AI() {
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
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                botMax = 0;
                playerMax = 0;
                if (newBoard.getIJ(i, j) != 0) {
                    counter++;
                    System.out.println("counter = " + counter);
                    if (newBoard.getIJ(i, j) == -1) {
                        int[] current = newBoard.get8Ways(i, j, -1);
                        for (int k = 0; k < 8; k++)
                            if (current[k] >= botMax) {
                                ii = k < 3 ? i - 1 : k > 3 && k < 7 ? i + 1 : i;
                                jj = k < 1 || k > 5 ? j - 1 : k > 1 && k < 5 ? j + 1 : j;
                                botMax = current[k] + 1;
                                botsMaxes.add(botMax);
                                availibleMovesForWin.add(new int[]{ii, jj});
                                availibleMovesForDefence.add(null);
                            }
                    } else {
                        int[] currentPlayers = newBoard.get8Ways(i, j, 1);
                        for (int k = 0; k < 8; k++) {
                            if (currentPlayers[k] >= playerMax) {
                                iip = k < 3 ? i - 1 : k > 3 && k < 7 ? i + 1 : i;
                                jjp = k < 1 || k > 5 ? j - 1 : k > 1 && k < 5 ? j + 1 : j;
                                playerMax = currentPlayers[k] + 1;
                                playersMaxes.add(playerMax);
                                availibleMovesForDefence.add(new int[]{iip, jjp});
                                availibleMovesForWin.add(null);
                            }
                        }
                    }
                    System.out.println(Arrays.deepToString(availibleMovesForWin.toArray()));
                    System.out.println(Arrays.deepToString(availibleMovesForDefence.toArray()));
                }
            }
        }
        playerMax = 0;
        botMax = 0;
        int indBot = 0;
        int indPlayer = 0;
        for (int i = 0; i < botsMaxes.size(); i++) {
            Integer bm = botsMaxes.get(i);
            if (bm > botMax) {
                botMax = bm;
                indBot = i;
            }
        }
        for (int i = 0; i < playersMaxes.size(); i++) {
            Integer pm = playersMaxes.get(i);
            if (pm > playerMax) {
                playerMax = pm;
                indPlayer = i;
            }
        }
        System.out.println(answer.toString() + " 1");
        if (botMax > playerMax) {
            answer = availibleMovesForWin.get(indBot) == null ? answer : availibleMovesForWin.get(indBot);
        } else
            answer = availibleMovesForDefence.get(indPlayer) == null ? answer : availibleMovesForDefence.get(indPlayer);
        System.out.println(answer.toString() + "2");

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
