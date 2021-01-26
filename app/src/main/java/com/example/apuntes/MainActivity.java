package com.example.apuntes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ir_pantallas(View view){
        switch (view.getId()){
            case (R.id.btn_listView):
                visualizarActivity(EjemploListView.class);
        }

    }

    private void visualizarActivity(Class aClass) {
        Intent intent=new Intent(this, aClass);
        startActivity(intent);
    }
}