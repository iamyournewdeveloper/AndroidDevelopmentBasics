package com.rss.animations2;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean bToggle = false;
    public void animate(View view)
    {
        System.out.println("---------------------------------------entered");

        TextView tvHelloWorld = (TextView)findViewById(R.id.tvHelloWorld);

        TextView tv2 = (TextView)findViewById(R.id.tv2);



        //tvHelloWorld.setTranslationX(10f);
        //tvHelloWorld.setTranslationY(10f);


        tv2.setRotation(0f);


        if(!bToggle) {
            bToggle = true;
            System.out.println("----------------if");
            tvHelloWorld.animate()
                    .translationX(200f)
                    .setDuration(200);

        }
        else
        {
            bToggle = false;
            System.out.println("-else");
            tvHelloWorld.animate()
                    .translationX(0f)
                    .setDuration(2000);
        }

        tv2.animate()
                .rotation(-720f)
                .setDuration(2000);

        System.out.println(view.getWidth() + "," + view.getHeight());
        System.out.println("---------------------------------------exiting");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Animation animation = new RotateAnimation(0, 360f, 200f, 350f);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(2000);

        TextView tv1 = (TextView)findViewById(R.id.tv1);
        tv1.startAnimation(animation);

        //ValueAnimator animation = ValueAnimator.of

        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        relativeLayout.startAnimation(animation);

    }
}
