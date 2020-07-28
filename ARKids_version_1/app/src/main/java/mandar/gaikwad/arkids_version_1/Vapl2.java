package mandar.gaikwad.arkids_version_1;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;

public class Vapl2 extends AppCompatActivity {

    static String string_numbers;
    String[] myNumbers;
    int t;
    private static final String SOUNDFILE_PATH = "num_sounds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numberlist);
        Resources res = getResources();
        myNumbers = res.getStringArray(R.array.number1);
        final ArrayList<CustomClass> items = new ArrayList<>();
        for (int i=0;i<10;i++ )
        {
            items.add(new CustomClass(myNumbers[i]));
        }
        CustomAdapter customAdapter = new CustomAdapter(Vapl2.this,items);


        showMessageOk("Note","AR numbers will be included in next update:-)");


        final ListView listView = findViewById(R.id.list_view_num);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                t= (int) parent.getItemIdAtPosition(position);
                string_numbers= String.valueOf(myNumbers[position]);
/*
                Toast.makeText(Vapl2.this, "I LOVE To DIE..!!! -- "+string_numbers +"\n position "+ t, Toast.LENGTH_SHORT).show();
*/
                switch (position) {
                    case 0: playSoundFromAssets(position);
                        /*Intent in=new Intent(Vapl2.this,ARcoreZero.class);
                        startActivity(in);*/
                        break;
                    case 1: playSoundFromAssets(position);
                       /* Intent in1=new Intent(Vapl2.this,ARcoreOne.class);
                        startActivity(in1);*/
                        break;
                    case 2: playSoundFromAssets(position);
                        /*Intent in2=new Intent(Vapl2.this,ARcoreTwo.class);
                        startActivity(in2);*/
                        break;
                    case 3: playSoundFromAssets(position);
                      /*  Intent in3=new Intent(Vapl2.this,ARcoreThree.class);
                        startActivity(in3);*/
                        break;
                    case 4: playSoundFromAssets(position);
                       /* Intent in4=new Intent(Vapl2.this,ARcoreFour.class);
                        startActivity(in4);*/
                        break;
                    case 5: playSoundFromAssets(position);
                      /*  Intent in5=new Intent(Vapl2.this,ARcoreFive.class);
                        startActivity(in5);*/
                        break;
                    case 6: playSoundFromAssets(position);
                       /* Intent in6=new Intent(Vapl2.this,ARcoreSix.class);
                        startActivity(in6);*/
                        break;
                    case 7: playSoundFromAssets(position);
                       /* Intent in7=new Intent(Vapl2.this,ARcoreSeven.class);
                        startActivity(in7);*/
                        break;
                    case 8: playSoundFromAssets(position);
                        /*Intent in8=new Intent(Vapl2.this,ARcoreEight.class);
                        startActivity(in8);*/
                        break;
                    case 9: playSoundFromAssets(position);
                        /*Intent in9=new Intent(Vapl2.this,ARcoreNine.class);
                        startActivity(in9);*/
                        break;
                    case 10: playSoundFromAssets(position);
                        /*Intent in10=new Intent(Vapl2.this,ARcoreTen.class);
                        startActivity(in10);*/
                        break;
                }
            }
        });
    }

    private void playSoundFromAssets(int index) {
        try {
            AssetManager assetManager = getAssets();
            String[] audios = assetManager.list(SOUNDFILE_PATH);
            if (audios == null || index >= audios.length) {
                return;
            }
            String soundFilePath = new File(SOUNDFILE_PATH, audios[index]).getPath();
            AssetFileDescriptor afd = getAssets().openFd(soundFilePath);
            final MediaPlayer mp = new MediaPlayer();

            /*  For API 24+, we can just use the AssetFileDescriptor to play the sound. However,
                for API 23-, we can't use the AssetFileDescriptor directly but can retrieve a
                FileDescriptor from it that points to the beginning of our assets. The offset
                and length from the AssetFileDescriptor serve for the FileDescriptor as well.
             */

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                mp.setDataSource(afd);
            } else {
                FileDescriptor fd = afd.getFileDescriptor();
                Log.d("Vapl2", String.format("<<<< %s %d %d", soundFilePath, afd.getStartOffset(), afd.getLength()));
                mp.setDataSource(fd, afd.getStartOffset(), afd.getLength());

                // One might think that mp.setDataSource(fd) would play the sound file we want, but
                // it actually plays all sound files one after another. It seems that fd is a
                // FileDescriptor that points to the beginning of the assets.
            }
            afd.close();
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void showMessageOk(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}


