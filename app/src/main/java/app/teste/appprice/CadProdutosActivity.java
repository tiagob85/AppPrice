package app.teste.appprice;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CadProdutosActivity extends Activity {
    private Spinner spinner, spinner1,spinner2;
    BancoController crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cad_produtos);
        crud = new BancoController(getBaseContext());
        spinner = (Spinner)findViewById(R.id.SpinUnidade);
        spinner1 = (Spinner)findViewById(R.id.SpinMarca);
        spinner2 = (Spinner)findViewById(R.id.SpinSecao);
        List<String> unidade = new ArrayList<String>();
        unidade.add("kg");
        unidade.add("ml");
        unidade.add("mg");
        unidade.add("gr");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, unidade);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        List<String> marca = new ArrayList<String>();
        marca.add("Selecione a marca");
        marca.add("Marca 1");
        marca.add("Marca 2");
        marca.add("Marca 3");

        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, marca);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);

        List<String> secao = new ArrayList<>();
        secao.addAll(crud.ListSpinner(1));
        /*secao.add("Seção 1");
        secao.add("Seção 2");*/

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,secao);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter2);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                if(parent.getSelectedItemId() > 0)
                {
                    Toast.makeText(parent.getContext(), "Selected : "+ item, Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(parent.getContext(), "selecione o item", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected : "+ item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Selected : "+ item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


}



























