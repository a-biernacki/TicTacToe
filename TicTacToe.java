/*
 * Arianna Biernacki
 * Student ID: xxxxxxxxx
 * PROG24178: Java 2
 * Due Date: January 22, 2020
 */
package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    int[][] board = new int[3][3];

    public void play() {
        //Beginning of game
        System.out.println();
        System.out.println("********* Welcome to TicTacToe! ********");
        System.out.println();
        displayBoard();
        gameRules();
        //Users take turns playing
        initializeBoard();
    }

    private void displayBoard() {
        int r = 0;
        int c = 0;
        System.out.println("          Column 0  Column 1  Column 2");
        for (int i = 0; i < 3; i++) {
            System.out.print("Row " + r++ + "   ");
            for (int j = 0; j < 3; j++) {
                System.out.print("|");
                System.out.print("    " + board[i][j] + "    ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println();
        System.out.println("----------------------------------------");
    }

    private void gameRules() {
        System.out.println("              GAME RULES:              ");
        System.out.println("                 X = 1                 ");
        System.out.println("                 O = -1                 ");
        System.out.println("----------------------------------------");
    }

    private void initializeBoard() {
        int currentPlayer = 1;
        while (true) {
            try {
                Scanner input = new Scanner(System.in);
                System.out.println("Player " + currentPlayer + ": Enter a row number");
                int r = input.nextInt();
                while (r < 0 || r > 2) {
                    System.out.println("ERROR: Please enter a number that is between 0-2");
                    r = input.nextInt();
                }
                System.out.println("Player " + currentPlayer + ": Enter a column number");
                int c = input.nextInt();
                while (c < 0 || c > 2) {
                    System.out.println("ERROR: Please enter a number that is between 0-2");
                    c = input.nextInt();
                }
                System.out.println("Player " + currentPlayer + ": Make your move");
                board[r][c] = input.nextInt();
                while (board[r][c] != currentPlayer) {
                    System.out.println("ERROR: Please enter " + currentPlayer);
                    board[r][c] = input.nextInt();
                }
            } catch (Exception e) {
                System.out.println("");
                System.out.println("*********************************************");
                System.out.println("***ERROR! You entered something other than***");
                System.out.println("***a number, and therefore lost your turn.***");
                System.out.println("*********************************************");
                System.out.println("");
            }
            System.out.println("----------------------------------------");
            displayBoard();
            checkRowForWinner();
            checkColumnForWinner();
            checkDiagonalLeftToRightForWinner();
            checkDiagonalRightToLeftForWinner();
            checkForDraw();
            currentPlayer = -currentPlayer;
        }
    }

    private void checkRowForWinner() {

        //Check sum1 (top row)
        int sum1 = 0;
        for (int value : board[sum1]) {
            sum1 += value;
        }
        if (sum1 == 3) {
            System.out.println("X has won!");
            System.exit(0);
        }
        if (sum1 == -3) {
            System.out.println("O has won!");
            System.exit(0);
        }

        //Check sum2 (middle row)
        int sum2 = 0;
        for (int value2 : board[1]) {
            sum2 += value2;
        }
        if (sum2 == 3) {
            System.out.println("X has won!");
            System.exit(0);
        }
        if (sum2 == -3) {
            System.out.println("O has won!");
            System.exit(0);
        }

        //Check sum3 (bottom row)
        int sum3 = 0;
        for (int value3 : board[2]) {
            sum3 += value3;
        }
        if (sum3 == 3) {
            System.out.println("X has won!");
            System.exit(0);
        }
        if (sum3 == -3) {
            System.out.println("O has won!");
            System.exit(0);
        }
    }

    private void checkColumnForWinner() {
        int sum4 = 0;
        for (int b = 0; b < 3; b++) {
            sum4 += board[b][0];
        }
        if (sum4 == 3) {
            System.out.println("X has won!");
            System.exit(0);
        }
        if (sum4 == -3) {
            System.out.println("O has won!");
            System.exit(0);
        }

        //Check sum5 (column 2)
        int sum5 = 0;
        for (int c = 0; c < 3; c++) {
            sum5 += board[c][1];
        }
        if (sum5 == 3) {
            System.out.println("X has won!");
            System.exit(0);
        }
        if (sum5 == -3) {
            System.out.println("O has won!");
            System.exit(0);
        }

        //Check sum6 (column 3)
        int sum6 = 0;
        for (int d = 0; d < 3; d++) {
            sum6 += board[d][2];
        }
        if (sum6 == 3) {
            System.out.println("X has won!");
            System.exit(0);
        }
        if (sum6 == -3) {
            System.out.println("O has won!");
            System.exit(0);
        }
    }

    private void checkDiagonalLeftToRightForWinner() {
        int sumLR = 0;
        for (int e = 0; e < 3; e++) {
            sumLR += board[e][e];
        }
        if (sumLR == 3) {
            System.out.println("X has won!");
            System.exit(0);
        }
        if (sumLR == -3) {
            System.out.println("O has won!");
            System.exit(0);
        }
    }

    private void checkDiagonalRightToLeftForWinner() {
        int sumRL = 0;
        int g = 2;
        for (int f = 0; f < 3; f++) {
            sumRL += board[f][g - f];
        }
        if (sumRL == 3) {
            System.out.println("X has won!");
            System.exit(0);
        }
        if (sumRL == -3) {
            System.out.println("O has won!");
            System.exit(0);
        }
    }

    private void checkForDraw() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    return; // and do nothing
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0) {
                    System.out.println("");
                    System.out.println("****************************************");
                    System.out.println("************ Cat's Game! ************");
                    System.out.println("****************************************");
                    System.exit(0);
                }
            }
        }

    }
}
