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
        if (board.getIJ(answer[0], answer[1]) == 0){
            return answer;
        }
        else return null;
    }
}
