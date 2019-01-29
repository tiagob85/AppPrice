package app.teste.appprice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConfigActivity extends Activity implements Config {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
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
            case R.id.BtnConfigCadastrar:
                {
                    Intent it = new Intent(ConfigActivity.this, CadProdutosActivity.class);
                    startActivity(it);
                }break;
            case R.id.BtnConfigMarcas:
                {
                    Intent it1 = new Intent(ConfigActivity.this, CadMarcasActivity.class);
                    startActivity(it1);
                }break;
            case R.id.BtnConfigSecao:
                {
                    Intent it2 = new Intent(ConfigActivity.this, CadSecaoActivity.class);
                    startActivity(it2);
                }break;
            case R.id.BtnConfigMercados:
                {
                    Intent it3 = new Intent(ConfigActivity.this, CadLocalActivity.class);
                    startActivity(it3);
                }break;
        }
    }
}
