package tads.eaj.com.projetotubarao.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import tads.eaj.com.projetotubarao.util.TubaraoDB;
import tads.eaj.com.projetotubarao.model.Observacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taniro on 01/06/2016.
 * Adaptado por Laércio & Filipe 07/06/2016
 */
public class ObservacaoDAOImpl implements ObservacaoDAO {
      private SQLiteDatabase bd;

    public ObservacaoDAOImpl(Context context) {
        TubaraoDB auxBd = new TubaraoDB(context);
        bd = auxBd.getWritableDatabase();
    }

    public void inserir(Observacao observacao) {
        ContentValues valores = new ContentValues();
        valores.put("data",observacao.getData());//1
        valores.put("turno",observacao.getTurno());//2
        valores.put("npessoa", observacao.getNPessoa());//3
        valores.put("local", observacao.getLocalTubarao());//4
        valores.put("comportamento", observacao.getComportamento());//5
        valores.put("comentario", observacao.getComentario());//6

        bd.insert("observacao", null, valores);
        bd.close();
    }

    public void atualizar(Observacao observacao) {
        ContentValues valores = new ContentValues();
        valores.put("data",observacao.getData());
        valores.put("turno",observacao.getTurno());
        valores.put("npessoa", observacao.getNPessoa());
        valores.put("local", observacao.getLocalTubarao());
        valores.put("comportamento", observacao.getComportamento());
        valores.put("comentario", observacao.getComentario());

        bd.update("observacao", valores, "_id = ?", new String[]{"" + observacao.getIdObservacao()});
        bd.close();
    }

    public List<Observacao> buscar() {
        List<Observacao> list = new ArrayList<Observacao>();
        String[] colunas = new String[]{"id", "npessoa", "local", "comportamento", "comentario"};

        Cursor cursor = bd.query("usuario", colunas, null, null, null, null, "nome ASC");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {
                Observacao l = new Observacao();
                l.setNPessoa(cursor.getInt(0));
                l.setLocalTubarao(cursor.getInt(1));
                l.setComportamento(cursor.getInt(2));
                l.setComentario(cursor.getString(3));
                list.add(l);

            } while (cursor.moveToNext());
        }
        bd.close();
        return (list);

    }
}