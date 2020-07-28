package mandar.gaikwad.arkids_version_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.WildcardType;

public class Animals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        //Theme Image Buttons
        RelativeLayout wild =(RelativeLayout)findViewById(R.id.wild);
        wild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Animals.this, Wild.class);
                startActivity(intent);
                //Toast.makeText(getApplication(),"Alphabets", Toast.LENGTH_SHORT).show();
            }
        });

        //Theme Image Buttons
        RelativeLayout domestic =(RelativeLayout)findViewById(R.id.domestic);
        domestic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Animals.this,Domestic.class);
                startActivity(intent);
               //Toast.makeText(getApplication(),"Domestic", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
