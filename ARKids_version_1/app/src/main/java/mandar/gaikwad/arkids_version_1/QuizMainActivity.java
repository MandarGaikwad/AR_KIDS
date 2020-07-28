package mandar.gaikwad.arkids_version_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;


public class QuizMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        naarActivity();
    }

    public void naarActivity() {
        Button buttonOverOns = (Button) findViewById(R.id.buttonOverOns);
        buttonOverOns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), OverOnsActivity.class));
            }
        });

        Button buttonSpelregels = (Button) findViewById(R.id.buttonSpelregels);
        buttonSpelregels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SpelregelsActivity.class));
            }
        });

        Button buttonVragen = (Button) findViewById(R.id.buttonVragen);
        buttonVragen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChangeQuestionsActivity.class));
            }
        });

        Button buttonQuiz = (Button) findViewById(R.id.buttonQuiz);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), QuizActivity.class));
            }
        });

        Button buttonRateApp = (Button) findViewById(R.id.buttonRateApp);
        buttonRateApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RateAppActivity.class));
            }
        });


    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        finish(); return;
    }
}
