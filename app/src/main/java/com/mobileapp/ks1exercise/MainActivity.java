package com.mobileapp.ks1exercise;

import android.graphics.Color;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class MainActivity extends AppCompatActivity {
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        pieChart = findViewById(R.id.piechart);

        pieChart.addPieSlice(new PieModel("Food", Integer.parseInt("40"), Color.parseColor("#FFA726")));
        pieChart.addPieSlice(new PieModel("Entertainment", Integer.parseInt("30"), Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(new PieModel("Clothing", Integer.parseInt("5"), Color.parseColor("#EF5350")));
        pieChart.addPieSlice(new PieModel("Bill", Integer.parseInt("25"), Color.parseColor("#29B6F6")));

        pieChart.startAnimation();
    }
}