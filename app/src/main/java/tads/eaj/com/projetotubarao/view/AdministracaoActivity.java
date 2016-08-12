package tads.eaj.com.projetotubarao.view;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import tads.eaj.com.projetotubarao.R;
import tads.eaj.com.projetotubarao.adapter.TabsAdapter;
import tads.eaj.com.projetotubarao.model.Usuario;

/**
 * Created by VILA on 06/06/2016.
 */
public class AdministracaoActivity extends AppCompatActivity {
    private ViewPager viewPager;

    private static final int CODIGO_EDITADO = 987;
    private static final int RESULT_DEU_CERTO = 888;
    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administracao);


        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new TabsAdapter(getSupportFragmentManager()));

        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab().setText("Consulta").setTabListener(new MyTabListener(viewPager, 0)));
        actionBar.addTab(actionBar.newTab().setText("Bolsista").setTabListener(new MyTabListener(viewPager, 1)));


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void novousuario(View v) {
        Intent i = new Intent(this, CadastraUsuarioActivity.class);
        startActivity(i);
    }

    public void consultar(View v) {
        Intent i = new Intent(this, List_ConsultaActivity.class);
        startActivity(i);
    }
    /*public void editar (View v){
        Intent i = new Intent(this, CadastraUsuarioActivity.class);
        startActivity(i);
    }
    */
    public void editar(View v) {

        Usuario usuarioselecionado = (Usuario) v.getTag();

        Intent intent = new Intent(this, CadastraUsuarioActivity.class);
        intent.putExtra("id", usuarioselecionado.getIdUsuario());
        intent.putExtra("nome", usuarioselecionado.getNome());
        intent.putExtra("email", usuarioselecionado.getEmail());
        intent.putExtra("fone", usuarioselecionado.getFone());
        intent.putExtra("matricula", usuarioselecionado.getMatricula());
        intent.putExtra("curso", usuarioselecionado.getCurso());
        startActivityForResult(intent, CODIGO_EDITADO);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_DEU_CERTO) {
            if (requestCode == CODIGO_EDITADO) {
                Toast.makeText(this, "Usuário editado com sucesso!", Toast.LENGTH_SHORT).show();

            }
        }


    }
}

