package com.example.satiga.tictactoe;


import java.io.Serializable;

public class Game implements Serializable {
    final private int BOARD_SIZE = 3;
    private TileState[][] board;
    private Boolean playerOneTurn;
    private int movesPlayed = 0;
    private Boolean gameOver;

    //initieert nieuw spel, het hele bord wordt weer blanco
    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    //returnt nieuwe TileState van opgegeven tile
    public TileState choose(int row, int column) {
        //niet reagerend als spel is afgelopen
        if (gameOver) {
            return TileState.INVALID;
        }
        else {
            //roept huidige TileState op
            TileState tileState = board[row][column];
            //als huidige staat is blanco, nieuwe waarde toegekent en volgende speler aan de beurt
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
            // als de huidige staat niet blanco is: ongeldige zet
            } else {
                return TileState.INVALID;
            }
        }
    }

    // checkt en returnt spelstand
    public GameState won(int row, int column) {
        //laatst geklikte tile status opvragen
        TileState cur_tile = board[row][column];
        GameState winner = GameState.PLAYER_ONE;
        //checkt wie aan zet is en dus zou winnen
        switch (cur_tile) {
            case CROSS:  winner = GameState.PLAYER_ONE;
                         break;
            case CIRCLE: winner = GameState.PLAYER_TWO;
                         break;
            default: break;
        }
        // telt aantal keer cur_tile aanwezig in row, col, en diagonaal
        int row_oc = 0; int col_oc = 0;
        int dia_oc1 = 0; int dia_oc2 = 0;

        for (int i = 0;i<3;i++) {
            if (board[row][i]==cur_tile) row_oc++;
            if (board[i][i]==cur_tile) dia_oc1++;
            if (board[i][column]==cur_tile) col_oc++;
            if (board[i][2-i]==cur_tile) dia_oc2++;
        }

        //als een property de waarde 3 heeft is er een 3 op een rij oftwel winnaar!
        if (row_oc==3||col_oc==3||dia_oc1==3||dia_oc2==3) {
            gameOver = true;
            return winner;
        }
        //als movesPlayed 9 is, is het bord vol: gelijkspel
        if (movesPlayed == 9) {
            gameOver = true;
            return GameState.DRAW;
        }
    //geldt dit allen niet: het spel is nog bezig
    return GameState.IN_PROGRESS;
    }

}
