package tads.eaj.com.projetotubarao.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Taniro on 01/06/2016.
 * adaptado por Laercio & Filipe 07/06/2016
 */

public class TubaraoDB extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "tubaraoDB";
    private static final int VERSAO_BANCO = 1;

    public TubaraoDB(Context c) {
        super(c, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       db.execSQL("create table usuario(_id integer primary key autoincrement," +
                "nome text not null," +
                "tipo int not null," +
                "email text not null," +
                "fone text not null," +
                "matricula text not null," +
                "curso text not null," +
                "ativo int);");

        db.execSQL("create table observacao(_idObservacao integer primary key autoincrement, " +
                "data long not null, " +
                "turno int not null, " +
                "npessoa int not null," +
                "local int not null," +
                "comportamento int not null , " +
                "comentario int);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table bolsista;");
        onCreate(db);
    }
}
