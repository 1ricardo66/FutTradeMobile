package br.com.ricardofelix.futtrademobile.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String NAME_DB = "FUT_TRADE";
    public static String Player_Table = "player";


    public DbHelper(@Nullable Context context) {
        super(context, NAME_DB, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " +Player_Table+
                "(id INTEGER PRIMARY KEY, name VARCHAR(255), buyPrice INTEGER NOT NULL, sellPrice INTEGER NOT NULL, profit REAL); ";

        try{
            db.execSQL(sql);
            Log.d("INFO-DB","Sucesso ao Criar Tabela");

        }catch (Exception e){
            Log.d("ERROR-DB",e.getMessage());
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
