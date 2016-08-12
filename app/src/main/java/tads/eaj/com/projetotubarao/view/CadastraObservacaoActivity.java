package tads.eaj.com.projetotubarao.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import tads.eaj.com.projetotubarao.R;
import tads.eaj.com.projetotubarao.dao.ObservacaoDAOImpl;
import tads.eaj.com.projetotubarao.model.Observacao;

import org.joda.time.DateTime;

public class CadastraObservacaoActivity extends AppCompatActivity {

    private Observacao observacao = new Observacao();
    private long Data;
    private int Turno;
    private EditText PessoasEdit;
    private int LocalEdit;
    private EditText ComentarioEdit;
    private int ComportamentoEdit;
    private Button salvarBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observacao);

        // Aqui atribuimos os valores do xml às respectivas variáves da activity
        PessoasEdit = (EditText) findViewById(R.id.npessoa);
        ComentarioEdit = (EditText) findViewById(R.id.comentarios);

    }

    public void confirma(View v) {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setIcon(R.drawable.tubarao);
        alerta.setTitle("Observação");
        alerta.setMessage("O número de pessoas é " + PessoasEdit.getText() + "\nO loocal do tubarão é " + LocalEdit + "\nO comportamento é " + ComportamentoEdit);
        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                DateTime dateTime = new DateTime();
                long Data = dateTime.toDate().getTime();
                int hour = dateTime.getHourOfDay();

                // condição para atribuir turno de observação
                if (hour < 11) {
                    Turno = 1;
                } else if (hour >= 12 && hour < 17) {
                    Turno = 2;
                } else {
                    Turno = 3;
                }

                RadioGroup rg = (RadioGroup) findViewById(R.id.radiogrupo);
                if (R.id.rbparado == rg.getCheckedRadioButtonId())
                    ComportamentoEdit = 0;
                else
                    ComportamentoEdit = 1;

                observacao.setData(Data);
                observacao.setTurno(Turno);
                observacao.setNPessoa(Integer.parseInt(PessoasEdit.getText().toString()));
                observacao.setLocalTubarao(LocalEdit);
                observacao.setComportamento(ComportamentoEdit);
                observacao.setComentario(ComentarioEdit.getText().toString());
                ObservacaoDAOImpl bd = new ObservacaoDAOImpl(getApplicationContext());
                bd.inserir(observacao);
                setResult(RESULT_OK);
                finish();

                Toast.makeText(CadastraObservacaoActivity.this, "Observação cadastrada com sucesso!", Toast.LENGTH_LONG).show();

            }
        });
        alerta.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(CadastraObservacaoActivity.this, "Verifique os dados", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog criaalerta = alerta.create();
        criaalerta.show();
    }

    //Método para, através da imagem, indicar o local do tubarão.
    public void clicaImagem(View v) {
        ImageButton ib = (ImageButton) findViewById(v.getId());

        if (ib.getId() == R.id.image1) {
            LocalEdit = 1;
        } else if (ib.getId() == R.id.image2) {
            LocalEdit = 2;
        } else if (ib.getId() == R.id.image3) {
            LocalEdit = 3;
        } else if (ib.getId() == R.id.image4) {
            LocalEdit = 4;
        } else if (ib.getId() == R.id.image5) {
            LocalEdit = 5;
        } else if (ib.getId() == R.id.image6) {
            LocalEdit = 6;
        } else if (ib.getId() == R.id.image7) {
            LocalEdit = 7;
        } else if (ib.getId() == R.id.image8) {
            LocalEdit = 8;
        } else if (ib.getId() == R.id.image9) {
            LocalEdit = 9;
        }
    }
}