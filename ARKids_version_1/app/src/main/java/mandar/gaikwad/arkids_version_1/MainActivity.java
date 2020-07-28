package mandar.gaikwad.arkids_version_1;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tabs.TabLayout;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import java.util.Arrays;

import Menu.DrawerAdapter;
import Menu.DrawerItem;
import Menu.SimpleItem;
import Menu.SpaceItem;


public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, DrawerAdapter.OnItemSelectedListener{

    private SlidingRootNav slidingRootNav;
    private static final int POS_DASHBOARD = 0;
    private static final int POS_ACCOUNT = 1;
    private static final int POS_MESSAGES = 2;
    private static final int POS_HELP = 3;
    private static final int POS_LOGOUT = 4;

    private String[] screenTitles;
    private Drawable[] screenIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Be Aware of the surroundings..!");
                builder.setCancelable(false)
                        .setPositiveButton("Ok",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.dismiss();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.setTitle("Parental Advisory..!");
                alert.setIcon(R.drawable.alert);
                alert.show();
            }
        }, 1000);

        //Theme Image Buttons
        RelativeLayout rel1 =(RelativeLayout)findViewById(R.id.rel1);
        rel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Alphabets.class);
                startActivity(intent);
         //       Toast.makeText(getApplication(),"Alphabets", Toast.LENGTH_SHORT).show();
            }
        });

        RelativeLayout rel2 =(RelativeLayout)findViewById(R.id.rel2);
        rel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, Number.class);
                startActivity(i);
                //Toast.makeText(getApplication(),"Numbers", Toast.LENGTH_SHORT).show();
            }
        });

        RelativeLayout rel3 =(RelativeLayout)findViewById(R.id.rel3);
        rel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(MainActivity.this, Fruit.class);
                startActivity(a);
               // Toast.makeText(getApplication(),"Fruits", Toast.LENGTH_SHORT).show();
            }
        });

        RelativeLayout rel4 =(RelativeLayout)findViewById(R.id.rel4);
        rel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent an=new Intent(MainActivity.this, Animals.class);
                startActivity(an);
/*
                Toast.makeText(getApplication(),"Animals", Toast.LENGTH_SHORT).show();
*/
            }
        });

        //NAVIGATION
        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(true)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter drawadapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_DASHBOARD).setChecked(true),
                createItemFor(POS_ACCOUNT),
                createItemFor(POS_MESSAGES),
                createItemFor(POS_HELP),
                new SpaceItem(48),
                createItemFor(POS_LOGOUT)));
        drawadapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(drawadapter);

        drawadapter.setSelected(POS_DASHBOARD);
    }


    @Override
    public void onItemSelected(int position) {
        if (position == POS_LOGOUT) {
            finish();
        }
        if (position == POS_ACCOUNT

                ) {
                Intent i =new Intent(getApplication(), About.class);
                startActivity(i);
        }

        if (position == POS_MESSAGES

                ) {
               Intent i =new Intent(getApplication(), QuizMainActivity.class);
              startActivity(i);
        }

        if (position == POS_HELP){
            Intent i = new Intent(getApplication(),About.class);
            startActivity(i);
        }

        //Share Option
      /*  if (position == POS_MESSAGES

                ) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT," Click to download Colors Soda app from wwww. ");
            sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,"G E E N  B O X");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        }*/

        slidingRootNav.closeMenu();
        //Fragment selectedScreen = CenteredTextFragment.createFor(screenTitles[position]);
        // showFragment(selectedScreen);
    }



    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.textColorSecondary))
                .withTextTint(color(R.color.textColorSecondary))
                .withSelectedIconTint(color(R.color.navfun))
                .withSelectedTextTint(color(R.color.navfun));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }
    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }
    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}


