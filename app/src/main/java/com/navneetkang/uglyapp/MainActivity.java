package com.navneetkang.uglyapp;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int countA=0;
    int countB=0;
    int scoreA=0;
    int scoreB=0;
    int score=0;
    TextView teamAScore;
    TextView teamBScore;
    RadioButton  wide,four,six;
    TextView result;
    TextView setRules;
    RadioGroup rg;

    MediaPlayer mp;
    TableLayout l1;
    TextView themepercent;
    SeekBar seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l1= findViewById(R.id.scrollViewBackground);

        seek=findViewById(R.id.seekBar);
        themepercent=findViewById(R.id.themePercent);




        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                themepercent.setVisibility(View.VISIBLE);
                themepercent.setText(i+"");
                Toast.makeText(getApplicationContext(),i+"",Toast.LENGTH_SHORT).show();

                if(i>=0 && i<20)
                {
                    if(i==1 || i==10) {
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.a);
                        mp.start();
                        //l1.setBackgroundColor(Color.parseColor("#f00"));

                    }



                }
                else if(i>=20 && i<40)
                {
                    if(i==20 || i==30) {
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.b);
                        mp.start();
                    }
                    if(themepercent.equals("20"))
                    {
                        l1.setBackgroundColor(Color.parseColor("#f00"));
                    }

                }
                else if(i>=40 && i<60)
                {
                    if(i==40 || i==50) {
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.c);
                        mp.start();
                    }
                }
                else if(i>=60 && i<80)
                {
                    if(i==60 || i==70) {
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.d);
                        mp.start();
                    }

                }
                else {
                    if (i == 80 || i==90) {
                        mp = MediaPlayer.create(getApplicationContext(), R.raw.e);
                        mp.start();

                    }
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        final Button activeTeamB=findViewById(R.id.active_teamB);



        Button increaseScoreA=findViewById(R.id.team_a_increase);
        Button increaseScoreB=findViewById(R.id.team_b_increase);
        Button decreaseScoreA=findViewById(R.id.team_a_decrease);
        Button decreaseScoreB=findViewById(R.id.team_b_decrease);
        rg=findViewById(R.id.scoreChange);

        wide=findViewById(R.id.score_1);
        four=findViewById(R.id.score_4);
        six=findViewById(R.id.score_6);

        teamAScore=findViewById(R.id.teamAScore);
        teamBScore=findViewById(R.id.teamBScore);







        increaseScoreA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick();
                selectRadio();
                scoreA+=score;
                update();

            }
        });
        increaseScoreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick();
                selectRadio();
                scoreB+=score;
                update();
            }
        });

        decreaseScoreA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick();
                selectRadio();
                scoreA-=score;
                update();


            }
        });

        decreaseScoreB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick();
                selectRadio();
                scoreB-=score;

                update();

            }
        });

    }
    public void buttonClick()
    {
        mp=MediaPlayer.create(getApplicationContext(),R.raw.button_press);
        mp.start();
    }

    public void update()
    {

        teamAScore.setText(scoreA+"");
        teamBScore.setText(scoreB+"");

    }

    public void selectRadio()
    {
        switch(rg.getCheckedRadioButtonId())
        {
            case R.id.score_1:
                score=1;
                break;


            case R.id.score_4:
                score=4;
                break;


            case R.id.score_6:
                score=6;
                break;

        }
    }
}
