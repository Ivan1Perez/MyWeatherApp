package com.example.myweatherbase.activities;

import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myweatherbase.R;
import com.example.myweatherbase.base.ImageDownloader;
import com.example.myweatherbase.base.Parameters;

import java.util.Date;

public class InfoDiaRecyclerView extends RecyclerView.Adapter<InfoDiaRecyclerView.ViewHolder> {

    private String locationName;
    private String stateName;
    private Root root;
    private final LayoutInflater inflater;

    public InfoDiaRecyclerView(Context context, Root root, String locationName, String stateName) {
        this.root = root;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.locationName = locationName;
        this.stateName = stateName;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.simple_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String estadoCielo = root.getList().get(position).getWeather().get(0).getDescription();
        String estadoCieloCapitalizado = estadoCielo.substring(0, 1).toUpperCase() + estadoCielo.substring(1);
        String fechaCompleta = root.list.get(position).getDt_txt();
        String horaMinutos = fechaCompleta.substring(11, 16);
        String nubosidad = root.list.get(position).clouds.all + "%";
        String humedad = root.list.get(position).main.humidity + "%";
        String presionAt = root.list.get(position).main.pressure + " hPa";
        String viento = root.list.get(position).wind.speed + " km/h";
        String visibilidad = root.list.get(position).visibility + " km";
        String variacionTemp = root.list.get(position).main.temp_kf + "ºC/h";
        String weatherIcon = root.list.get(position).weather.get(0).icon;

        ImageDownloader.downloadImage(Parameters.ICON_URL_PRE + weatherIcon + Parameters.ICON_URL_POST, holder.imageView);

        Date date = new Date((long)root.list.get(position).dt*1000);
        SimpleDateFormat dateDayOfWeek = new SimpleDateFormat("dd MMMM");
        SimpleDateFormat dateDay = new SimpleDateFormat("EEE");
        holder.tvFecha.setText(dateDayOfWeek.format(date));
        holder.tvDia.setText(dateDay.format(date) + ",");
        holder.tvEstadoCielo.setText(estadoCieloCapitalizado);
        holder.tvHora.setText(horaMinutos);
        holder.tvTemp.setText("Temp: "+((String.valueOf(root.getList().get(position).main.temp).length()>=3)?String.valueOf(root.getList().get(position).main.temp).substring(0,2):root.getList().get(position).main.temp)+"º");
        holder.tvMin.setText("Min: "+((String.valueOf(root.getList().get(position).main.temp_min).length()>=3)?String.valueOf(root.getList().get(position).main.temp_min).substring(0,2):root.getList().get(position).main.temp_min)+"º");
        holder.tvMax.setText("Max: "+((String.valueOf(root.getList().get(position).main.temp_max).length()>=3)?String.valueOf(root.getList().get(position).main.temp_max).substring(0,2):root.getList().get(position).main.temp_max)+"º");

        if(position%2==0){
            holder.itemView.setBackgroundColor(ContextCompat.getColor(inflater.getContext(), R.color.lightblue));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(inflater.getContext(), R.color.white));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ForecastClickedActivity.class);
                intent.putExtra("fecha", holder.tvFecha.getText().toString());
                intent.putExtra("dia", holder.tvDia.getText().toString());
                intent.putExtra("estadoCielo", holder.tvEstadoCielo.getText().toString());
                intent.putExtra("hora", holder.tvHora.getText().toString());
                intent.putExtra("temp", holder.tvTemp.getText().toString());
                intent.putExtra("min", holder.tvMin.getText().toString());
                intent.putExtra("max", holder.tvMax.getText().toString());
                intent.putExtra("nubosidad", nubosidad);
                intent.putExtra("humedad", humedad);
                intent.putExtra("presionAt", presionAt);
                intent.putExtra("viento", viento);
                intent.putExtra("visibilidad", visibilidad);
                intent.putExtra("variacionTemp", variacionTemp);
                intent.putExtra("weatherIcon", weatherIcon);
                intent.putExtra("locationName", locationName);
                intent.putExtra("stateName", stateName);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return root.getList().size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvEstadoCielo ;
        private TextView tvDia;
        private TextView tvFecha;
        private TextView tvHora;
        private ImageView imageView;
        private TextView tvTemp;
        private TextView tvMin;
        private TextView tvMax;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvEstadoCielo = itemView.findViewById(R.id.textViewEstadoCielo);
            tvDia = itemView.findViewById(R.id.textViewDia);
            tvFecha = itemView.findViewById(R.id.textViewFecha);
            tvHora = itemView.findViewById(R.id.textViewHora);
            tvTemp = itemView.findViewById(R.id.textViewTemp);
            tvMin = itemView.findViewById(R.id.textViewMaxTemp);
            tvMax = itemView.findViewById(R.id.textViewMinTemp);
            imageView = itemView.findViewById(R.id.imageView);

        }

    }
}
