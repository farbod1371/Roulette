package com.example.elessar1992.roulette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class GameActivity extends AppCompatActivity
{
    Button button;
    TextView textView;
    ImageView wheelImage;

    Random r;
    int degree = 0;
    int degreeOld = 0;
    private static final float Factor = 4.86f;// we have 37 sloths on the wheel (9.72 degree each)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button = (Button)findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        wheelImage = (ImageView) findViewById(R.id.wheelId);

        r = new Random();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                degreeOld = degree % 100;
                degree = r.nextInt(3600) + 720;
                RotateAnimation rotateAnimation = new RotateAnimation(degreeOld,degree,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotateAnimation.setDuration(3600);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        textView.setText("");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        int resultShow = (360 - (degree % 360));
                        textView.setText(currentNumber(resultShow));

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                wheelImage.startAnimation(rotateAnimation);
            }
        });
    }
    private String currentNumber(int degrees)
    {
        String text = "";

        if(degrees >= (Factor * 1) && degrees < (Factor * 3))
        {
            text = "32 red";
        }
        if(degrees >= (Factor * 3) && degrees < (Factor * 5))
        {
            text = "15 black";
        }
        if(degrees >= (Factor * 5) && degrees < (Factor * 7))
        {
            text = "19 red";
        }
        if(degrees >= (Factor * 7) && degrees < (Factor * 9))
        {
            text = "4 black";
        }
        if(degrees >= (Factor * 9) && degrees < (Factor * 11))
        {
            text = "21 red";
        }
        if(degrees >= (Factor * 11) && degrees < (Factor * 13))
        {
            text = "2 black";
        }
        if(degrees >= (Factor * 13) && degrees < (Factor * 15))
        {
            text = "25 red";
        }
        if(degrees >= (Factor * 15) && degrees < (Factor * 17))
        {
            text = "17 black";
        }
        if(degrees >= (Factor * 17) && degrees < (Factor * 19))
        {
            text = "34 red";
        }
        if(degrees >= (Factor * 19) && degrees < (Factor * 21))
        {
            text = "6 black";
        }
        if(degrees >= (Factor * 21) && degrees < (Factor * 23))
        {
            text = "27 red";
        }
        if(degrees >= (Factor * 23) && degrees < (Factor * 25))
        {
            text = "13 black";
        }
        if(degrees >= (Factor * 25) && degrees < (Factor * 27))
        {
            text = "36 red";
        }
        if(degrees >= (Factor * 27) && degrees < (Factor * 29))
        {
            text = "11 black";
        }
        if(degrees >= (Factor * 29) && degrees < (Factor * 31))
        {
            text = "30 red";
        }
        if(degrees >= (Factor * 31) && degrees < (Factor * 33))
        {
            text = "8 black";
        }
        if(degrees >= (Factor * 33) && degrees < (Factor * 35))
        {
            text = "23 red";
        }
        if(degrees >= (Factor * 35) && degrees < (Factor * 37))
        {
            text = "10 black";
        }
        if(degrees >= (Factor * 37) && degrees < (Factor * 39))
        {
            text = "5 red";
        }
        if(degrees >= (Factor * 39) && degrees < (Factor * 41))
        {
            text = "24 black";
        }
        if(degrees >= (Factor * 41) && degrees < (Factor * 43))
        {
            text = "16 red";
        }
        if(degrees >= (Factor * 43) && degrees < (Factor * 45))
        {
            text = "33 black";
        }
        if(degrees >= (Factor * 45) && degrees < (Factor * 47))
        {
            text = "1 red";
        }
        if(degrees >= (Factor * 47) && degrees < (Factor * 49))
        {
            text = "20 black";
        }
        if(degrees >= (Factor * 49) && degrees < (Factor * 51))
        {
            text = "14 red";
        }
        if(degrees >= (Factor * 51) && degrees < (Factor * 53))
        {
            text = "31 black";
        }
        if(degrees >= (Factor * 53) && degrees < (Factor * 55))
        {
            text = "9 red";
        }
        if(degrees >= (Factor * 55) && degrees < (Factor * 57))
        {
            text = "22 black";
        }
        if(degrees >= (Factor * 57) && degrees < (Factor * 59))
        {
            text = "18 red";
        }
        if(degrees >= (Factor * 59) && degrees < (Factor * 61))
        {
            text = "29 black";
        }
        if(degrees >= (Factor * 61) && degrees < (Factor * 63))
        {
            text = "7 red";
        }
        if(degrees >= (Factor * 63) && degrees < (Factor * 65))
        {
            text = "28 black";
        }
        if(degrees >= (Factor * 65) && degrees < (Factor * 67))
        {
            text = "12 red";
        }
        if(degrees >= (Factor * 67) && degrees < (Factor * 69))
        {
            text = "35 black";
        }
        if(degrees >= (Factor * 69) && degrees < (Factor * 71))
        {
            text = "3 red";
        }
        if(degrees >= (Factor * 71) && degrees < (Factor * 73))
        {
            text = "26 black";
        }
        if(degrees >= (Factor * 73) && degrees < 360 || (degrees >= 0 && degrees < (Factor * 1)))
        {
            text = "0";
        }

        return text;
    }
}
