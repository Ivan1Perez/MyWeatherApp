package com.example.myweatherbase.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.API.Connector;
import com.example.myweatherbase.R;
import com.example.myweatherbase.base.BaseActivity;
import com.example.myweatherbase.base.CallInterface;

public class MainActivity extends BaseActivity implements CallInterface {

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

        root = Connector.getConector().get(Root.class,"&lat=39.5877978&lon=-0.5382208");
    }

    // Una vez ya se ha realizado la llamada, ocultamos la barra de progreso y presentamos los datos
    @Override
    public void doInUI() {
        hideProgress();

        InfoDiaRecyclerView myRecyclerViewAdapter = new InfoDiaRecyclerView(this, root);
        recyclerView.setAdapter(myRecyclerViewAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

    }


}