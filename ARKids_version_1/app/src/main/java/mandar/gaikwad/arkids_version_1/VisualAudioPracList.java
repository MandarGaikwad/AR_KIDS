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
public class VisualAudioPracList extends AppCompatActivity {
    static String string_alphabate;
    String[] myBooks;
    int t;
    private static final String SOUNDFILE_PATH = "alpa_sounds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listviewalphabets);

        Resources res = getResources();
        myBooks = res.getStringArray(R.array.alphabets1);
        final ArrayList<CustomClass> items = new ArrayList<>();
        for (int i=0;i<26;i++ )
        {
            items.add(new CustomClass(myBooks[i]));
        }
        CustomAdapter customAdapter = new CustomAdapter(VisualAudioPracList.this,items);

        final ListView listView = findViewById(R.id.list_view_alpha);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                t= (int) parent.getItemIdAtPosition(position);
                string_alphabate= String.valueOf(myBooks[position]);
/*
                Toast.makeText(VisualAudioPracList.this, "I LOVE To DIE..!!! -- "+string_alphabate +"\n position "+ t, Toast.LENGTH_SHORT).show();
*/
                switch (position) {
                    case 0: playSoundFromAssets(position);
                    Intent i=new Intent(VisualAudioPracList.this,ARcore.class);
                    startActivity(i);
                        break;
                    case 1: playSoundFromAssets(position);
                        Intent in=new Intent(VisualAudioPracList.this,ARcoreB.class);
                        startActivity(in);
                        break;
                    case 2: playSoundFromAssets(position);
                        Intent in0=new Intent(VisualAudioPracList.this,ARcoreC.class);
                        startActivity(in0);
                        break;
                    case 3: playSoundFromAssets(position);
                        Intent in1=new Intent(VisualAudioPracList.this,ArcoreD.class);
                        startActivity(in1);
                        break;
                    case 4: playSoundFromAssets(position);
                        Intent in2=new Intent(VisualAudioPracList.this,ARcoreE.class);
                        startActivity(in2);
                        break;
                    case 5: playSoundFromAssets(position);
                        Intent in3=new Intent(VisualAudioPracList.this,ARcoreF.class);
                        startActivity(in3);
                        break;
                    case 6: playSoundFromAssets(position);
                        Intent in4=new Intent(VisualAudioPracList.this,ARcoreG.class);
                        startActivity(in4);
                        break;
                    case 7: playSoundFromAssets(position);
                        Intent in5=new Intent(VisualAudioPracList.this,ARcoreH.class);
                        startActivity(in5);
                        break;
                    case 8: playSoundFromAssets(position);
                        Intent in6=new Intent(VisualAudioPracList.this,ARcoreI.class);
                        startActivity(in6);
                        break;
                    case 9: playSoundFromAssets(position);
                        Intent in7=new Intent(VisualAudioPracList.this,ARcoreJ.class);
                        startActivity(in7);
                        break;
                    case 10: playSoundFromAssets(position);
                    Intent in8=new Intent(VisualAudioPracList.this,ARcoreK.class);
                        startActivity(in8);
                        break;
                    case 11: playSoundFromAssets(position);
                        Intent in9=new Intent(VisualAudioPracList.this,ARcoreL.class);
                        startActivity(in9);
                        break;
                    case 12: playSoundFromAssets(position);
                        Intent in10=new Intent(VisualAudioPracList.this,ARcoreM.class);
                        startActivity(in10);
                        break;
                    case 13: playSoundFromAssets(position);
                        Intent in11=new Intent(VisualAudioPracList.this,ARcoreN.class);
                        startActivity(in11);
                        break;
                    case 14: playSoundFromAssets(position);
                        Intent in12=new Intent(VisualAudioPracList.this,ARcoreO.class);
                        startActivity(in12);
                        break;
                    case 15: playSoundFromAssets(position);
                        Intent in13=new Intent(VisualAudioPracList.this,ARcoreP.class);
                        startActivity(in13);
                        break;
                    case 16: playSoundFromAssets(position);
                        Intent in14=new Intent(VisualAudioPracList.this,ARcoreQ.class);
                        startActivity(in14);
                        break;
                    case 17: playSoundFromAssets(position);
                        Intent in15=new Intent(VisualAudioPracList.this,ARcoreR.class);
                        startActivity(in15);
                        break;
                    case 18: playSoundFromAssets(position);
                        Intent in16=new Intent(VisualAudioPracList.this,ARcoreS.class);
                        startActivity(in16);
                        break;
                    case 19: playSoundFromAssets(position);
                        Intent in17=new Intent(VisualAudioPracList.this,ARcoreT.class);
                        startActivity(in17);
                        break;
                    case 20:
                        playSoundFromAssets(position);
                        Intent in18=new Intent(VisualAudioPracList.this,ARcoreU.class);
                        startActivity(in18);
                        break;
                    case 21:
                        playSoundFromAssets(position);
                        Intent in19=new Intent(VisualAudioPracList.this,ARcoreV.class);
                        startActivity(in19);
                        break;
                    case 22:
                        playSoundFromAssets(position);
                        Intent in20=new Intent(VisualAudioPracList.this,ARcoreW.class);
                        startActivity(in20);
                        break;
                    case 23:
                        playSoundFromAssets(position);
                        Intent in21=new Intent(VisualAudioPracList.this,ARcoreX.class);
                        startActivity(in21);
                        break;
                    case 24:
                        playSoundFromAssets(position);
                        Intent in22=new Intent(VisualAudioPracList.this,ARcoreY.class);
                        startActivity(in22);
                        break;
                    case 25:
                        playSoundFromAssets(position);
                        Intent in23=new Intent(VisualAudioPracList.this,ARcoreZ.class);
                        startActivity(in23);
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
