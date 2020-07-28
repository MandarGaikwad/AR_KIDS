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


import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;

public class Fruit extends AppCompatActivity {
    static String string_alphabate;
    String[] myBooks;
    int t;
    private static final String SOUNDFILE_PATH = "fruit_sounds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fruit_list);

        Resources res = getResources();
        myBooks = res.getStringArray(R.array.fruits);
        final ArrayList<CustomClass> items = new ArrayList<>();
        for (int i=0;i<9;i++ )
        {
            items.add(new CustomClass(myBooks[i]));
        }
        CustomAdapter2 customAdapter = new CustomAdapter2(Fruit.this,items);

        final ListView listView = findViewById(R.id.list_view_fruit);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                t= (int) parent.getItemIdAtPosition(position);
                string_alphabate= String.valueOf(myBooks[position]);
                //Toast.makeText(Fruit.this, "I LOVE To DIE..!!! -- "+string_alphabate +"\n position "+ t, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0: playSoundFromAssets(position);
                        Intent i=new Intent(Fruit.this,ARcore.class);
                        startActivity(i);
                        break;
                    case 1: playSoundFromAssets(position);
                        Intent in=new Intent(Fruit.this,ARcoreO.class);
                        startActivity(in);
                        break;
                    case 2: playSoundFromAssets(position);
                        Intent in0=new Intent(Fruit.this,ARcoreBanana.class);
                        startActivity(in0);
                        break;
                    case 3: playSoundFromAssets(position);
                        Intent in1=new Intent(Fruit.this,ARcoreG.class);
                        startActivity(in1);
                        break;
                    case 4: playSoundFromAssets(position);
                        Intent in2=new Intent(Fruit.this,ARcorePapaya.class);
                        startActivity(in2);
                        break;
                    case 5: playSoundFromAssets(position);
                        Intent in3=new Intent(Fruit.this,ARcoreStrawberry.class);
                        startActivity(in3);
                        break;
                    case 6: playSoundFromAssets(position);
                        Intent in4=new Intent(Fruit.this,ARcoreWaterMelon.class);
                        startActivity(in4);
                        break;
                    case 7: playSoundFromAssets(position);
                        Intent in5=new Intent(Fruit.this,ARcoreCherry.class);
                        startActivity(in5);
                        break;
                    case 8: playSoundFromAssets(position);
                        Intent in6=new Intent(Fruit.this,ARcorePineapple.class);
                        startActivity(in6);
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
                Log.d("VisualAudioPracList", String.format("<<<< %s %d %d", soundFilePath, afd.getStartOffset(), afd.getLength()));
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
