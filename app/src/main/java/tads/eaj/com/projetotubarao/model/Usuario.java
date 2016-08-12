package tads.eaj.com.projetotubarao.model;

import java.util.List;

/**
 * Created by VILA on 31/05/2016.
 */
public class Usuario {

    private int idUsuario;
    private String Nome;
    private int Tipo;
    private String Email;
    private String Fone;
    private int Ativo;
    private String Matricula;
    private String Curso;
    private List<Observacao> listaObservacao;


    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public java.lang.String getNome() {
        return Nome;
    }

    public void setNome(java.lang.String nome) {
        Nome = nome;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int tipo) {
        Tipo = tipo;
    }

    public java.lang.String getEmail() {
        return Email;
    }

    public void setEmail(java.lang.String email) {
        Email = email;
    }

    public java.lang.String getFone() {
        return Fone;
    }

    public void setFone(java.lang.String fone) {
        Fone = fone;
    }

    public int getAtivo() { return Ativo;  }

    public void setAtivo(int ativo) { Ativo = ativo; }

    public java.lang.String getMatricula() {
        return Matricula;
    }

    public void setMatricula(java.lang.String matricula) {
        Matricula = matricula;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String curso) {
        Curso = curso;
    }

    public List<Observacao> getListaObservacao() {
        return listaObservacao;
    }

    public void setListaObservacao(List<Observacao> listaObservacao) {
        this.listaObservacao = listaObservacao;
    }
}