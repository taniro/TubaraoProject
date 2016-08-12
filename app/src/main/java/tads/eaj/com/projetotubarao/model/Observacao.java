package tads.eaj.com.projetotubarao.model;

/**
 * Created by VILA on 24/05/2016.
 * teste para commit
 *
 */
public class Observacao {

    private int IdObservacao;
    private long data;
    private int turno;
    private int NPessoa;
    private int LocalTubarao;
    private int Comportamento;
    private String Comentario;
    private Usuario usuario;

    public int getIdObservacao() {
        return IdObservacao;
    }

    public void setIdObservacao(int idObservacao) {
        IdObservacao = idObservacao;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getNPessoa() {
        return NPessoa;
    }

    public void setNPessoa(int NPessoa) {
        this.NPessoa = NPessoa;
    }

    public int getLocalTubarao() {
        return LocalTubarao;
    }

    public void setLocalTubarao(int localTubarao) {
        LocalTubarao = localTubarao;
    }

    public int getComportamento() {
        return Comportamento;
    }

    public void setComportamento(int comportamento) {
        Comportamento = comportamento;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

}
