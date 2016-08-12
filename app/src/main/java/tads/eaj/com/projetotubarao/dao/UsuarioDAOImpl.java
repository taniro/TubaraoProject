package tads.eaj.com.projetotubarao.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import tads.eaj.com.projetotubarao.util.TubaraoDB;
import tads.eaj.com.projetotubarao.model.Usuario;

/**
 * Created by Taniro on 01/06/2016.
 * Adaptado por Laércio & Filipe 07/06/2016
 */

public class UsuarioDAOImpl implements UsuarioDAO {

    private SQLiteDatabase bd;

    public UsuarioDAOImpl(Context context) {
        TubaraoDB auxBd = new TubaraoDB(context);
        bd = auxBd.getWritableDatabase();
    }

    public void inserir(Usuario usuario) {

        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("tipo", usuario.getTipo());
        valores.put("email", usuario.getEmail());
        valores.put("fone", usuario.getFone());
        valores.put("matricula", usuario.getMatricula());
        valores.put("curso", usuario.getCurso());
        valores.put("ativo", usuario.getAtivo());
        bd.insert("usuario", null, valores);
        bd.close();
    }

    public void atualizar(Usuario usuario) {
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("tipo", usuario.getTipo());
        valores.put("email", usuario.getEmail());
        valores.put("fone", usuario.getFone());
        valores.put("matricula", usuario.getMatricula());
        valores.put("curso", usuario.getCurso());
        valores.put("ativo", usuario.getAtivo());

        bd.update("usuario", valores, "_id = ?", new String[]{"" + usuario.getIdUsuario()});
        bd.close();
    }


    //public void deletar(Livro livro){bd.delete("livro", "_id = "+livro.getId_livro(), null);
    //}


    public List<Usuario> buscar() {
        List<Usuario> list = new ArrayList<Usuario>();
        String[] colunas = new String[]{"_id", "nome", "email", "fone", "matricula", "curso"};

        Cursor cursor = bd.query("usuario", colunas, null, null, null, null, "nome ASC");

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            do {

                Usuario l = new Usuario();
                l.setIdUsuario(cursor.getInt(0));
                l.setNome(cursor.getString(1));
                l.setEmail(cursor.getString(2));
                l.setFone(cursor.getString(3));
                l.setMatricula(cursor.getString(4));
                l.setCurso(cursor.getString(5));
                list.add(l);

            } while (cursor.moveToNext());
        }

        bd.close();
        return (list);
    }
    //METODO IMPLEMENTADO QUE RECEBE DUAS STRINGS E RETORNA UM USUARIO
    @Override
    public Usuario buscarUser(String matricula) {

        Cursor cursor = bd.rawQuery("SELECT * FROM USUARIO WHERE MATRICULA=? AND ATIVO=?;", new String[]{matricula,"1"});

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            Usuario l = new Usuario();
            l.setIdUsuario(cursor.getInt(0));
            l.setNome(cursor.getString(1));
            l.setTipo(cursor.getInt(2));
            l.setEmail(cursor.getString(3));
            l.setFone(cursor.getString(4));
            l.setMatricula(cursor.getString(5));
            l.setCurso(cursor.getString(6));
            l.setAtivo(cursor.getInt(7));
            cursor.close();
            bd.close();
            return l;
        } else {
            return null;
        }
    }
}