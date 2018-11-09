package com.example.satiga.tictactoe;


public class Game {
    final private int BOARD_SIZE = 3;
    private TileState[][] board;
    private Boolean playerOneTurn;
    private int movesPlayed;
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
        TileState tileState = TileState[row][column];
        if (tileState == TileState.BLANK) {
            if (playerOneTurn) {
                playerOneTurn = false;
                return TileState.CROSS;
            }
            else {
                playerOneTurn = true;
                return TileState.CIRCLE;
            }
        }
        else {
            return TileState.INVALID;
        }
    }

    public GameState won(int row, int column) {
        TileState tilestate = TileState[row][column];
        switch (row) {
            case 0:

            case 1:
            case 2:
        }
        int blankCounter = 0;
        for (int rowNo: BOARD_SIZE) {
            for (int colNo: BOARD_SIZE) {
                if (TileState[rowNo][colNo] == TileState.BLANK) {
                    blankCounter++;
                }
            }
        }
        if (blankCounter == 0) {
            return GameState.DRAW;
        }
    }
}
