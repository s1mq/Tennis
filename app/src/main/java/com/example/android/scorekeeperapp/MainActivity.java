package com.example.android.scorekeeperapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variables to keep track of count
    int CountA = 0;
    int CountB = 0;
    int gamePointA = 0;
    int gamePointB = 0;
    int setPointA = 0;
    int setPointB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buttons and TextViews
        final TextView countAGameScore = (TextView) findViewById(R.id.playerOneGameScore);
        final Button countAButton = (Button) findViewById(R.id.plusPointsPO);
        final TextView countBGameScore = (TextView) findViewById(R.id.playerTwoGameScore);
        final Button countBButton = (Button) findViewById(R.id.plusPointsPT);
        final Button resetButton = (Button) findViewById(R.id.resetButton);
        final TextView countAGamePoint = (TextView) findViewById(R.id.playerOneGamePoints);
        final TextView countBGamePoint = (TextView) findViewById(R.id.playerTwoGamePoints);
        final TextView countASetPoint = (TextView) findViewById(R.id.playerOneSetPoints);
        final TextView countBSetPoint = (TextView) findViewById(R.id.playerTwoSetPoints);

        // What happens when +P1 button is clicked
        countAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Used Count here because the score in tennis is not incremental
                CountA++;
                if (CountA == 1) {
                    countAGameScore.setText("15");
                } else if (CountA == 2) {
                    countAGameScore.setText("30");
                } else if (CountA == 3) {
                    countAGameScore.setText("40");
                } else if (CountA == 4) {
                    //Different conditionals to define if the score should be "Ad" or "40"
                    if (CountB == 3 && countAGameScore.getText() == "40" && countBGameScore.getText() == "40") {
                        countAGameScore.setText("Ad");
                        CountA--;
                    } else if (CountB == 3 && countAGameScore.getText() == "Ad" && countBGameScore.getText() == "40") {
                        countAGameScore.setText("0");
                        countBGameScore.setText("0");
                        CountA = 0;
                        CountB = 0;
                        gamePointA++;
                        countAGamePoint.setText(String.valueOf(gamePointA));
                    } else if (CountB == 3 && countBGameScore.getText() == "Ad" && countAGameScore.getText() == "40") {
                        countAGameScore.setText("40");
                        countBGameScore.setText("40");
                        CountA--;
                    }
                    //Otherwise just reset score
                    else {
                        countAGameScore.setText("0");
                        countBGameScore.setText("0");
                        CountA = 0;
                        CountB = 0;
                        gamePointA++;
                        countAGamePoint.setText(String.valueOf(gamePointA));
                    }
                    if (gamePointA > 5 && (gamePointA - gamePointB) >= 2) {
                        setPointA++;
                        countASetPoint.setText(String.valueOf(setPointA));
                        gamePointA = 0;
                        countAGamePoint.setText("0");
                        gamePointB = 0;
                        countBGamePoint.setText("0");
                    }
                    //If Player One wins, prints winning toast and disables +Points buttons
                    if (setPointA == 2) {
                        Toast.makeText(MainActivity.this, "Player One Wins The Game", Toast.LENGTH_LONG).show();
                        countAButton.setClickable(false);
                        countBButton.setClickable(false);
                    }
                }
            }
        });

        //What happens when +P2 button is clicked
        countBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Used Count here because the score in tennis is not incremental
                CountB++;
                if (CountB == 1) {
                    countBGameScore.setText("15");
                } else if (CountB == 2) {
                    countBGameScore.setText("30");
                } else if (CountB == 3) {
                    countBGameScore.setText("40");
                } else if (CountB == 4) {
                    //Different conditionals to define if the score should be "Ad" or "40"
                    if (CountA == 3 && countBGameScore.getText() == "40" && countAGameScore.getText() == "40") {
                        countBGameScore.setText("Ad");
                        CountB--;
                    } else if (CountA == 3 && countBGameScore.getText() == "Ad" && countAGameScore.getText() == "40") {
                        countAGameScore.setText("0");
                        countBGameScore.setText("0");
                        CountA = 0;
                        CountB = 0;
                        gamePointB++;
                        countBGamePoint.setText(String.valueOf(gamePointB));
                    } else if (CountA == 3 && countAGameScore.getText() == "Ad" && countBGameScore.getText() == "40") {
                        countAGameScore.setText("40");
                        countBGameScore.setText("40");
                        CountB--;
                    }
                    //Otherwise just reset score
                    else {
                        countAGameScore.setText("0");
                        countBGameScore.setText("0");
                        CountA = 0;
                        CountB = 0;
                        gamePointB++;
                        countBGamePoint.setText(String.valueOf(gamePointB));
                    }
                    if (gamePointB > 5 && (gamePointB - gamePointA) >= 2) {
                        setPointB++;
                        countBSetPoint.setText(String.valueOf(setPointB));
                        gamePointA = 0;
                        countAGamePoint.setText("0");
                        gamePointB = 0;
                        countBGamePoint.setText("0");
                    }
                    //If Player Owo wins, prints winning toast and disables +Points buttons
                    if (setPointB == 2) {
                        Toast.makeText(MainActivity.this, "Player Two Wins The Game", Toast.LENGTH_LONG).show();
                        countAButton.setClickable(false);
                        countBButton.setClickable(false);
                    }
                }
            }
        });

        //Reset button to reset all values and restore button functionality
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countAGameScore.setText("0");
                countBGameScore.setText("0");
                countAGamePoint.setText("0");
                countBGamePoint.setText("0");
                countASetPoint.setText("0");
                countBSetPoint.setText("0");
                CountA = 0;
                CountB = 0;
                gamePointA = 0;
                gamePointB = 0;
                setPointA = 0;
                setPointB = 0;
                countAButton.setClickable(true);
                countBButton.setClickable(true);
            }
        });
    }
}