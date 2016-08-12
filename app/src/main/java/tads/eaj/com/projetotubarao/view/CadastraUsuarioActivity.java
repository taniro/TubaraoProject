package tads.eaj.com.projetotubarao.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import tads.eaj.com.projetotubarao.R;
import tads.eaj.com.projetotubarao.dao.UsuarioDAOImpl;
import tads.eaj.com.projetotubarao.model.Usuario;

import java.io.Serializable;

public class CadastraUsuarioActivity extends AppCompatActivity implements Serializable{

    private Usuario usuario = new Usuario();
    private EditText NomeEdit;
    private EditText EmailEdit;
    private EditText FoneEdit;
    private EditText MatriculaEdit;
    private EditText CursoEdit;
    private int AtivoEdit;
    private int TipoEdit;
    private Button salvarBt;
    private Button atualizarBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_usuario);

        NomeEdit = (EditText) findViewById(R.id.nome);
        EmailEdit = (EditText) findViewById(R.id.email);
        FoneEdit = (EditText) findViewById(R.id.fone);
        MatriculaEdit = (EditText) findViewById(R.id.matricula);
        CursoEdit = (EditText) findViewById(R.id.curso);
        salvarBt = (Button) findViewById(R.id.btnsalvar);
        atualizarBt = (Button) findViewById(R.id.btnatualizar);

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                usuario.setIdUsuario(bundle.getInt("id"));
                usuario.setNome(bundle.getString("nome"));
                usuario.setFone(bundle.getString("fone"));
                usuario.setMatricula(bundle.getString("matricula"));
                usuario.setCurso(bundle.getString("curso"));
                usuario.setAtivo(bundle.getInt("ativo"));
                usuario.setTipo(bundle.getInt("tipo"));

                NomeEdit.setText(usuario.getNome());
                EmailEdit.setText(usuario.getEmail());
                FoneEdit.setText(usuario.getFone());
                MatriculaEdit.setText(usuario.getMatricula());
                CursoEdit.setText(usuario.getCurso());

                salvarBt.setVisibility(View.GONE);
                atualizarBt.setVisibility(View.VISIBLE);

            }
        }
    }

    public void salvarUsuario(View view) {

        CheckBox ativo = (CheckBox) findViewById(R.id.ativo);
        CheckBox tipo = (CheckBox) findViewById(R.id.tipo);

        if (ativo.isChecked()) {
            AtivoEdit = 1;
        } else {
            AtivoEdit = 0;
        }
        if (tipo.isChecked()) {
            TipoEdit = 1;
        } else {
            TipoEdit = 0;

            usuario.setNome(NomeEdit.getText().toString());
            usuario.setTipo(TipoEdit);
            usuario.setEmail(EmailEdit.getText().toString());
            usuario.setFone(FoneEdit.getText().toString());
            usuario.setMatricula(MatriculaEdit.getText().toString());
            usuario.setCurso(CursoEdit.getText().toString());
            usuario.setAtivo(AtivoEdit);

            UsuarioDAOImpl bd = new UsuarioDAOImpl(this);
            bd.inserir(usuario);
            setResult(RESULT_OK);
            finish();
        }
    }
    public void atualizarUsuario(View view) {

        CheckBox ativo = (CheckBox) findViewById(R.id.ativo);
        CheckBox tipo = (CheckBox) findViewById(R.id.tipo);

        if (ativo.isChecked()) {
            AtivoEdit = 1;
        } else {
            AtivoEdit = 0;
        }
        if (tipo.isChecked()) {
            TipoEdit = 1;
        } else {
            TipoEdit = 0;

            usuario.setNome(NomeEdit.getText().toString());
            usuario.setTipo(TipoEdit);
            usuario.setEmail(EmailEdit.getText().toString());
            usuario.setFone(FoneEdit.getText().toString());
            usuario.setMatricula(MatriculaEdit.getText().toString());
            usuario.setCurso(CursoEdit.getText().toString());
            usuario.setAtivo(AtivoEdit);

            UsuarioDAOImpl bd = new UsuarioDAOImpl(this);
            bd.atualizar(usuario);
            setResult(RESULT_OK);
            finish();
        }
    }
}