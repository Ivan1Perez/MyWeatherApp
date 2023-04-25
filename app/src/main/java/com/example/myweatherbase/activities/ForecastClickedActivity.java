package com.example.myweatherbase.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

public class ForecastClickedActivity extends BaseActivity implements CallInterface {

    private ImageView imageView;
    private TextView tvCityTitle;
    private Button selectCityButton;
    private Button settingsButton;
    private TextView tvTemp;
    private TextView tvEstadoCielo;
    private TextView tvMaxTemp;
    private TextView tvMinTemp;
    private TextView tvDegreesSymbol;
    private TextView cloudsInfo;
    private TextView windInfo;
    private TextView humidityInfo;
    private TextView visibilityInfo;
    private TextView pressureInfo;
    private TextView tempVariationInfo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forecastclicked_element);

        imageView = findViewById(R.id.imageView);
        tvCityTitle = findViewById(R.id.tvCityTitle);
        selectCityButton = findViewById(R.id.selectCityButton);
        settingsButton = findViewById(R.id.settingsButton);
        tvTemp = findViewById(R.id.tvTemp);
        tvEstadoCielo = findViewById(R.id.tvEstadoCielo);
        tvMaxTemp = findViewById(R.id.tvMaxTemp);
        tvMinTemp = findViewById(R.id.tvMinTemp);
        tvDegreesSymbol = findViewById(R.id.tvDegreesSymbol);
        cloudsInfo = findViewById(R.id.cloudsInfo);
        windInfo = findViewById(R.id.windInfo);
        humidityInfo = findViewById(R.id.humidityInfo);
        visibilityInfo = findViewById(R.id.visibilityInfo);
        pressureInfo = findViewById(R.id.pressureInfo);
        tempVariationInfo = findViewById(R.id.tempVariationInfo);

        showProgress();
        executeCall(this);
    }

    @Override
    public void doInBackground() {
        Intent intent = getIntent();
        String fecha = intent.getStringExtra("fecha");
        String dia = intent.getStringExtra("dia");
        String estadoCielo = intent.getStringExtra("estadoCielo");
        String hora = intent.getStringExtra("hora");
        String temp = intent.getStringExtra("temp");
        String min = intent.getStringExtra("min");
        String max = intent.getStringExtra("max");
        String nubosidad = intent.getStringExtra("nubosidad");
        String humedad = intent.getStringExtra("humedad");
        String presionAt = intent.getStringExtra("presionAt");
        String viento = intent.getStringExtra("viento");
        String visibilidad = intent.getStringExtra("visibilidad");
        String variacionTemp = intent.getStringExtra("variacionTemp");
        String weatherIcon = intent.getStringExtra("weatherIcon");
        String stateName = intent.getStringExtra("stateName");



    }

    @Override
    public void doInUI() {
        hideProgress();

        Intent intent = getIntent();
        String weatherIcon = intent.getStringExtra("weatherIcon");
        String locationName = intent.getStringExtra("locationName");

        tvCityTitle.setText(locationName);

//        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + weatherIcon + Parameters.ICON_URL_POST, imageView);


    }

}