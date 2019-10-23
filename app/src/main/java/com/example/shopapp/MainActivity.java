package com.example.shopapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private EditText nombre,categoria,cantidad;
private RecyclerView recyclerView;
private Adaptador adaptador;
private List<modeloProducto> modelo= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=findViewById(R.id.idNombreProduct);
        categoria=findViewById(R.id.IdCategory);
        cantidad=findViewById(R.id.idQuanty);


        ConnectionDB db = new ConnectionDB(getApplicationContext());

        modelo = db.enlistarProducto();
        adaptador = new Adaptador(modelo);


        recyclerView= findViewById(R.id.idRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setAdapter(adaptador);
    }
    public void añadirProducto(View view){
        ConnectionDB con = new ConnectionDB(this);
        SQLiteDatabase db = con.getWritableDatabase();
        ContentValues valu = new ContentValues();
        valu.put("nombreproducto",nombre.getText().toString());
        valu.put("categoria",categoria.getText().toString());
        valu.put("cantidad",cantidad.getText().toString());


        long cantidad =db.insert("producto",null,valu);
        if(cantidad>0){
            Toast.makeText(this, "sii se agrego", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(this, "hay un error", Toast.LENGTH_SHORT).show();

    }
}
