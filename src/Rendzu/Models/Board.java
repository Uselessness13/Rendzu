package Rendzu.Models;

import sun.misc.Unsafe;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

/**
 * Created by Useless on 15.05.2017.
 */
public class Board {
    private int[][] board;
    private int active;
    private int numberOfSteps;
    private boolean gamestarted;


    public Board() {
        this.board = new int[15][15];
        this.active = 1;
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                this.board[i][j] = i == 7 && j == 7 ? -1 : 0;
        numberOfSteps = 1;
        gamestarted = true;
    }


    Board(Board board) {
        this.board = new int[15][15];
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                this.board[i][j] = board.board[i][j];
        this.numberOfSteps = board.numberOfSteps;
        this.gamestarted = board.gamestarted;
    }

    void setIJ(int i, int j, int eye) {
        if (this.board[i][j] == 0) {
            this.board[i][j] = eye;
            numberOfSteps++;
        }
    }

    public int getIJ(int i, int j) {
        return this.board[i][j];
    }

    public void makeStep(int i, int j, int eye) {
        if (gamestarted) {
            if (board[i][j] == 0 && rulesCheck(i, j, eye)) {
                setIJ(i, j, eye);
                this.active *= -1;
            }
            System.out.println(numberOfSteps);
        }
    }

    public int getActive(){
        return this.active;
    }

    public boolean getGame(){
        return this.gamestarted;
    }

    public boolean rulesCheck(int i, int j, int eye) {
        if (eye == 1 && active == 1) {
            if (numberOfSteps == 1) {
                if ((i >= 6 && i <= 8) && (j >= 6 && j <= 8)) {
                    return true;
                }
            } else return true;
        } else if (eye == -1 && active == -1) {
            if (numberOfSteps == 2) {
                if ((i >= 5 && i <= 9) && (j >= 5 && j <= 9)) {
                    return true;
                }
            } else return true;
        }
        return false;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public ArrayList<ArrayList<int[]>> getLines(int eye) {
        ArrayList<ArrayList<int[]>> lines = new ArrayList<>();

        int i = 0;
        for (int k = 0; k < 15; k++) {
            while (i < 14) {
                if (board[k][i] == eye) {
                    ArrayList<int[]> currentLine = new ArrayList<>();
                    int j = i + 1;
                    currentLine.add(new int[]{k, i});
                    while (j < 15) {
                        if (board[k][j] == eye) {
                            currentLine.add(new int[]{k, j});
                            j++;
                        } else {
                            i = j;
                            break;
                        }
                    }
                    lines.add(currentLine);
                }
                if (board[i][k] == eye) {
                    ArrayList<int[]> currentRow = new ArrayList<>();
                    int j = i + 1;
                    currentRow.add(new int[]{i, k});
                    while (j < 15) {
                        if (board[j][k] == eye) {
                            currentRow.add(new int[]{j, k});
                            j++;
                        } else {
                            i = j;
                            break;
                        }
                    }
                    lines.add(currentRow);
                }
            }
        }

        return lines;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }
}
