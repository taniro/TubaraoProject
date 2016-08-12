package tads.eaj.com.projetotubarao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import tads.eaj.com.projetotubarao.view.MainActivity;

/**
 * Created by VILA on 03/06/2016.
 */
public class SplashScreenActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //dekat de 2 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Inicia a MainActitivity
                startActivity(new Intent(getBaseContext(),MainActivity.class));
                //Fecha a activitity da splash
                finish();
            }
        },3000);
    }


    //this is a test
}
