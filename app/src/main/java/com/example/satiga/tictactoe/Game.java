package com.example.satiga.tictactoe;


import java.io.Serializable;

public class Game implements Serializable {
    final private int BOARD_SIZE = 3;
    private TileState[][] board;
    private Boolean playerOneTurn;
    private int movesPlayed = 0;
    private Boolean gameOver;

    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    public TileState choose(int row, int column) {
        if (gameOver) {
            return TileState.INVALID;
        }
        else {
            TileState tileState = board[row][column];
            if (tileState == TileState.BLANK) {
                if (playerOneTurn) {
                    playerOneTurn = false;
                    movesPlayed++;
                    board[row][column] = TileState.CROSS;
                    return TileState.CROSS;
                } else {
                    playerOneTurn = true;
                    movesPlayed++;
                    board[row][column] = TileState.CIRCLE;
                    return TileState.CIRCLE;
                }
            } else {
                return TileState.INVALID;
            }
        }
    }


    public GameState won(int row, int column) {
        TileState cur_tile = board[row][column];
        GameState winner = GameState.PLAYER_ONE;
        switch (cur_tile) {
            case CROSS:  winner = GameState.PLAYER_ONE;
                         break;
            case CIRCLE: winner = GameState.PLAYER_TWO;
                         break;
            default: break;
        }
        // check rows
        int row_oc = 0; int col_oc = 0;
        int dia_oc1 = 0; int dia_oc2 = 0;

        for (int i = 0;i<3;i++) {
            if (board[row][i]==cur_tile) row_oc++;
            if (board[i][i]==cur_tile) dia_oc1++;
            if (board[i][column]==cur_tile) col_oc++;
            if (board[i][2-i]==cur_tile) dia_oc2++;
        }

        if (row_oc==3||col_oc==3||dia_oc1==3||dia_oc2==3) {
            gameOver = true;
            return winner;
        }

        if (movesPlayed == 9) {
            gameOver = true;
            return GameState.DRAW;
        }
    return GameState.IN_PROGRESS;
    }

}
