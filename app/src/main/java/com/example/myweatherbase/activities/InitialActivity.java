package com.example.myweatherbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.activities.model.CityRepository;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;
import com.google.android.material.textfield.TextInputEditText;

public class InitialActivity extends BaseActivity {

    private RootLatLonByName rootLatLonByName;

    private TextInputEditText tiSelectCity;
    private TextView selectCityImg;
    private Spinner spinner;
    private Button forecastButton;
    private String locationPath;
    private String locationName;
    private String stateName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        tiSelectCity = findViewById(R.id.tISelectCity);
        spinner = findViewById(R.id.spinner);
        forecastButton = findViewById(R.id.buttonForecast);
        selectCityImg = findViewById(R.id.selecCityImg);
        locationPath = "";
        locationName = "";
        stateName = "";


        ArrayAdapter<Ciudad> myAdapter = new ArrayAdapter<Ciudad>(this,android.R.layout.simple_spinner_item, CityRepository.getInstance().getAll()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                TextView textView = (TextView) super.getView(position, convertView, parent);
                Ciudad savedCity = getItem(position);
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
                Ciudad savedCity = getItem(position);
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
                Ciudad selectedCity = (Ciudad) adapterView.getItemAtPosition(i);
//                selectCityImg.setBackgroundResource(selectedCity.getImage());
                if(selectedCity.getCityName().equals("Saved cities")){
                    selectCityImg.setText("Select a city");
                    locationPath = "";
                }else{
                    selectCityImg.setText(selectedCity.getCityName());
                    locationPath = selectedCity.getLocationPath();
                    locationName = selectedCity.getCityName() + "," + selectedCity.getCountryName();
                    stateName = "";
                    Intent intent = new Intent(InitialActivity.this, MainActivity.class);
                    intent.putExtra("locationName", locationName);
                    intent.putExtra("stateName", stateName);
                    intent.putExtra("locationPath", locationPath);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        forecastButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(tiSelectCity.getText()!=null && tiSelectCity.getText().length()!=0){
                    showProgress();
                    executeCall(new CallInterface() {
                        @Override
                        public void doInBackground() {
                            rootLatLonByName = Connector.getConector().getCoordsByCityName(RootLatLonByName.class,tiSelectCity.getText().toString());
                        }

                        @Override
                        public void doInUI() {
                            hideProgress();

                            if(rootLatLonByName!=null){
                                String locationName = rootLatLonByName.name + ", " + rootLatLonByName.country;
                                String stateName = rootLatLonByName.state;
                                String lat = "&lat=" + rootLatLonByName.lat;
                                String lon = "&lon=" + rootLatLonByName.lon;
                                locationPath = lat + lon;
                                Intent intent = new Intent(InitialActivity.this, MainActivity.class);
                                intent.putExtra("locationName", locationName);
                                intent.putExtra("stateName", stateName);
                                intent.putExtra("locationPath", locationPath);
                                startActivity(intent);
                            }else{
                                Toast.makeText(InitialActivity.this, "Location not found", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else{
                    Toast.makeText(InitialActivity.this, "Select a city", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }


}