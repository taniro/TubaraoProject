package tads.eaj.com.projetotubarao.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import tads.eaj.com.projetotubarao.R;
import tads.eaj.com.projetotubarao.adapter.ConsultaAdapter;
import tads.eaj.com.projetotubarao.dao.ObservacaoDAOImpl;
import tads.eaj.com.projetotubarao.model.Observacao;

import java.util.List;

    public class List_ConsultaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

        private static final int CODIGO_EDITADO = 987;
        private ListView lista;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_lista_consulta);

            ObservacaoDAOImpl bd = new ObservacaoDAOImpl(this);
            List<Observacao> listaObservacao = bd.buscar();

            lista = (ListView) findViewById(R.id.consultalista);
            lista.setAdapter(new ConsultaAdapter(this, listaObservacao));
            lista.setOnItemClickListener(this);

        }


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }
    }

