package com.mobileapp.ks1exercise;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class MainActivity extends AppCompatActivity {

    TextView tvFood, tvEntertainment, tvClothing, tvBill;
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

        // retrieve ids of each category's value and set it to a specific number for testing
        tvFood = findViewById(R.id.tvFood);
        tvEntertainment = findViewById(R.id.tvEntertainment);
        tvClothing = findViewById(R.id.tvClothing);
        tvBill = findViewById(R.id.tvBill);
        pieChart = findViewById(R.id.piechart);

        tvFood.setText(Integer.toString(40));
        tvEntertainment.setText(Integer.toString(30));
        tvClothing.setText(Integer.toString(5));
        tvBill.setText(Integer.toString(25));

        pieChart.addPieSlice(new PieModel("Food", Integer.parseInt(tvFood.getText().toString()), Color.parseColor("#FFA726")));
        pieChart.addPieSlice(new PieModel("Entertainment", Integer.parseInt(tvEntertainment.getText().toString()), Color.parseColor("#66BB6A")));
        pieChart.addPieSlice(new PieModel("Clothing", Integer.parseInt(tvClothing.getText().toString()), Color.parseColor("#EF5350")));
        pieChart.addPieSlice(new PieModel("Bill", Integer.parseInt(tvBill.getText().toString()), Color.parseColor("#29B6F6")));

        pieChart.startAnimation();
    }
}