//package com.example.myweatherbase.activities;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class InfoDiaRepository {
//
//    private List<InfoDia> infoDiaList;
//    private static InfoDiaRepository instance;
//
//    private InfoDiaRepository(){
//        infoDiaList = new ArrayList<>();
//        infoDiaList.add(new InfoDia("", "García Pérez", R.mipmap.ic_actor_foreground));
//        infoDiaList.add(new InfoDia("Luis", "García Pérez", R.mipmap.ic_albanyil_foreground));
//        infoDiaList.add(new InfoDia("Carlos", "García Pérez", R.mipmap.ic_banquero_foreground));
//        infoDiaList.add(new InfoDia("Miguel", "García Pérez", R.mipmap.ic_cocinero_foreground));
//        infoDiaList.add(new InfoDia("Pepe", "García Pérez", R.mipmap.ic_estudiante_foreground));
//        infoDiaList.add(new InfoDia("Alfonso", "García Pérez", R.mipmap.ic_instagramer_foreground));
//        infoDiaList.add(new InfoDia("Rubén", "García Pérez", R.mipmap.ic_pintor_foreground));
//        infoDiaList.add(new InfoDia("Alejandro", "García Pérez", R.mipmap.ic_policia_foreground));
//        infoDiaList.add(new InfoDia("Ivan", "García Pérez", R.mipmap.ic_politico_activo_foreground));
//    }
//
//    public static InfoDiaRepository getInstance(){
//        if(instance==null)
//            instance = new InfoDiaRepository();
//
//        return instance;
//    }
//
//}
