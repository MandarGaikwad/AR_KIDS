package mandar.gaikwad.arkids_version_1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

public class RateAppActivity extends AppCompatActivity {
    private PieChart mChart;
    public static final int MAX_Rate = 5;
    public static int currentRate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_app);

        mChart = (PieChart) findViewById(R.id.chart);
        Description d = new Description();
        d.setText("description");
        mChart.setDescription(d);
        mChart.setTouchEnabled(false);
        mChart.setDrawSliceText(true);
        mChart.getLegend().setEnabled(false);
        mChart.setTransparentCircleColor(Color.rgb(130, 130, 130));
        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        setData(0);

        Button fab = (Button) findViewById(R.id.plusEenTest);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentRate < MAX_Rate) {
                    setData(currentRate += 1);
                } else {
                    setData(currentRate = 0);
                }
            }
        });

        Button buttonRate = (Button) findViewById(R.id.buttonRate);
        buttonRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RateAppActivity.this, "Thank you for rating the quiz!", Toast.LENGTH_LONG).show();
                finish(); return;
            }
        });
    }

    private void setData(int aantal) {
        currentRate = aantal;  //aantal means number
        List<PieEntry> yValues = new ArrayList<>();
        List<PieEntry> xValues = new ArrayList<>();

        yValues.add(new PieEntry(aantal, 0));
        xValues.add(new PieEntry(aantal, "Earned ECTS"));

        yValues.add(new PieEntry(5 - currentRate, 1));
        xValues.add(new PieEntry(5 - aantal, "Remaining ECTS"));

        //  http://www.materialui.co/colors
        ArrayList<Integer> colors = new ArrayList<>();
        if (currentRate <= 2) {
            colors.add(Color.rgb(235, 0, 0));
        } else if (currentRate <= 3) {
            colors.add(Color.rgb(244, 81, 30));
        } else if (currentRate < 5) {
            colors.add(Color.rgb(253, 216, 53));
        } else {
            colors.add(Color.rgb(67, 160, 71));
        }
        colors.add(Color.rgb(255, 0, 0));

        PieDataSet dataSet = new PieDataSet(yValues, "Rate");
        dataSet.setColors(colors);//colors);

        // PieDataSet set = new PieDataSet(xValues, "Election Results");

        PieData data = new PieData(dataSet);
        mChart.setData(data); // bind dataset aan chart.
        mChart.invalidate();  // Aanroepen van een redraw
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, QuizMainActivity.class));
        finish();
        return;
    }
}

