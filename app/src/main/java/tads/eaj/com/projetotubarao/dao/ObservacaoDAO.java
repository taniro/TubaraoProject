package tads.eaj.com.projetotubarao.dao;

import tads.eaj.com.projetotubarao.model.Observacao;

import java.util.List;

/**
 * Created by Taniro on 01/06/2016.
 * adaptado por Laercio & Filipe 07/06/2016
 */
public interface ObservacaoDAO {
    void inserir(Observacao observacao);
    void atualizar(Observacao observacao);
    List<Observacao> buscar();
}
