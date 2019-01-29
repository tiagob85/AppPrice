package app.teste.appprice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadMarcasActivity extends Activity implements Config {
    EditText EdtNome;
    BancoController crud;
    String resultado, marcaString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_marcas);
        initComponents();
    }

    @Override
    public void initComponents() {
        EdtNome = (EditText)findViewById(R.id.editNomeMarca);
        crud = new BancoController(getBaseContext());
    }

    @Override
    public void clearComponents() {
        EdtNome.setText("");
    }

    @Override
    public void ButtonEvent(View v) {
        switch (v.getId())
        {
            case R.id.BtnMarcaGravar:
                {
                    marcaString = EdtNome.getText().toString();
                    resultado = crud.insereDadosComplementares(1,marcaString);
                    Toast.makeText(getApplicationContext(),resultado, Toast.LENGTH_LONG).show();
                    clearComponents();
                }break;
            case R.id.BtnMarcaVisualizar:
                {
                    Intent intent = new Intent(CadMarcasActivity.this, VisualizarMarcaActivity.class);
                    startActivity(intent);
                }break;
        }
    }
}
