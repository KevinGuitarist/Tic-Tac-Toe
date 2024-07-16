package com.kevinguitarist.tictactoe;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean GameActive = true;
    int activeplayer = 0;
    int [] gamestate = {2,2,2,2,2,2,2,2,2};

    int[][] WinningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void PlayerTap(View view){
        ImageView img = (ImageView) view;
        int tappedimage = Integer.parseInt(img.getTag().toString());
        if(!GameActive){
            GameReset(view);
        }
        if(gamestate[tappedimage] == 2 ){
            gamestate[tappedimage]=activeplayer;
            img.setTranslationY(-1000f);
            if(activeplayer == 0){
                img.setImageResource(R.drawable.ex);
                activeplayer = 1;
                TextView Status = findViewById(R.id.status);
                Status.setText("O's turn - Tap to play");
            }
            else{
                img.setImageResource(R.drawable.zero);
                activeplayer = 0;
                TextView Status = findViewById(R.id.status);
                Status.setText("X's turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] winPosition : WinningPositions){
            if(gamestate[winPosition[0]] == gamestate[winPosition[1]] &&
                    gamestate[winPosition[1]] == gamestate[winPosition[2]] &&
                    gamestate[winPosition[0]] != 2){
                    String winnerStr;
                    GameActive = false;
                if(gamestate[winPosition[0]] == 0){
                    winnerStr = "X has Won";
                }
                else{
                    winnerStr = "o has won";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }

    }
    public void GameReset(View view){
        GameActive = true;
        activeplayer = 0;
        for(int i =0; i<gamestate.length; i++){
            gamestate[i] = 2;
        }
        ((ImageView)findViewById(R.id.ImageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.ImageView8)).setImageResource(0);

        TextView Status = findViewById(R.id.status);
        Status.setText("X's turn - Tap to play");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}