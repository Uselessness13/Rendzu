package Rendzu;

import Rendzu.Models.AI;
import Rendzu.Models.Board;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class Controller {

    public static Pane[][] panes = new Pane[15][15];


    public void setPanes() {
        panes[0][0] = p0000;
        panes[0][1] = p0001;
        panes[0][2] = p0002;
        panes[0][3] = p0003;
        panes[0][4] = p0004;
        panes[0][5] = p0005;
        panes[0][6] = p0006;
        panes[0][7] = p0007;
        panes[0][8] = p0008;
        panes[0][9] = p0009;
        panes[0][10] = p0010;
        panes[0][11] = p0011;
        panes[0][12] = p0012;
        panes[0][13] = p0013;
        panes[0][14] = p0014;

        panes[1][0] = p0100;
        panes[1][1] = p0101;
        panes[1][2] = p0102;
        panes[1][3] = p0103;
        panes[1][4] = p0104;
        panes[1][5] = p0105;
        panes[1][6] = p0106;
        panes[1][7] = p0107;
        panes[1][8] = p0108;
        panes[1][9] = p0109;
        panes[1][10] = p0110;
        panes[1][11] = p0111;
        panes[1][12] = p0112;
        panes[1][13] = p0113;
        panes[1][14] = p0114;

        panes[2][0] = p0200;
        panes[2][1] = p0201;
        panes[2][2] = p0202;
        panes[2][3] = p0203;
        panes[2][4] = p0204;
        panes[2][5] = p0205;
        panes[2][6] = p0206;
        panes[2][7] = p0207;
        panes[2][8] = p0208;
        panes[2][9] = p0209;
        panes[2][10] = p0210;
        panes[2][11] = p0211;
        panes[2][12] = p0212;
        panes[2][13] = p0213;
        panes[2][14] = p0214;

        panes[3][0] = p0300;
        panes[3][1] = p0301;
        panes[3][2] = p0302;
        panes[3][3] = p0303;
        panes[3][4] = p0304;
        panes[3][5] = p0305;
        panes[3][6] = p0306;
        panes[3][7] = p0307;
        panes[3][8] = p0308;
        panes[3][9] = p0309;
        panes[3][10] = p0310;
        panes[3][11] = p0311;
        panes[3][12] = p0312;
        panes[3][13] = p0313;
        panes[3][14] = p0314;

        panes[4][0] = p0400;
        panes[4][1] = p0401;
        panes[4][2] = p0402;
        panes[4][3] = p0403;
        panes[4][4] = p0404;
        panes[4][5] = p0405;
        panes[4][6] = p0406;
        panes[4][7] = p0407;
        panes[4][8] = p0408;
        panes[4][9] = p0409;
        panes[4][10] = p0410;
        panes[4][11] = p0411;
        panes[4][12] = p0412;
        panes[4][13] = p0413;
        panes[4][14] = p0414;

        panes[5][0] = p0500;
        panes[5][1] = p0501;
        panes[5][2] = p0502;
        panes[5][3] = p0503;
        panes[5][4] = p0504;
        panes[5][5] = p0505;
        panes[5][6] = p0506;
        panes[5][7] = p0507;
        panes[5][8] = p0508;
        panes[5][9] = p0509;
        panes[5][10] = p0510;
        panes[5][11] = p0511;
        panes[5][12] = p0512;
        panes[5][13] = p0513;
        panes[5][14] = p0514;

        panes[6][0] = p0600;
        panes[6][1] = p0601;
        panes[6][2] = p0602;
        panes[6][3] = p0603;
        panes[6][4] = p0604;
        panes[6][5] = p0605;
        panes[6][6] = p0606;
        panes[6][7] = p0607;
        panes[6][8] = p0608;
        panes[6][9] = p0609;
        panes[6][10] = p0610;
        panes[6][11] = p0611;
        panes[6][12] = p0612;
        panes[6][13] = p0613;
        panes[6][14] = p0614;

        panes[7][0] = p0700;
        panes[7][1] = p0701;
        panes[7][2] = p0702;
        panes[7][3] = p0703;
        panes[7][4] = p0704;
        panes[7][5] = p0705;
        panes[7][6] = p0706;
        panes[7][7] = p0707;
        panes[7][8] = p0708;
        panes[7][9] = p0709;
        panes[7][10] = p0710;
        panes[7][11] = p0711;
        panes[7][12] = p0712;
        panes[7][13] = p0713;
        panes[7][14] = p0714;

        panes[8][0] = p0800;
        panes[8][1] = p0801;
        panes[8][2] = p0802;
        panes[8][3] = p0803;
        panes[8][4] = p0804;
        panes[8][5] = p0805;
        panes[8][6] = p0806;
        panes[8][7] = p0807;
        panes[8][8] = p0808;
        panes[8][9] = p0809;
        panes[8][10] = p0810;
        panes[8][11] = p0811;
        panes[8][12] = p0812;
        panes[8][13] = p0813;
        panes[8][14] = p0814;

        panes[9][0] = p0900;
        panes[9][1] = p0901;
        panes[9][2] = p0902;
        panes[9][3] = p0903;
        panes[9][4] = p0904;
        panes[9][5] = p0905;
        panes[9][6] = p0906;
        panes[9][7] = p0907;
        panes[9][8] = p0908;
        panes[9][9] = p0909;
        panes[9][10] = p0910;
        panes[9][11] = p0911;
        panes[9][12] = p0912;
        panes[9][13] = p0913;
        panes[9][14] = p0914;

        panes[10][0] = p1000;
        panes[10][1] = p1001;
        panes[10][2] = p1002;
        panes[10][3] = p1003;
        panes[10][4] = p1004;
        panes[10][5] = p1005;
        panes[10][6] = p1006;
        panes[10][7] = p1007;
        panes[10][8] = p1008;
        panes[10][9] = p1009;
        panes[10][10] = p1010;
        panes[10][11] = p1011;
        panes[10][12] = p1012;
        panes[10][13] = p1013;
        panes[10][14] = p1014;

        panes[11][0] = p1100;
        panes[11][1] = p1101;
        panes[11][2] = p1102;
        panes[11][3] = p1103;
        panes[11][4] = p1104;
        panes[11][5] = p1105;
        panes[11][6] = p1106;
        panes[11][7] = p1107;
        panes[11][8] = p1108;
        panes[11][9] = p1109;
        panes[11][10] = p1110;
        panes[11][11] = p1111;
        panes[11][12] = p1112;
        panes[11][13] = p1113;
        panes[11][14] = p1114;

        panes[12][0] = p1200;
        panes[12][1] = p1201;
        panes[12][2] = p1202;
        panes[12][3] = p1203;
        panes[12][4] = p1204;
        panes[12][5] = p1205;
        panes[12][6] = p1206;
        panes[12][7] = p1207;
        panes[12][8] = p1208;
        panes[12][9] = p1209;
        panes[12][10] = p1210;
        panes[12][11] = p1211;
        panes[12][12] = p1212;
        panes[12][13] = p1213;
        panes[12][14] = p1214;

        panes[13][0] = p1300;
        panes[13][1] = p1301;
        panes[13][2] = p1302;
        panes[13][3] = p1303;
        panes[13][4] = p1304;
        panes[13][5] = p1305;
        panes[13][6] = p1306;
        panes[13][7] = p1307;
        panes[13][8] = p1308;
        panes[13][9] = p1309;
        panes[13][10] = p1310;
        panes[13][11] = p1311;
        panes[13][12] = p1312;
        panes[13][13] = p1313;
        panes[13][14] = p1314;

        panes[14][0] = p1400;
        panes[14][1] = p1401;
        panes[14][2] = p1402;
        panes[14][3] = p1403;
        panes[14][4] = p1404;
        panes[14][5] = p1405;
        panes[14][6] = p1406;
        panes[14][7] = p1407;
        panes[14][8] = p1408;
        panes[14][9] = p1409;
        panes[14][10] = p1410;
        panes[14][11] = p1411;
        panes[14][12] = p1412;
        panes[14][13] = p1413;
        panes[14][14] = p1414;
    }


    public Label labelForWhosTurnToGo;
    private Board board;
    private AI ai;
    private int numberOfPassedSteps;
    public CheckBox BOTCHECKBOX;
    public Pane p0000;
    public Pane p0001;
    public Pane p0002;
    public Pane p0003;
    public Pane p0004;
    public Pane p0005;
    public Pane p0006;
    public Pane p0007;
    public Pane p0008;
    public Pane p0009;
    public Pane p0010;
    public Pane p0011;
    public Pane p0012;
    public Pane p0013;
    public Pane p0014;

    public Pane p0100;
    public Pane p0101;
    public Pane p0102;
    public Pane p0103;
    public Pane p0104;
    public Pane p0105;
    public Pane p0106;
    public Pane p0107;
    public Pane p0108;
    public Pane p0109;
    public Pane p0110;
    public Pane p0111;
    public Pane p0112;
    public Pane p0113;
    public Pane p0114;

    public Pane p0200;
    public Pane p0201;
    public Pane p0202;
    public Pane p0203;
    public Pane p0204;
    public Pane p0205;
    public Pane p0206;
    public Pane p0207;
    public Pane p0208;
    public Pane p0209;
    public Pane p0210;
    public Pane p0211;
    public Pane p0212;
    public Pane p0213;
    public Pane p0214;

    public Pane p0300;
    public Pane p0301;
    public Pane p0302;
    public Pane p0303;
    public Pane p0304;
    public Pane p0305;
    public Pane p0306;
    public Pane p0307;
    public Pane p0308;
    public Pane p0309;
    public Pane p0310;
    public Pane p0311;
    public Pane p0312;
    public Pane p0313;
    public Pane p0314;

    public Pane p0400;
    public Pane p0401;
    public Pane p0402;
    public Pane p0403;
    public Pane p0404;
    public Pane p0405;
    public Pane p0406;
    public Pane p0407;
    public Pane p0408;
    public Pane p0409;
    public Pane p0410;
    public Pane p0411;
    public Pane p0412;
    public Pane p0413;
    public Pane p0414;

    public Pane p0500;
    public Pane p0501;
    public Pane p0502;
    public Pane p0503;
    public Pane p0504;
    public Pane p0505;
    public Pane p0506;
    public Pane p0507;
    public Pane p0508;
    public Pane p0509;
    public Pane p0510;
    public Pane p0511;
    public Pane p0512;
    public Pane p0513;
    public Pane p0514;

    public Pane p0600;
    public Pane p0601;
    public Pane p0602;
    public Pane p0603;
    public Pane p0604;
    public Pane p0605;
    public Pane p0606;
    public Pane p0607;
    public Pane p0608;
    public Pane p0609;
    public Pane p0610;
    public Pane p0611;
    public Pane p0612;
    public Pane p0613;
    public Pane p0614;

    public Pane p0700;
    public Pane p0701;
    public Pane p0702;
    public Pane p0703;
    public Pane p0704;
    public Pane p0705;
    public Pane p0706;
    public Pane p0707;
    public Pane p0708;
    public Pane p0709;
    public Pane p0710;
    public Pane p0711;
    public Pane p0712;
    public Pane p0713;
    public Pane p0714;

    public Pane p0800;
    public Pane p0801;
    public Pane p0802;
    public Pane p0803;
    public Pane p0804;
    public Pane p0805;
    public Pane p0806;
    public Pane p0807;
    public Pane p0808;
    public Pane p0809;
    public Pane p0810;
    public Pane p0811;
    public Pane p0812;
    public Pane p0813;
    public Pane p0814;

    public Pane p0900;
    public Pane p0901;
    public Pane p0902;
    public Pane p0903;
    public Pane p0904;
    public Pane p0905;
    public Pane p0906;
    public Pane p0907;
    public Pane p0908;
    public Pane p0909;
    public Pane p0910;
    public Pane p0911;
    public Pane p0912;
    public Pane p0913;
    public Pane p0914;

    public Pane p1000;
    public Pane p1001;
    public Pane p1002;
    public Pane p1003;
    public Pane p1004;
    public Pane p1005;
    public Pane p1006;
    public Pane p1007;
    public Pane p1008;
    public Pane p1009;
    public Pane p1010;
    public Pane p1011;
    public Pane p1012;
    public Pane p1013;
    public Pane p1014;

    public Pane p1100;
    public Pane p1101;
    public Pane p1102;
    public Pane p1103;
    public Pane p1104;
    public Pane p1105;
    public Pane p1106;
    public Pane p1107;
    public Pane p1108;
    public Pane p1109;
    public Pane p1110;
    public Pane p1111;
    public Pane p1112;
    public Pane p1113;
    public Pane p1114;

    public Pane p1200;
    public Pane p1201;
    public Pane p1202;
    public Pane p1203;
    public Pane p1204;
    public Pane p1205;
    public Pane p1206;
    public Pane p1207;
    public Pane p1208;
    public Pane p1209;
    public Pane p1210;
    public Pane p1211;
    public Pane p1212;
    public Pane p1213;
    public Pane p1214;

    public Pane p1300;
    public Pane p1301;
    public Pane p1302;
    public Pane p1303;
    public Pane p1304;
    public Pane p1305;
    public Pane p1306;
    public Pane p1307;
    public Pane p1308;
    public Pane p1309;
    public Pane p1310;
    public Pane p1311;
    public Pane p1312;
    public Pane p1313;
    public Pane p1314;

    public Pane p1400;
    public Pane p1401;
    public Pane p1402;
    public Pane p1403;
    public Pane p1404;
    public Pane p1405;
    public Pane p1406;
    public Pane p1407;
    public Pane p1408;
    public Pane p1409;
    public Pane p1410;
    public Pane p1411;
    public Pane p1412;
    public Pane p1413;
    public Pane p1414;

    public void newGame() {
        setPanes();
        if (BOTCHECKBOX.isSelected()) {
            ai = new AI();
        }
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                panes[i][j].getChildren().clear();
        board = new Board();
        numberOfPassedSteps = 0;
        observer();
    }

    void recognize() {
        labelForWhosTurnToGo.setText(numberOfPassedSteps < 2 ? (board.getActive() == 1 ? "YOU" : "ALIEN") : "DRAW");
        if (board.checkForWin(1))
            labelForWhosTurnToGo.setText("U WIN");
        if (board.checkForWin(-1))
            labelForWhosTurnToGo.setText("U LOSE");
    }

    void observer() {
        painter();
        recognize();
    }

    public void clickOnPane(MouseEvent e) {
        Pane p = (Pane) e.getSource();

        int ii = 0, jj = 0;
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                if (panes[i][j].equals(p)) {
                    ii = i;
                    jj = j;
                }
        if (board.getGame()) {
            System.out.println(board.getActive());
            board.makeStep(ii, jj, board.getActive());
            observer();
            System.out.println(board.getActive());
            if (BOTCHECKBOX.isSelected()) {
                System.out.println("selected");
                if (board.getActive() == -1) {
                    System.out.println("-1 kfkhjg");
                    int[] st = ai.calculate(board);
                    while (st == null) {
                        st = ai.calculate(board);
                    }
                    board.makeStep(st[0], st[1], board.getActive());
                }
            }
        }
        observer();
    }

    void painter() {
        for (int i = 0; i < 15; i++)
            for (int j = 0; j < 15; j++)
                switch (board.getIJ(i, j)) {
                    case 1: {
                        panes[i][j].getChildren().add(new ImageView("Rendzu/Images/ourEye.png"));
                        break;
                    }
                    case -1: {
                        panes[i][j].getChildren().add(new ImageView("Rendzu/Images/enemyEye.png"));
                        break;
                    }
                }
    }

    public void passStep() {
        board.passStep();
        observer();
    }


}

