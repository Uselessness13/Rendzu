package Rendzu.Models;

import sun.misc.Unsafe;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;

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

    public void print() {
        int[][] rows = getRows();
        System.out.println("Rows");
        for (int i = 0; i < rows.length; i++) {
            System.out.println(Arrays.toString(rows[i]));
        }
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
//        print();
    }

    public int getActive() {
        return this.active;
    }

    public boolean getGame() {
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
                if ((i >= 5 && i <= 9) && (j >= 5 && j <= 9)) return true;
            } else {
                Board newBoard = new Board(this);
                newBoard.setIJ(i, j, eye);

                int ux = i - 1, uanswer = 0;
                while (ux >= 0) {
                    if (board[ux][j] == eye) {
                        uanswer++;
                    } else break;
                    ux--;
                }

                int dx = i + 1, danswer = 0;
                while (dx < 15) {
                    if (board[dx][j] == eye) {
                        danswer++;
                    } else break;
                    dx++;
                }

                int rx = j + 1, ranswer = 0;
                while (rx < 15) {
                    if (board[i][rx] == eye) {
                        ranswer++;
                    } else break;
                    rx++;
                }

                int lx = j - 1, lanswer = 0;
                while (lx >= 0) {
                    if (board[i][lx] == eye) {
                        lanswer++;
                    } else break;
                    lx--;
                }

                int ulx = i - 1, uly = j - 1;
                int ulanswer = 0;
                while (ulx >= 0 && uly >= 0) {
                    if (board[ulx][uly] == eye) {
                        ulanswer++;
                    } else break;
                    ulx--;
                    uly--;
                }
                int urx = i - 1, ury = j + 1;
                int uranswer = 0;
                while (urx >= 0 && ury <= 15) {
                    if (board[urx][ury] == eye) {
                        uranswer++;
                    } else break;
                    urx--;
                    ury++;
                }

                int dlx = i + 1, dly = j - 1;
                int dlanswer = 0;
                while (dlx <= 15 && dly >= 0) {
                    if (board[dlx][dly] == eye) {
                        dlanswer++;
                    } else break;
                    dlx++;
                    dly--;
                }
                int drx = i + 1, dry = j + 1;
                int dranswer = 0;
                while (drx <= 15 && dry <= 15) {
                    if (board[drx][dry] == eye) {
                        dranswer++;
                    } else break;
                    drx++;
                    dry++;
                }

                // пути, по которым просматриваем свои глаза
                int[] ways = new int[]{ulanswer, uanswer, uranswer, ranswer, dranswer, danswer, dlanswer, lanswer};

                System.out.println(Arrays.toString(ways));
                // проверяем прямые
                // проверка на длинный ряд
                if (danswer + uanswer == 5 || lanswer + ranswer == 5 || dlanswer + uranswer == 5 || ulanswer + dranswer == 5)
                    return false;
                // проверка на вилки
                int max = 0;
                for (int k = 0; k < 7; k++)
                    for (int l = k + 1; l < 8; l++)
                        if (ways[k] + ways[l] > max) {
                            max = ways[k] + ways[l];
                            if (max == 4)
                                return true;
                        }

                System.out.println("max: " + max);
                if (max <= 4) {
                    return true;
                } else if (max == 6) {
                    //проверка на вилку 3х3
                } else return false;
            }
        }
//            return true;
        return false;
    }


    public void setActive(int active) {
        this.active = active;
    }

    public int[][] getRows() {
        int[][] rows = new int[15][15];
        for (int i = 0; i < 15; i++) {
            rows[i] = board[i];
        }
        return rows;
    }

    public int[][] getColumns() {
        int[][] columns = new int[15][15];
        for (int i = 0; i < 15; i++) {
            int[] currentColumn = new int[15];
            for (int j = 0; j < 15; j++) {
                currentColumn[j] = board[j][i];
            }
            columns[i] = currentColumn;
        }
        return columns;
    }

    public int[][] getDiagonalsLeftToRight() {
        int[][] diagonals = new int[15][15];
        for (int i = 0; i < 15; i++) {
            int[] currentDiagonal = new int[15 - i];
            for (int j = i; j < 15 - i; j++) {
                currentDiagonal[i] = board[j][i + j];
            }
            diagonals[i] = currentDiagonal;
        }
        return diagonals;
    }

    public int[][] getDiagonalsRightToLeft() {
        int[][] diagonals = new int[15][15];
        for (int i = 0; i < 15; i++) {
            int[] currentDiagonal = new int[15 - i];
            for (int j = i; j < 15 - i; j++) {
                currentDiagonal[i] = board[i + j][j];
            }
            diagonals[i] = currentDiagonal;
        }
        return diagonals;
    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }
}
