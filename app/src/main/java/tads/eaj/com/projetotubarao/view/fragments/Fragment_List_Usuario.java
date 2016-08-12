package tads.eaj.com.projetotubarao.view.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import tads.eaj.com.projetotubarao.R;
import tads.eaj.com.projetotubarao.adapter.UsuarioAdapter;
import tads.eaj.com.projetotubarao.dao.UsuarioDAOImpl;
import tads.eaj.com.projetotubarao.model.Usuario;

import java.util.List;

import android.support.v4.app.Fragment;

public class Fragment_List_Usuario extends Fragment implements AdapterView.OnItemClickListener {

    private static final int CODIGO_EDITADO = 987;
    private static final int RESULT_DEU_CERTO = 888;
    private ListView lista;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment_usuario,
                container, false);

        UsuarioDAOImpl bd = new UsuarioDAOImpl(getActivity());
        List<Usuario> listausuario = bd.buscar();

        lista = (ListView) view.findViewById(R.id.minhalista);
        lista.setAdapter(new UsuarioAdapter(getActivity(), listausuario));
        lista.setOnItemClickListener(this);
        return view;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

   /* public void editar(View v) {

        Usuario usuarioselecionado = (Usuario) v.getTag();

        Intent intent = new Intent(getActivity(), CadastraUsuarioActivity.class);
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
                Toast.makeText(getActivity(), "Usuário editado com sucesso!", Toast.LENGTH_SHORT).show();

            }
        }*/

    /*
    É preciso recarregar a lista, pois um item foi editado.

    @Override

    protected void onActivityCreate() {

        UsuarioDAOImpl bd = new UsuarioDAOImpl(getActivity());
        List<Usuario> listaUsuarios = bd.buscar();
        lista = (ListView)getView().findViewById(R.id.minhalista);
        lista.setAdapter(new UsuarioAdapter(getActivity(), listaUsuarios));
        lista.setOnItemClickListener(this);
    }
   */
    }
