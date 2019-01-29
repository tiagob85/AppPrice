package app.teste.appprice;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity  implements Config{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initComponents() {

    }

    @Override
    public void clearComponents() {

    }

    @Override
    public void ButtonEvent(View v)
    {
        switch (v.getId())
        {
            case R.id.BtnMainSair :
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Deseja sair da aplicação ?");
                    builder.setCancelable(true);
                    builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            System.exit(0);
                        }
                    });
                    builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                }break;

            case R.id.BtnMainCadastrar:
                {
                    Intent it = new Intent(MainActivity.this, ConfigActivity.class);
                    startActivity(it);
                }break;

            case R.id.BtnMainPesquisar:
                {
                    Intent it = new Intent(MainActivity.this, PesqPrecosActivity.class);
                    startActivity(it);
                }break;
        }
    }//metodo ButtonEvent

}//classe MainActivity














