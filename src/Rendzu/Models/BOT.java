package Rendzu.Models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
            for (int j = 0; j < 15; j++) {
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
                } else {
                    int[] currentb = newBoard.get8Ways(i,j,-1);
                    int[] currentp = newBoard.get8Ways(i,j,1);
                    if (currentb[0]+currentb[4] >= 3 || currentb[1]+currentb[5] >= 3 || currentb[2] + currentb[6] >= 3 || currentb[3] + currentb[7] >=3)
                        return new int[]{i,j};
                    if (currentp[0]+currentp[4] >= 3 || currentp[1]+currentp[5] >= 3 || currentp[2] + currentp[6] >= 3 || currentp[3] + currentp[7] >=3)
                        return new int[]{i,j};
                }
            }

//        HashMap<Integer, int[]> bot = new HashMap<>();
//        HashMap<Integer, int[]> player = new HashMap<>();
//        for (int i = 0; i < 15; i++)
//            for (int j = 0; j < 15; j++) {
//                if (board.getIJ(i, j) == 0) {
//                    int[] currentCellForBot = board.get8Ways(i, j, -1);
//                    int[] currentCellForPlayer = board.get8Ways(i, j, 1);
//                    int mb = 0, mp = 0;
//                    for (int k = 0; k < 8; k++) {
//                        mb = mb > currentCellForBot[k]    ? currentCellForBot[k]    : mb;
//                        mp = mp > currentCellForPlayer[k] ? currentCellForPlayer[k] : mp;
//                    }
//                    if (mb >= mp) {
//                        bot.put(mb + mp, new int[]{i, j});
//                    } else player.put(mb + mp, new int[]{i, j});
//                }
//            }
//        System.out.println(bot);
//        System.out.println(player);
//        ArrayList<Integer> botKeys = new ArrayList<>();
//        ArrayList<Integer> playerKeys = new ArrayList<>();
//        int mb = 0;
//        botKeys.addAll(bot.keySet());
//        playerKeys.addAll(player.keySet());
//        System.out.println(botKeys);
//        System.out.println(playerKeys);
//        for (Integer botKey : botKeys) {
//            System.out.print(Arrays.toString(bot.get(botKey)) + ", ");
//            mb = botKey > mb ? botKey : mb;
//        }
//        System.out.println();
//        int[] ba = bot.get(mb);
//        System.out.println("BA = " + ba);
//        int mp = 0;
//        for (Integer playerKey : playerKeys) {
//            System.out.print(Arrays.toString(player.get(playerKey)) + ", ");
//            mp = playerKey > mp ? playerKey : mp;
//        }
//        int[] pa = bot.get(mp);
//        System.out.println("PA = " + pa);
//        if (mb > mp)
//            answer = ba;
//        else answer = pa;
//        if (answer != null) {
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
