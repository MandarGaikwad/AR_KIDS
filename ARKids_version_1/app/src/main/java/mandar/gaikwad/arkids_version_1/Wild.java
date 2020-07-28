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

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
public class Wild extends AppCompatActivity {
    static String string_alphabate;
    String[] myBooks;
    int t;
    private static final String SOUNDFILE_PATH = "wild_sounds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_list);

        Resources res = getResources();
        myBooks = res.getStringArray(R.array.wildanim);
        final ArrayList<CustomClass> items = new ArrayList<>();
        for (int i=0;i<9;i++ )
        {
            items.add(new CustomClass(myBooks[i]));
        }
        CustomAdapter3 customAdapter = new CustomAdapter3(Wild.this,items);

        final ListView listView = findViewById(R.id.list_view_animal);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                t= (int) parent.getItemIdAtPosition(position);
                string_alphabate= String.valueOf(myBooks[position]);
/*
                Toast.makeText(Wild.this, "I LOVE To DIE..!!! -- "+string_alphabate +"\n position "+ t, Toast.LENGTH_SHORT).show();
*/
                switch (position) {
                    case 0: playSoundFromAssets(position);
                        Intent i=new Intent(Wild.this,ARcoreL.class);
                        startActivity(i);
                        break;
                    case 1: playSoundFromAssets(position);
                        Intent in=new Intent(Wild.this,ARcoreT.class);
                        startActivity(in);
                        break;
                    case 2: playSoundFromAssets(position);
                        Intent in0=new Intent(Wild.this,ARcoreW.class);
                        startActivity(in0);
                        break;
                    case 3: playSoundFromAssets(position);
                        Intent in1=new Intent(Wild.this,ArcoreJaguar.class);
                        startActivity(in1);
                        break;
                    case 4: playSoundFromAssets(position);
                        Intent in2=new Intent(Wild.this,ARcoreE.class);
                        startActivity(in2);
                        break;
                    case 5: playSoundFromAssets(position);
                        Intent in3=new Intent(Wild.this,ARcoreZ.class);
                        startActivity(in3);
                        break;
                    case 6: playSoundFromAssets(position);
                        Intent in4=new Intent(Wild.this,ARcoreRhino.class);
                        startActivity(in4);
                        break;
                    case 7: playSoundFromAssets(position);
                        Intent in5=new Intent(Wild.this,ARcoreBear.class);
                        startActivity(in5);
                        break;
                    case 8: playSoundFromAssets(position);
                        Intent in6=new Intent(Wild.this,ARcoreDeer.class);
                        startActivity(in6);
                        break;
                    case 9: playSoundFromAssets(position);
                        Intent in7=new Intent(Wild.this,ARcoreK.class);
                        startActivity(in7);
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
                Log.d("Wild", String.format("<<<< %s %d %d", soundFilePath, afd.getStartOffset(), afd.getLength()));
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
}
