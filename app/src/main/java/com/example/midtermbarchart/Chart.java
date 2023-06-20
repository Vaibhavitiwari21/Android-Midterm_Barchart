package com.example.midtermbarchart;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;

public class Chart extends AppCompatActivity {

    // Declare barChart variable as a global variable;
    com.github.mikephil.charting.charts.BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        barChart = findViewById(R.id.barChart_view);
        showBarChart();
    }

    // Barchart functionalities;
    private void showBarChart(){

        // ArrayLists for storing values and entries;
        ArrayList<Float> valueList = new ArrayList<>();
        ArrayList<BarEntry> entries = new ArrayList<>();
        // Barchart title;
        String title = "Barchart";

        // Intent to get the data from the MainActivity class;
        Intent getIntent = getIntent();
        String [] expectedValues = getIntent.getStringExtra(InputDetails.BARCHARTVALUES).split(" ");
        float[] number = new float[expectedValues.length];
        for (int i = 0; i < number.length; i++) {
            number[i] = Float.parseFloat(expectedValues[i]);
        }

        // Store values into valueList;
        for (float num : number) {
            valueList.add(num);
        }

        // Fit the data into a bar;
        for (int i = 0; i < valueList.size(); i++) {
            BarEntry barEntry = new BarEntry(i, valueList.get(i));
            entries.add(barEntry);
        }

        // Set the BarData;
        BarDataSet barDataSet = new BarDataSet(entries, title);
        BarData data = new BarData(barDataSet);
        barChart.setData(data);
        barChart.invalidate();

        // Adding color to bar data set.
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        // Setting text color.
        barDataSet.setValueTextColor(Color.BLACK);
        // setting text size
        barDataSet.setValueTextSize(16f);
        barChart.getDescription().setEnabled(false);

        // X-axis custom bar labels in a list;
        ArrayList xValues = new ArrayList();
        xValues.add("A%");
        xValues.add("B%");
        xValues.add("C%");
        xValues.add("D%");
        xValues.add("F%");

        // Display labels;
        XAxis xAxis = barChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMaximum(5);
        xAxis.setTextSize(17);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xValues));
    }
}