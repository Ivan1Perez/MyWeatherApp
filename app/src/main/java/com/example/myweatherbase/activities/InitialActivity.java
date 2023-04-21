package com.example.myweatherbase.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.CityRepository;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InitialActivity extends AppCompatActivity {

    private TextInputEditText tiSelectCity;
    private Spinner spinner;
    private Button forecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        tiSelectCity = findViewById(R.id.tISelectCity);
        spinner = findViewById(R.id.spinner);
        forecast = findViewById(R.id.buttonForecast);

        ArrayAdapter<SavedCity> myAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, CityRepository.getInstance().getAll());
        spinner.setAdapter(myAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}