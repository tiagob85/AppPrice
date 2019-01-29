package app.teste.appprice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadLocalActivity extends Activity implements Config{

    EditText EdtLocal;
    BancoController crud;
    String resultado, marcaString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_local);
        initComponents();
    }

    @Override
    public void initComponents() {
        EdtLocal = (EditText) findViewById(R.id.editNomeLocal);
        crud = new BancoController(getBaseContext());
    }

    @Override
    public void clearComponents() {
        EdtLocal.setText("");
    }

    @Override
    public void ButtonEvent(View v) {
        switch(v.getId()){
            case R.id.BtnLocalGravar:{
                marcaString = EdtLocal.getText().toString();
                resultado = crud.insereDadosComplementares(3,marcaString);
                Toast.makeText(getApplicationContext(),resultado, Toast.LENGTH_LONG).show();
                clearComponents();
            }break;

            case R.id.BtnLocalVisualizar:{
                Intent it = new Intent(CadLocalActivity.this, VisualizarLocalActivity.class);
                startActivity(it);
            }break;
       }
    }
}
