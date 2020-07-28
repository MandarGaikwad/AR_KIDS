package mandar.gaikwad.arkids_version_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mandar.gaikwad.arkids_version_1.Model.Question;


public class ChangeQuestionsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_questions);

        b1=(Button)findViewById(R.id.newQuestion);
        b2=(Button)findViewById(R.id.delQuestion);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_questions);
        new FirebaseDatabaseHelper().readQuestions(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Question> questions, List<String> keys) {
                findViewById(R.id.loading_questions_pb).setVisibility(View.GONE);
                new RecyclerView_Config().setConfig(mRecyclerView, ChangeQuestionsActivity.this, questions, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), NewQuestionActivity.class));
            finish();
        }
    });

    b2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), deleteQuestionActivity.class));
            finish();
        }
    });
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.questionlist_activity_menu, menu);
         return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.new_question:
                startActivity(new Intent(getApplicationContext(), NewQuestionActivity.class));
                return true;
            case R.id.delete_quiz:
                startActivity(new Intent(getApplicationContext(), deleteQuestionActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/


    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, QuizMainActivity.class));
        finish(); return;
    }


}
