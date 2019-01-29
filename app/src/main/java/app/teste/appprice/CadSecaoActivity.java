package app.teste.appprice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadSecaoActivity extends Activity implements Config{
    EditText EdtSecao;
    BancoController crud;
    String resultado, marcaString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_secao);
        initComponents();
    }

    @Override
    public void initComponents() {
        EdtSecao = (EditText)findViewById(R.id.editNomeSecao);
        crud = new BancoController(getBaseContext());
    }

    @Override
    public void clearComponents() {
        EdtSecao.setText("");
    }

    @Override
    public void ButtonEvent(View v)
    {
        switch (v.getId())
        {
            case R.id.BtnSecaoGravar:
                {
                    marcaString = EdtSecao.getText().toString();
                    resultado = crud.insereDadosComplementares(2,marcaString);
                    Toast.makeText(getApplicationContext(),resultado, Toast.LENGTH_LONG).show();
                    clearComponents();
                }break;
            case R.id.BtnSecaoVisualizar:
                {
                    Intent it = new Intent(CadSecaoActivity.this, VisualizarSecaoActivity.class);
                    startActivity(it);
                }break;
        }
    }
}
































