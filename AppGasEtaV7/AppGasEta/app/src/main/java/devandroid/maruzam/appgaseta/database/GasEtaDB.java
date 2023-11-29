package devandroid.maruzam.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import devandroid.maruzam.appgaseta.model.Combustivel;

public class GasEtaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta_db";

    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabela =
                "CREATE TABLE Combustivel(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nomeCombustivel TEXT, " +
                        "precoCombustivel REAL, " +
                        "recomendacao TEXT)";

        db.execSQL(sqlTabela);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public void salvarObjeto(String tabela, ContentValues dados) {

        db.insert(tabela, null, dados);

    }

   

    //método para listar os dados

    public List<Combustivel> listarDados(){

        List<Combustivel> lista = new ArrayList<>();

        Combustivel registro;

        String querySql = "SELECT * fROM Combustivel";

        cursor = db.rawQuery(querySql,null);

        if (cursor.moveToFirst()){

            do{
                registro = new Combustivel();

                registro.setId(cursor.getInt(0));
                registro.setNomeCombustivel(cursor.getString(1));
                registro.setPrecoCombustivel(cursor.getDouble(2));
                registro.setRecomendacao(cursor.getString(3));
                lista.add(registro);
            }while (cursor.moveToNext());
        }else {}

        return lista;
    }


}
