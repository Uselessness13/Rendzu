package Rendzu.Models;

/**
 * Created by Useless on 15.05.2017.
 */
public class Board {
    private int[][] board;
    private int active;


    public Board() {
        this.board = new int[15][15];
        this.active = 1;
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                this.board[i][j] = 0;
    }

    Board(Board board) {
        this.board = new int[15][15];
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                this.board[i][j] = board.board[i][j];
    }

    void setIJ(int i, int j, int eye) {
        if (this.board[i][j] == 0)
            this.board[i][j] = eye;
    }

    void makestep(int i, int j, int eye) {
        if (eye == 1 && active == 1) {
            if (true) {
                setIJ(i, j, eye);
            }
        } else if (eye == -1 && active == -1){
            if (true) {
                setIJ(i, j, eye);
            }
        }
        active = active == 1 ? -1 : 1;
    }
}
