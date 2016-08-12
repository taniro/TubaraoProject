package tads.eaj.com.projetotubarao.dao;

import tads.eaj.com.projetotubarao.model.Usuario;

import java.util.List;

/**
 * Created by Taniro on 01/06/2016.
 * adaptado por Laercio & Filipe 07/06/2016
 */
public interface UsuarioDAO {
    void inserir(Usuario usuario);
    void atualizar(Usuario usuario);
    List<Usuario> buscar();
    Usuario buscarUser(String matricula);
}
