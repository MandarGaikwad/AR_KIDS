package mandar.gaikwad.arkids_version_1;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SpelregelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spelregels);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, QuizMainActivity.class));
        finish(); return;
    }
}
