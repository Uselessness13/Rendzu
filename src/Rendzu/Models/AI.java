package Rendzu.Models;

import java.util.Random;

/**
 * Created by Useless on 15.05.2017.
 */
public class AI {
    Random random;
    public AI(){
        random = new Random();
    }

    public int[] calculate(Board board){
        int[] answer = new int[2];
        answer[0] = random.nextInt(15);
        answer[1] = random.nextInt(15);
        Board newBoard = new Board(board);
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                if (newBoard.getIJ(i, j) == -1) {
                    int[] current = newBoard.get8Ways(i, j, -1);
                    int max = 0;
                    for (int k = 0; k < 8; k++) {
                        if (current[k] > max){
                            max = current[max];
                        }
                    }
                }
        if (board.getIJ(answer[0], answer[1]) == 0 && board.rulesCheck(answer[0], answer[1], -1)){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }



            return answer;
        }
        else return null;
    }
}
