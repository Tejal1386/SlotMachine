package com.example.tejalpatel.slotmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {

    ImageView img_Reel1,img_Reel2,img_Reel3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }
}
