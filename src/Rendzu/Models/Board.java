package Rendzu.Models;

import java.util.Arrays;

/**
 * Created by Useless on 15.05.2017.
 */
public class Board {
    private int[][] board;
    private int active;
    private int numberOfSteps;
    private boolean gamestarted;
    private boolean firstPassed;
    private boolean secondPassed;


    public Board() {
        this.board = new int[15][15];
        this.active = 1;
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                this.board[i][j] = i == 7 && j == 7 ? -1 : 0;
        numberOfSteps = 1;
        gamestarted = true;
        firstPassed = false;
        secondPassed = false;
    }

    public void print() {
        int[][] rows = getRows();
        System.out.println("Rows");
        for (int[] row : rows) {
            System.out.println(Arrays.toString(row));
        }
    }

    public Board(Board board) {
        this.board = new int[15][15];
        for (int i = 0; i < 15; i++)
            System.arraycopy(board.board[i], 0, this.board[i], 0, 15);
        this.numberOfSteps = board.numberOfSteps;
        this.gamestarted = board.gamestarted;
    }

    private void setIJ(int i, int j, int eye) {
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
                gamestarted = !checkForWin(active);
                this.active *= -1;
            }
            if (firstPassed && secondPassed) {
                gamestarted = false;
            } else {
                firstPassed = false;
                secondPassed = false;
            }
            System.out.println(numberOfSteps);
        }
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
                // пути, по которым просматриваем свои глаза
                int[] ways = get8Ways(i, j, eye);
                int ulAnswer = ways[0];
                int uAnswer = ways[1];
                int urAnswer = ways[2];
                int rAnswer = ways[3];
                int drAnswer = ways[4];
                int dAnswer = ways[5];
                int dlAnswer = ways[6];
                int lAnswer = ways[7];

                System.out.println(Arrays.toString(ways));
                // проверяем прямые
                if (dAnswer + uAnswer == 4 || lAnswer + rAnswer == 4 || dlAnswer + urAnswer == 4 || ulAnswer + drAnswer == 4)
                    return true;
                if ((dAnswer == 1 && uAnswer == 1 && rAnswer == 1 && lAnswer == 1) || (ulAnswer == 1 && urAnswer == 1 && drAnswer == 1 && dlAnswer == 1))
                    return false;
                // проверка на длинный ряд
                if (dAnswer + uAnswer == 5 || lAnswer + rAnswer == 5 || dlAnswer + urAnswer == 5 || ulAnswer + drAnswer == 5)
                    return false;
                // проверка на вилки
                int max = 0;
                for (int k = 0; k < 7; k++)
                    for (int l = k + 1; l < 8; l++)
                        if (ways[k] + ways[l] > max) {
                            max = ways[k] + ways[l];
                        }
                System.out.println("max: " + max);
                if (max < 4 || max % 2 > 0) {
                    return true;
                } else return false;
            }
        }
        return false;
    }

    public void setActive(int active) {
        this.active = active;
    }


    public int[] get8Ways(int i, int j, int eye) {
        System.out.println("giving 8 ways from " + i + ";" + j);
        int ux = i - 1, uAnswer = 0;
        while (ux >= 0) {
            if (board[ux][j] == eye) {
                uAnswer++;
            } else break;
            ux--;
        }

        int dx = i + 1, dAnswer = 0;
        while (dx < 15) {
            if (board[dx][j] == eye) {
                dAnswer++;
            } else break;
            dx++;
        }

        int rx = j + 1, rAnswer = 0;
        while (rx < 15) {
            if (board[i][rx] == eye) {
                rAnswer++;
            } else break;
            rx++;
        }

        int lx = j - 1, lAnswer = 0;
        while (lx >= 0) {
            if (board[i][lx] == eye) {
                lAnswer++;
            } else break;
            lx--;
        }

        int ulx = i - 1, uly = j - 1;
        int ulAnswer = 0;
        while (ulx >= 0 && uly >= 0) {
            if (board[ulx][uly] == eye) {
                ulAnswer++;
            } else break;
            ulx--;
            uly--;
        }
        int urx = i - 1, ury = j + 1;
        int urAnswer = 0;
        while (urx >= 0 && ury < 15) {
            if (board[urx][ury] == eye) {
                urAnswer++;
            } else break;
            urx--;
            ury++;
        }

        int dlx = i + 1, dly = j - 1;
        int dlAnswer = 0;
        while (dlx < 15 && dly >= 0) {
            if (board[dlx][dly] == eye) {
                dlAnswer++;
            } else break;
            dlx++;
            dly--;
        }
        int drx = i + 1, dry = j + 1;
        int drAnswer = 0;
        while (drx < 15 && dry < 15) {
            if (board[drx][dry] == eye) {
                drAnswer++;
            } else break;
            drx++;
            dry++;
        }
        return new int[]{ulAnswer, uAnswer, urAnswer, rAnswer, drAnswer, dAnswer, dlAnswer, lAnswer};
    }

    public boolean checkForWin(int eye) {
        boolean answer = false;
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                if (board[i][j] == eye) {
                    int[] ways = get8Ways(i, j, eye);
                    for (int k = 0; k < ways.length; k++) {
                        if (eye == -1) {
                            if (ways[k] == 4)
                                answer = true;
                        } else {
                            if (ways[k] >= 4)
                                answer = true;
                        }
                    }
                }

        return answer;
    }

    public int[][] getRows() {
        int[][] rows = new int[15][15];
        System.arraycopy(board, 0, rows, 0, 15);
        return rows;
    }

//    public int[][] getColumns() {
//        int[][] columns = new int[15][15];
//        for (int i = 0; i < 15; i++) {
//            int[] currentColumn = new int[15];
//            for (int j = 0; j < 15; j++) {
//                currentColumn[j] = board[j][i];
//            }
//            columns[i] = currentColumn;
//        }
//        return columns;
//    }
//
//    public int[][] getDiagonalsLeftToRight() {
//        int[][] diagonals = new int[15][15];
//        for (int i = 0; i < 15; i++) {
//            int[] currentDiagonal = new int[15 - i];
//            for (int j = i; j < 15 - i; j++) {
//                currentDiagonal[i] = board[j][i + j];
//            }
//            diagonals[i] = currentDiagonal;
//        }
//        return diagonals;
//    }
//
//    public int[][] getDiagonalsRightToLeft() {
//        int[][] diagonals = new int[15][15];
//        for (int i = 0; i < 15; i++) {
//            int[] currentDiagonal = new int[15 - i];
//            for (int j = i; j < 15 - i; j++) {
//                currentDiagonal[i] = board[i + j][j];
//            }
//            diagonals[i] = currentDiagonal;
//        }
//        return diagonals;
//    }

    public int getNumberOfSteps() {
        return numberOfSteps;
    }

    public void passStep() {
        if (active == 1) {
            firstPassed = true;
            setActive(getActive() * -1);
        } else {
            secondPassed = true;
            setActive(getActive() * -1);
        }
    }
}
