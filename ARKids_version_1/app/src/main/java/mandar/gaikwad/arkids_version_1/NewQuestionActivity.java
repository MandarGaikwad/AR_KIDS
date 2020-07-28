package mandar.gaikwad.arkids_version_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import mandar.gaikwad.arkids_version_1.Model.Question;


public class NewQuestionActivity extends AppCompatActivity {
    private EditText mQuestion_editTxt;
    private EditText mAnswer_editTxt;
    private EditText mOption1_editTxt;
    private EditText mOption2_editTxt;
    private EditText mOption3_editTxt;
    private EditText mOption4_editTxt;
    private Button mAdd_btn;
    private Button mBack_btn;
    DatabaseReference reference;

    private String sCheckQuestion;
    private String sCheckAnswer;
    private String sCheckOption1;
    private String sCheckOption2;
    private String sCheckOption3;
    private String sCheckOption4;


    long maxid = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_question);
        mQuestion_editTxt = (EditText) findViewById(R.id.question_editTxt);
        mAnswer_editTxt = (EditText) findViewById(R.id.answer_editTxt);
        mOption1_editTxt = (EditText) findViewById(R.id.option1_editTxt);
        mOption2_editTxt = (EditText) findViewById(R.id.option2_editTxt);
        mOption3_editTxt = (EditText) findViewById(R.id.option3_editTxt);
        mOption4_editTxt = (EditText) findViewById(R.id.option4_editTxt);


        mAdd_btn = (Button) findViewById(R.id.update_btn);
        mBack_btn = (Button) findViewById(R.id.back_btn);


        reference = FirebaseDatabase.getInstance().getReference().child("Questions");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    maxid = (dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sCheckQuestion = mQuestion_editTxt.getText().toString();
                if (sCheckQuestion.matches("")) {
                    Toast.makeText(NewQuestionActivity.this,"You forgot to add a question", Toast.LENGTH_LONG).show();
                    return;
                }
                sCheckAnswer = mAnswer_editTxt.getText().toString();
                if (sCheckAnswer.matches("")) {
                    Toast.makeText(NewQuestionActivity.this,"You forgot to add a Answer", Toast.LENGTH_LONG).show();
                    return;
                }

                sCheckOption1 = mOption1_editTxt.getText().toString();
                if (sCheckOption1.matches("")) {
                    Toast.makeText(NewQuestionActivity.this,"You forgot to add option 1", Toast.LENGTH_LONG).show();
                    return;
                }
                sCheckOption2 = mOption2_editTxt.getText().toString();
                if (sCheckOption2.matches("")) {
                    Toast.makeText(NewQuestionActivity.this,"You forgot to add option 2", Toast.LENGTH_LONG).show();
                    return;
                }
                sCheckOption3 = mOption3_editTxt.getText().toString();
                if (sCheckOption3.matches("")) {
                    Toast.makeText(NewQuestionActivity.this,"You forgot to add option 3", Toast.LENGTH_LONG).show();
                    return;
                }
                sCheckOption4 = mOption4_editTxt.getText().toString();
                if (sCheckOption4.matches("")) {
                    Toast.makeText(NewQuestionActivity.this,"You forgot to add option 4", Toast.LENGTH_LONG).show();
                    return;
                }

                if (sCheckAnswer.matches(sCheckOption1) || sCheckAnswer.matches(sCheckOption2) || sCheckAnswer.matches(sCheckOption3) || sCheckAnswer.matches(sCheckOption4)) {
                    Question question = new Question();
                    question.setQuestion(mQuestion_editTxt.getText().toString());
                    question.setAnswer(mAnswer_editTxt.getText().toString());
                    question.setOption1(mOption1_editTxt.getText().toString());
                    question.setOption2(mOption2_editTxt.getText().toString());
                    question.setOption3(mOption3_editTxt.getText().toString());
                    question.setOption4(mOption4_editTxt.getText().toString());
                    reference.child(String.valueOf(maxid + 1)).setValue(question);
                    Toast.makeText(NewQuestionActivity.this,  " ASk " + (maxid + 1) + " Added to database", Toast.LENGTH_LONG).show();
                    finish();
                    return;
                } else {
                    Toast.makeText(NewQuestionActivity.this,"Answer does not match 1 of the options", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });

        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                return;
            }
        });


    }
    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, QuizMainActivity.class));
        finish(); return;
    }

}

