package com.example.myweatherbase.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;

public class MainActivity extends BaseActivity implements CallInterface, View.OnClickListener {

    private String locationName;
    private String stateName;

    private Root root;
    private RecyclerView recyclerView;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("root",root);
    }
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Mostramos la barra de progreso y ejecutamos la llamada a la API
        showProgress();
        executeCall(this);

    }

    // Realizamos la llamada y recogemos los datos en un objeto Root
    @Override
    public void doInBackground() {
        Intent intent = getIntent();
        String locationPath = intent.getStringExtra("locationPath");

        root = Connector.getConector().get(Root.class,locationPath);

    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {
        hideProgress();

        InfoDiaRecyclerView myRecyclerViewAdapter = new InfoDiaRecyclerView(this, root, locationName, stateName,this);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }


    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(),"Has clicado",Toast.LENGTH_SHORT).show();
    }
}