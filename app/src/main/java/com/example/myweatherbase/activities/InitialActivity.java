package com.example.myweatherbase.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.CityRepository;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InitialActivity extends AppCompatActivity {

    private TextInputEditText tiSelectCity;
    private TextView selectCityImg;
    private Spinner spinner;
    private Button forecastButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        tiSelectCity = findViewById(R.id.tISelectCity);
        spinner = findViewById(R.id.spinner);
        forecastButton = findViewById(R.id.buttonForecast);
        selectCityImg = findViewById(R.id.selecCityImg);

        ArrayAdapter<SavedCity> myAdapter = new ArrayAdapter<SavedCity>(this,android.R.layout.simple_spinner_item, CityRepository.getInstance().getAll()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                SavedCity savedCity = getItem(position);
                if(savedCity.getCityName().equals("Saved cities")){
                    textView.setText(savedCity.getCityName());
                }else{
                    textView.setText(savedCity.getCityName() + ", " + savedCity.getCountryName());
                }
                return textView;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getDropDownView(position, convertView, parent);
                SavedCity savedCity = getItem(position);
                if(savedCity.getCityName().equals("Saved cities")){
                    textView.setText("...");
                }else{
                    textView.setText(savedCity.getCityName() + ", " + savedCity.getCountryName());
                }
                return textView;
            }
        };

        spinner.setAdapter(myAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.getItemAtPosition(i);
                SavedCity selectedCity = (SavedCity) adapterView.getItemAtPosition(i);
                selectCityImg.setBackgroundResource(selectedCity.getImage());
                if(selectedCity.getCityName().equals("Saved cities")){
                    selectCityImg.setText("Select a city");
                }else{
                    selectCityImg.setText(selectedCity.getCityName());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        forecastButton.setOnClickListener(view -> {
            String cityName = "";

            if(tiSelectCity.getText()!=null){
                cityName = tiSelectCity.getText().toString();

            }

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("cityName", cityName);
            startActivity(intent);

        });

    }

}