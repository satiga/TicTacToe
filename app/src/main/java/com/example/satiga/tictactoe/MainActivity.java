package com.example.satiga.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
//        if (savedInstanceState != null) {
//            game = savedInstanceState.getSerializable("currentGame");
//        }
    }

    public void titleClicked(View view) {
        int id = view.getId();
        int row = 0;
        int column = 0;
        //vraagt row en column waardes bijpassend bij button op
        switch(id) {
            case R.id.button1:  break;
            case R.id.button2:  column = 1;
                                break;
            case R.id.button3:  column = 2;
                                break;
            case R.id.button4:  row = 1;
                                break;
            case R.id.button5:  row = 1;
                                column = 1;
                                break;
            case R.id.button6:  row = 1;
                                column = 2;
                                break;
            case R.id.button7:  row = 2;
                                break;
            case R.id.button8:  row = 2;
                                column = 1;
                                break;
            case R.id.button9:  row = 2;
                                column = 2;
                                break;
        }
        //(nieuwe) status van tile wordt opgevraagd
        TileState state = game.choose(row, column);
        Button button = (Button) view;
        //nieuwe status wordt ook op button weergegeven
        switch(state) {
            case CROSS:   button.setText("X");
                          break;
            case CIRCLE:  button.setText("O");
                          break;
            case INVALID: break;

        }
        TextView text = findViewById(R.id.textView);
        GameState gState;
        //de staat van winnen wordt aangeroepen door de won method
        //de eindstand wordt dmv een switch met de spelers gecommuniceerd
        gState = game.won(row, column);
        switch(gState) {
            case PLAYER_ONE:  text.setText("Player One won!!");
                              break;
            case PLAYER_TWO:  text.setText("Player Two won!!");
                              break;
            case DRAW:        text.setText("DRAW! Try again!");
                              break;
            case IN_PROGRESS: break;
        }
    }


    // ook de ui wordt op een nieuw spel voorbereid
    public void resetClicked(View view) {
        game = new Game();
        ArrayList<Integer> allGameButtons = new ArrayList<>(
                Arrays.asList(  R.id.button1,R.id.button2,R.id.button3,
                                R.id.button4,R.id.button5,R.id.button6,
                                R.id.button7,R.id.button8,R.id.button9));
        //loopt over de lijst knopnamen
        for (int i=0; i<allGameButtons.size(); i++) {
            Button button = findViewById(allGameButtons.get(i));

            //de buttons worden schoongemaakt
            button.setText("");
        TextView text = findViewById(R.id.textView);
        // de eindstand text wordt weggehaald
        text.setText("");
        }
    }

    // om de huidige staat van het spel op te slaan bij bv omdraaien scherm
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Game saveGame = game;
        outState.putSerializable("currentGame",saveGame);
    }
}
