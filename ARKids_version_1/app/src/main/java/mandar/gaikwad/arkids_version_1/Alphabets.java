package mandar.gaikwad.arkids_version_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Alphabets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);

        //Theme Image Buttons
        RelativeLayout visual =(RelativeLayout)findViewById(R.id.visual);
        visual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Alphabets.this,VisualAudioPracList.class);
                startActivity(intent);
                //       Toast.makeText(getApplication(),"Alphabets", Toast.LENGTH_SHORT).show();
            }
        });

       //Theme Image Buttons
        RelativeLayout signpad =(RelativeLayout)findViewById(R.id.signpad);
        signpad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Alphabets.this,SignPad.class);
                startActivity(intent);
                //       Toast.makeText(getApplication(),"Alphabets", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
