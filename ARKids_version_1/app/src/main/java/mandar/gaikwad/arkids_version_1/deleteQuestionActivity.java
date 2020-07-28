package mandar.gaikwad.arkids_version_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import mandar.gaikwad.arkids_version_1.Model.Question;


public class deleteQuestionActivity extends AppCompatActivity {
    private Button mDelete_btn;
    private Button mTerug_btn;
    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_question);

        mDelete_btn = (Button) findViewById(R.id.delete_btn);
        mTerug_btn = (Button) findViewById(R.id.terug_btn);
        key = getIntent().getStringExtra("key");

        mDelete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDatabaseHelper().deleteQuestion(key, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Question> questions, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {


                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(deleteQuestionActivity.this, "\n" +
                                "All questions have been removed!!", Toast.LENGTH_LONG).show();
                        finish();
                        return;
                    }
                });

            }

        });

        mTerug_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                return;
            }
        });


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, QuizMainActivity.class));
        finish();
        return;
    }
}
