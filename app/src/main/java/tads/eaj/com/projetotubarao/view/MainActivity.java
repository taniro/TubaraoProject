package tads.eaj.com.projetotubarao.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import tads.eaj.com.projetotubarao.R;
import tads.eaj.com.projetotubarao.dao.UsuarioDAOImpl;
import tads.eaj.com.projetotubarao.model.Usuario;

public class MainActivity extends AppCompatActivity {

    private EditText MatriculaEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario e = new Usuario();
        e.setIdUsuario(2);
        e.setNome("Viviane Medeiros");
        e.setTipo(1);
        e.setEmail("vivianemedeiros.eaj@email.com");
        e.setFone("988993964");
        e.setAtivo(1);
        e.setMatricula("1598");
        e.setCurso("Veterinária");
        UsuarioDAOImpl bd = new UsuarioDAOImpl(this);
        bd.inserir(e);

/*
      Usuario f = new Usuario();
        f.setIdUsuario(2);
        f.setNome("Taniro Chacon");
        f.setTipo(0);
        f.setEmail("tanirocr@gmail.com");
        f.setFone("981425191");
        f.setAtivo(1);
        f.setMatricula("5191");
        f.setCurso("Professor");
        UsuarioDAOImpl bd = new UsuarioDAOImpl(this);
        bd.inserir(f);
*/

  }
    public void confirmalogin(View v) {
        MatriculaEdit = (EditText) findViewById(R.id.senha);

        UsuarioDAOImpl bd = new UsuarioDAOImpl(this);
        Usuario user;
        user = bd.buscarUser(MatriculaEdit.getText().toString());//metodo implementado
        //Log.i("Vei", String.valueOf(user.getTipo()));

        if (user == null) {//se o retorno for null , não existe o usuario no banco
            Toast.makeText(this, "Verifique os dados e preencha novamente!", Toast.LENGTH_SHORT).show();

        } else if (user.getTipo()== 1) {//se o usuario retornado for do tipo 1 é coordenador(a)
            Intent i = new Intent(this,AdministracaoActivity.class);
            startActivity(i);
        } else {//caso contrario é bolsita
            Intent i = new Intent(this,CadastraObservacaoActivity.class);
            startActivity(i);
        }
    }
}
