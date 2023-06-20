package com.example.midtermbarchart;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Objects;

public class InputDetails extends AppCompatActivity {

    // Declare constant variables;
    public static final String BARCHARTVALUES = "com.example.midtermbarchart.VALUES";
    // Declare UI elements;
    Button viewResultButton, plotButton;
    EditText totalNoOfStudentsInputField, aGroupStudentsInputField, bGroupStudentsInputField, cGroupStudentsInputField, dGroupStudentsInputField, fGroupStudentsInputField;
    // Declare code variables;
    private Integer totalStudents, aGrpStudents, bGrpStudents, cGrpStudents, dGrpStudents, fGrpStudents;
    private double aGroupPercentage, bGroupPercentage, cGroupPercentage, dGroupPercentage, fGroupPercentage;
    private String aGroupResult, bGroupResult, cGroupResult, dGroupResult, fGroupResult, allResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Action bar custom text display;
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // Linked with activity_input_details xml layout;
        setContentView(R.layout.activity_input_details);

        // Initialize layout elements;
        totalNoOfStudentsInputField = findViewById(R.id.totalNoStudentsInputfield);
        aGroupStudentsInputField = findViewById(R.id.inputField1);
        bGroupStudentsInputField = findViewById(R.id.inputField2);
        cGroupStudentsInputField = findViewById(R.id.inputField3);
        dGroupStudentsInputField = findViewById(R.id.inputField4);
        fGroupStudentsInputField = findViewById(R.id.inputField5);
        viewResultButton = findViewById(R.id.viewResult);
        plotButton = findViewById(R.id.plotButton);

        // View Result Button Functionality;
        viewResultButton.setOnClickListener(v -> {
            // Retrieve entered values as a String;
            String totalNoOfStudents = totalNoOfStudentsInputField.getText().toString().trim();
            String aGroupStudents = aGroupStudentsInputField.getText().toString().trim();
            String bGroupStudents = bGroupStudentsInputField.getText().toString().trim();
            String cGroupStudents = cGroupStudentsInputField.getText().toString().trim();
            String dGroupStudents = dGroupStudentsInputField.getText().toString().trim();
            String fGroupStudents = fGroupStudentsInputField.getText().toString().trim();


            // Check if any EditText fields are empty
            if (totalNoOfStudents.isEmpty() || aGroupStudents.isEmpty() || bGroupStudents.isEmpty()
                    || cGroupStudents.isEmpty() || dGroupStudents.isEmpty() || fGroupStudents.isEmpty()) {
                // Show alert box to fill all details
                new AlertDialog.Builder(InputDetails.this)
                        .setTitle("Error")
                        .setMessage("Please fill all details")
                        .setPositiveButton(android.R.string.ok, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            } else {

                // All EditText fields have data, proceed with calculations and display the result
                // Convert String values into integers;
                totalStudents = Integer.parseInt(totalNoOfStudents);
                aGrpStudents = Integer.parseInt(aGroupStudents);
                bGrpStudents = Integer.parseInt(bGroupStudents);
                cGrpStudents = Integer.parseInt(cGroupStudents);
                dGrpStudents = Integer.parseInt(dGroupStudents);
                fGrpStudents = Integer.parseInt(fGroupStudents);

                // Convert String values into double and calculate the percentage;
                aGroupPercentage = ((double) aGrpStudents / (double) totalStudents) * 100;
                bGroupPercentage = ((double) bGrpStudents / (double) totalStudents) * 100;
                cGroupPercentage = ((double) cGrpStudents / (double) totalStudents) * 100;
                dGroupPercentage = ((double) dGrpStudents / (double) totalStudents) * 100;
                fGroupPercentage = ((double) fGrpStudents / (double) totalStudents) * 100;

                // Convert the percentage values into String values;
                aGroupResult = Double.toString(aGroupPercentage);
                bGroupResult = Double.toString(bGroupPercentage);
                cGroupResult = Double.toString(cGroupPercentage);
                dGroupResult = Double.toString(dGroupPercentage);
                fGroupResult = Double.toString(fGroupPercentage);

                // String buffer to store all percentage values to display on the alert;
                StringBuffer buffer = new StringBuffer();
                buffer.append("As Students: ").append(aGroupResult).append("%").append("\n");
                buffer.append("Bs Students: ").append(bGroupResult).append("%").append("\n");
                buffer.append("Cs Students: ").append(cGroupResult).append("%").append("\n");
                buffer.append("Ds Students: ").append(dGroupResult).append("%").append("\n");
                buffer.append("Fs Students: ").append(fGroupResult).append("%");
                buffer.append("\n");

                // Alert to display the result;
                AlertDialog.Builder builder = new AlertDialog.Builder(InputDetails.this);
                builder.setCancelable(true);
                builder.setTitle("The percentage of grade distribution are: ");
                builder.setMessage(buffer);
                builder.setPositiveButton("OK", (dialog, which) -> {
                    // do something when OK button is clicked
                    dialog.dismiss();
                });
                builder.show();
            }
        });


        // Plot Button functionality;
        plotButton.setOnClickListener(v -> {
            // Retrieve entered values as a String;
            String totalNoOfStudents = totalNoOfStudentsInputField.getText().toString().trim();
            String aGroupStudents = aGroupStudentsInputField.getText().toString().trim();
            String bGroupStudents = bGroupStudentsInputField.getText().toString().trim();
            String cGroupStudents = cGroupStudentsInputField.getText().toString().trim();
            String dGroupStudents = dGroupStudentsInputField.getText().toString().trim();
            String fGroupStudents = fGroupStudentsInputField.getText().toString().trim();

            // Check if any EditText fields are empty
            if (totalNoOfStudents.isEmpty() || aGroupStudents.isEmpty() || bGroupStudents.isEmpty()
                    || cGroupStudents.isEmpty() || dGroupStudents.isEmpty() || fGroupStudents.isEmpty()) {
                // Show alert box to fill all details
                new AlertDialog.Builder(InputDetails.this)
                        .setTitle("Error")
                        .setMessage("Please fill all details")
                        .setPositiveButton(android.R.string.ok, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            } else {

                // All EditText fields have data, proceed with calculations and display the result
                // Convert String values into integers;
                totalStudents = Integer.parseInt(totalNoOfStudents);
                aGrpStudents = Integer.parseInt(aGroupStudents);
                bGrpStudents = Integer.parseInt(bGroupStudents);
                cGrpStudents = Integer.parseInt(cGroupStudents);
                dGrpStudents = Integer.parseInt(dGroupStudents);
                fGrpStudents = Integer.parseInt(fGroupStudents);

                // Convert String values into double and calculate the percentage;
                aGroupPercentage = ((double) aGrpStudents / (double) totalStudents) * 100;
                bGroupPercentage = ((double) bGrpStudents / (double) totalStudents) * 100;
                cGroupPercentage = ((double) cGrpStudents / (double) totalStudents) * 100;
                dGroupPercentage = ((double) dGrpStudents / (double) totalStudents) * 100;
                fGroupPercentage = ((double) fGrpStudents / (double) totalStudents) * 100;

                // Convert the percentage values into String values;
                aGroupResult = Double.toString(aGroupPercentage);
                bGroupResult = Double.toString(bGroupPercentage);
                cGroupResult = Double.toString(cGroupPercentage);
                dGroupResult = Double.toString(dGroupPercentage);
                fGroupResult = Double.toString(fGroupPercentage);

                // Store all values together;
                allResults = aGroupResult + " " + bGroupResult + " " + cGroupResult + " " + dGroupResult + " " + fGroupResult;

                // Intent to pass the data to BarChart class;
                Intent intent = new Intent(InputDetails.this, Chart.class);
                intent.putExtra(BARCHARTVALUES, allResults);
                startActivity(intent);
            }
        });
    }
}