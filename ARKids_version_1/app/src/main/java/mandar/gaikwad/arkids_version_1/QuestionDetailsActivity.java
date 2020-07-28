package mandar.gaikwad.arkids_version_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import mandar.gaikwad.arkids_version_1.Model.Question;


public class QuestionDetailsActivity extends AppCompatActivity {
    private EditText mQuestion_editTxt;
    private EditText mAnswer_editTxt;
    private EditText mOption1_editTxt;
    private EditText mOption2_editTxt;
    private EditText mOption3_editTxt;
    private EditText mOption4_editTxt;

    private Button mUpdate_btn;
    private Button mDelete_btn;
    private Button mBack_btn;

    private String key;
    private String question;
    private String answer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_details);

        key = getIntent().getStringExtra("key");
        question = getIntent().getStringExtra("question");
        answer = getIntent().getStringExtra("answer");
        option1 = getIntent().getStringExtra("option 1");
        option2 = getIntent().getStringExtra("option 2");
        option3 = getIntent().getStringExtra("option 3");
        option4 = getIntent().getStringExtra("option 4");



        mQuestion_editTxt = (EditText) findViewById(R.id.question_editTxt);
        mQuestion_editTxt.setText(question);
        mAnswer_editTxt = (EditText) findViewById(R.id.answer_editTxt);
        mAnswer_editTxt.setText(answer);
        mOption1_editTxt = (EditText) findViewById(R.id.option1_editTxt);
        mOption1_editTxt.setText(option1);
        mOption2_editTxt = (EditText) findViewById(R.id.option2_editTxt);
        mOption2_editTxt.setText(option2);
        mOption3_editTxt = (EditText) findViewById(R.id.option3_editTxt);
        mOption3_editTxt.setText(option3);
        mOption4_editTxt = (EditText) findViewById(R.id.option4_editTxt);
        mOption4_editTxt.setText(option4);
        mQuestion_editTxt.setSelection(mQuestion_editTxt.getText().length());


        mUpdate_btn = (Button) findViewById(R.id.update_btn);
        mDelete_btn = (Button) findViewById(R.id.delete_btn);
        mBack_btn = (Button) findViewById(R.id.back_btn);



        mUpdate_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Question question = new Question();
                question.setQuestion(mQuestion_editTxt.getText().toString());
                question.setAnswer(mAnswer_editTxt.getText().toString());
                question.setOption1(mOption1_editTxt.getText().toString());
                question.setOption2(mOption2_editTxt.getText().toString());
                question.setOption3(mOption3_editTxt.getText().toString());
                question.setOption4(mOption4_editTxt.getText().toString());

                new FirebaseDatabaseHelper().updateQuestion(key, question, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Question> questions, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(QuestionDetailsActivity.this, "Question has been updated", Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });

            }
        });


        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); return;
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, QuizMainActivity.class));
        finish(); return;
    }

}
