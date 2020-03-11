package io.github.example.plumpybird;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnBest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBest = (Button) findViewById(R.id.btnBest);

        AppConstants.initialization(this.getApplicationContext());

        btnBest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToScoreActivity();
            }
        });

    }

    public void startGame(View view){
        Log.i("ImageButton","clicked");
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
        finish();
    }
    public void exit(View view){
        finish();
    }

    public  void moveToScoreActivity(){
        Intent intent = new Intent(MainActivity.this,ScoreActivity.class);
        startActivity(intent);
    }

}
