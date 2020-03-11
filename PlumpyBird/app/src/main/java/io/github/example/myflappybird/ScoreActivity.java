package io.github.example.plumpybird;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    public TextView best,tvPersonalBest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_activity);

        best = (TextView) findViewById(R.id.textView3);

        SharedPreferences pref = getSharedPreferences("MyPref",0);
        int scoreSP = pref.getInt("scoreSP", 0);
        SharedPreferences.Editor editor = pref.edit();

        tvPersonalBest = findViewById(R.id.textView3);
        tvPersonalBest.setText(""+scoreSP);

    }


}

