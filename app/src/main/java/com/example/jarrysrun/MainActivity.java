package com.example.jarrysrun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView kalan ;//textViev
    TextView score ;
    ImageView []images;

    int skor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        kalan = findViewById(R.id.textView);
        score = findViewById(R.id.textView2);

        images = new ImageView[]{findViewById(R.id.imageView),
                findViewById(R.id.imageView2), findViewById(R.id.imageView3)};

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                hideImages();

                Random random = new Random();
                int uretilen = random.nextInt(3);
                images[uretilen].setVisibility(View.VISIBLE);

                kalan.setText("Kalan : " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {

                hideImages();

            }
        }.start();
    }

    public void hideImages() {

        for (ImageView gezici : images) {
            gezici.setVisibility(View.INVISIBLE);
        }
    }

    public void catchjerry(View view){

        skor++;
        score.setText("Skor :"+skor);


    }
}
