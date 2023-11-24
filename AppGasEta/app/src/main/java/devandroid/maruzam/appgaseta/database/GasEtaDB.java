package devandroid.maruzam.appgaseta.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

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
}
