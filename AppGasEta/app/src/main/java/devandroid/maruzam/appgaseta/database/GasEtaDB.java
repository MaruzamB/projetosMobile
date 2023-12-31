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

    private static final String DB_NAME = "gaseta.db";
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
                "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nomeCombustivel TEXT, " +
                        "precoCombustivel REAL, " +
                        "recomendacao TEXT)";

        String sqlTabelaVeiculo =
                "CREATE TABLE Veiculo (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "nomeCarro TEXT, " +
                        "placaCarro REAL)";


        db.execSQL(sqlTabela);
        db.execSQL(sqlTabelaVeiculo);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }

    public void salvarObjeto(String tabela, ContentValues dados){

        db.insert(tabela, null,dados);

    }
    public List<Combustivel> listarDados(){

        List<Combustivel> lista = new ArrayList<>();

        Combustivel registro;

        String querySql = "SELECT * FROM Combustivel";

        cursor = db.rawQuery(querySql,null);

        if(cursor.moveToFirst()){

            do{

                registro = new Combustivel();

                registro.setId(cursor.getInt(0));
                registro.setNomeCombustivel(cursor.getString(1));
                registro.setPrecoCombustivel(cursor.getDouble(2));
                registro.setRecomendacao(cursor.getString(3));

                lista.add(registro);

            }while (cursor.moveToNext());

        }else {

        }

        return lista;
    }

    public void alterarObjeto(String tabela, ContentValues dados){

        //ID do registro a ser alterado
        //update TABLE set campo = npvp dado WHERE id=?

        int id = dados.getAsInteger("id");

        db.update(tabela,dados,"id=?",
                new String[]{Integer.toString(id)});

    }

    public void deletarObjeto(String tabela, int id){

        //ID do registro a ser alterado
        //delete from TABLE  WHERE id=?

        db.delete(tabela,"id=?",
                new String[]{Integer.toString(id)});

    }



}
