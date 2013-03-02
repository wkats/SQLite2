package com.wkats.sqlite2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite_Handler extends SQLiteOpenHelper {

	public SQLite_Handler(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	
	//Inserta un registro
	@SuppressWarnings("unused")
	private void insertar(String[] datosUsuario){
	SQLiteDatabase db = this.getReadableDatabase();
	//Añadimos un nuevo contentValue para cada columna que queramos rellenar
	ContentValues contentValues = new ContentValues();
	
	contentValues.put("nombre", datosUsuario[0]);
	contentValues.put("contraseña", datosUsuario[1]);
	contentValues.put("tipoUsuario", datosUsuario[2]);
	//Insertamos en la tabla usuario
	db.insertOrThrow("usuario", null, contentValues);
	return;
	}
	
	//Obtenemos un cursor para una query simple.
	//El cursor nos ayudará a navegar a traves de los resultados de la query
	private Cursor getCursor(){
		String campos[]={"_id", "nombre","contraseña","tipo"};
	SQLiteDatabase db = this.getReadableDatabase();
	Cursor cursor = db.query("usuario", campos, null, null, null, null, null);
	//this.startManagingCursor(cursor);
	return cursor;
	}
	
	public String[][] datos(){
		String devolver[][];
		Cursor temp=this.getCursor();
		devolver= new String[temp.getColumnCount()][temp.getCount()];
			for(int i=0;temp.isAfterLast();i++){
					devolver[i][0]=""+temp.getInt(0);
					devolver[i][1]=temp.getString(1);
					devolver[i][2]=temp.getString(2);
					devolver[i][3]=temp.getString(3);
		}
		return devolver;
	}

}
