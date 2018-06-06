package com.example.tejalpatel.slotmachine;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class GameActivity extends AppCompatActivity {

    ImageView img_Reel1,img_Reel2,img_Reel3, img_spin, img_quit, img_reset;
    Random r;
    int img1, img2, img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        r = new Random();

        img_spin = (ImageView) findViewById(R.id.img_Spin);
        img_reset = (ImageView) findViewById(R.id.img_Reset);
        img_quit = (ImageView) findViewById(R.id.img_Quit);

        img_Reel1 = (ImageView) findViewById(R.id.img_Reel1);
        img_Reel2 = (ImageView) findViewById(R.id.img_Reel2);
        img_Reel3 = (ImageView) findViewById(R.id.img_Reel3);

        img_quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        img_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //animate first image
                img_Reel1.setImageResource(R.drawable.anim);
                final AnimationDrawable reel1anim = (AnimationDrawable) img_Reel1.getDrawable();
                reel1anim.start();

                //animate first image
                img_Reel2.setImageResource(R.drawable.anim);
                final AnimationDrawable reel2anim = (AnimationDrawable) img_Reel2.getDrawable();
                reel2anim.start();

                //animate first image
                img_Reel3.setImageResource(R.drawable.anim);
                final AnimationDrawable reel3anim = (AnimationDrawable) img_Reel3.getDrawable();
                reel3anim.start();

                //stop the animation
                android.os.Handler handler = new android.os.Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        reel1anim.stop();
                        reel2anim.stop();
                        reel3anim.stop();

                        setImages();

                        getScore();
                    }
                }, 800);
            }
        });

    }

    public void setImages(){

        //Randomise images
        img1 = r.nextInt(8)+1;
        img2 = r.nextInt(8)+1;
        img3 = r.nextInt(8)+1;

        //Set Reel -1 image
        switch (img1){
            case 1:
                img_Reel1.setImageResource(R.drawable.apple);
                break;
            case 2:
                img_Reel1.setImageResource(R.drawable.banana);
                break;
            case 3:
                img_Reel1.setImageResource(R.drawable.bell);
                break;
            case 4:
                img_Reel1.setImageResource(R.drawable.cherry);
                break;
            case 5:
                img_Reel1.setImageResource(R.drawable.peach);
                break;
            case 6:
                img_Reel1.setImageResource(R.drawable.grapes);
                break;
            case 7:
                img_Reel1.setImageResource(R.drawable.seven);
                break;
            case 8:
                img_Reel1.setImageResource(R.drawable.strawberry);
                break;
        }

        //Set Reel -2 image
        switch (img2){
            case 1:
                img_Reel2.setImageResource(R.drawable.apple);
                break;
            case 2:
                img_Reel2.setImageResource(R.drawable.banana);
                break;
            case 3:
                img_Reel2.setImageResource(R.drawable.bell);
                break;
            case 4:
                img_Reel2.setImageResource(R.drawable.cherry);
                break;
            case 5:
                img_Reel2.setImageResource(R.drawable.peach);
                break;
            case 6:
                img_Reel2.setImageResource(R.drawable.grapes);
                break;
            case 7:
                img_Reel2.setImageResource(R.drawable.seven);
                break;
            case 8:
                img_Reel2.setImageResource(R.drawable.strawberry);
                break;
        }

        //Set Reel -3 image
        switch (img3){
            case 1:
                img_Reel3.setImageResource(R.drawable.apple);
                break;
            case 2:
                img_Reel3.setImageResource(R.drawable.banana);
                break;
            case 3:
                img_Reel3.setImageResource(R.drawable.bell);
                break;
            case 4:
                img_Reel3.setImageResource(R.drawable.cherry);
                break;
            case 5:
                img_Reel3.setImageResource(R.drawable.peach);
                break;
            case 6:
                img_Reel3.setImageResource(R.drawable.grapes);
                break;
            case 7:
                img_Reel3.setImageResource(R.drawable.seven);
                break;
            case 8:
                img_Reel3.setImageResource(R.drawable.strawberry);
                break;
        }
    }
    public void getScore(){

        if(img1 == img2 && img2 == img3){
            Toast.makeText(this, "Jackpot", Toast.LENGTH_LONG).show();
        }

        if(img1 == img2 || img2 == img3 || img1 == img3){
            Toast.makeText(this, "Awsome", Toast.LENGTH_LONG).show();
        }
    }
}
