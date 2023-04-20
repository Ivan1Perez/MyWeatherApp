package com.example.myweatherbase.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableRow;

import com.example.myweatherbase.R;

public class ForecastClickedActivity extends AppCompatActivity {

    private Root root;
//    private final LayoutInflater inflater;

//    public ForecastClickedActivity(Context context, Root root) {
//        this.root = root;
//        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forecastclicked_element);


    }

}