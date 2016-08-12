package tads.eaj.com.projetotubarao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import tads.eaj.com.projetotubarao.R;
import tads.eaj.com.projetotubarao.model.Observacao;

import java.util.List;

/**
 * Created by Taniro on 01/06/2016.
 * Adaptado por Laércio e Filipe 16/05/2016
 */
public class ConsultaAdapter extends BaseAdapter {

    private Context context;
    private List<Observacao> listaObservacao;

    public ConsultaAdapter(Context context, List<Observacao> listaObservacao){
        this.context = context;
        this.listaObservacao = listaObservacao;
    }

    @Override
    public int getCount() {
        return listaObservacao.size();
    }

    @Override
    public Object getItem(int position) {
        return listaObservacao.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listaObservacao.get(position).getIdObservacao();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int auxPosition = position;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.infla_lista_consulta, null);

        TextView tv = (TextView) layout.findViewById(R.id.datainicio);
        tv.setText((int) listaObservacao.get(position).getData());


        ImageButton editarBt = ( ImageButton) layout.findViewById(R.id.editar);
        /*
        Foi setado nesse botão uma "tag"
        Uma tag é um objeto que está ligado a esse botão
        Cada botão foi ligado com seu respectivo livro.
         */
        editarBt.setTag(listaObservacao.get(auxPosition));

        /*
        Esse botão possui uma outra implementação para exemplificar o uso do onclicklistener
         */

              /*
        Correção de um bug no android que impede o click em uma lista contendo botões.
        */
        layout.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        return layout;
    }
}
