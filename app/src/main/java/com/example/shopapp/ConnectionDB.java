package com.example.shopapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ConnectionDB extends SQLiteOpenHelper {
    public ConnectionDB(@Nullable Context context) {
        super(context, "tiendadb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase tiendadb) {
        tiendadb.execSQL("Create Table producto("+"nombreproducto text not null,"+
                "categoria text not null,"+
                "cantidad integer not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public List<modeloProducto> enlistarProducto(){
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM  producto",null);
        List<modeloProducto> listAux = new ArrayList<>();
        if (cursor.moveToFirst()){
            do {
                listAux.add(new modeloProducto(cursor.getString(0),cursor.getString(1),cursor.getInt(2)));
            }while (cursor.moveToNext());
        }
        return listAux;

    }
}
