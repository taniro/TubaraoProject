package tads.eaj.com.projetotubarao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;


//import com.example.vila.biblioteca.Banco.LivroDAOImpl;
//import com.example.vila.biblioteca.Model.Livro;
import tads.eaj.com.projetotubarao.R;
import tads.eaj.com.projetotubarao.model.Usuario;
import java.util.List;

/**
 * Created by Taniro on 01/06/2016.
 * adaptado por Laercio & Filipe 07/06/2016
 */
public class UsuarioAdapter extends BaseAdapter {

    private Context context;
    private List<Usuario> listaUsuario;

    public UsuarioAdapter(Context context, List<Usuario> listaUsuario){
        this.context = context;
        this.listaUsuario = listaUsuario;
    }

    @Override
    public int getCount() {
        return listaUsuario.size();
    }

    @Override
    public Object getItem(int position) {
        return listaUsuario.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaUsuario.get(position).getIdUsuario();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.infla_usuario, null);

        TextView tv = (TextView) layout.findViewById(R.id.titulo);
        tv.setText(listaUsuario.get(position).getNome());


        ImageButton editarBt = ( ImageButton) layout.findViewById(R.id.editar);
        /*
        Foi setado nesse botão uma "tag"
        Uma tag é um objeto que está ligado a esse botão
        Cada botão foi ligado com seu respectivo livro.
         */
        editarBt.setTag(listaUsuario.get(auxPosition));

        /*
        Esse botão possui uma outra implementação para exemplificar o uso do onclicklistener


        ImageButton deletarBt = (ImageButton) layout.findViewById(R.id.deletar);
        deletarBt.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                UsuarioDAOImpl bd = new UsuarioDAOImpl(context);
                bd.deletar(listaUsuario.get(auxPosition));

                layout.setVisibility(View.GONE);
            }
        });
        Correção de um bug no android que impede o click em uma lista contendo botões.
        */
        layout.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        return layout;
    }
}
