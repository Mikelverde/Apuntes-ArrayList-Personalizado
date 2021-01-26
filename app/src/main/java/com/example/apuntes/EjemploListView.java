package com.example.apuntes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.apuntes.adapter.Adaptador_personalizado;

import java.util.ArrayList;
import java.util.List;

public class EjemploListView extends AppCompatActivity {

    ListView listViewNormal,listViewPersonalizada;
    ArrayList<String> ciudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listViewNormal =findViewById(R.id.lstV_normal);
        listViewPersonalizada=findViewById(R.id.listV_personalizada);

        ciudades=new ArrayList<>();
        ciudades.add("Madrid");
        ciudades.add("Berlin");
        ciudades.add("Moscu");
        ciudades.add("New York");
        ciudades.add("Barcelona");

        //para conectar datos y vista necesito un adaptador
        //constructor ArrayAdapter(Context context, int resource, List<T> objects)
        ArrayAdapter arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,ciudades);

        //una vez tenemos el adaptador, lo conectamos con la vista
        listViewNormal.setAdapter(arrayAdapter);

        //para conectar datos y vista necesito un adaptador
        Adaptador_personalizado personalizado=new Adaptador_personalizado(this,R.layout.item_listview_personalizada,ciudades) {
            @Override
            public void onEntrada(Object entrada, View view) {
                TextView nombreCiudad=(TextView) view.findViewById(R.id.txt_nombreCiudad);
                nombreCiudad.setText((CharSequence) entrada);
            }
        };
        //una vez tenemos el adaptador, lo conectamos con la vista
        listViewPersonalizada.setAdapter(personalizado);
    }
}