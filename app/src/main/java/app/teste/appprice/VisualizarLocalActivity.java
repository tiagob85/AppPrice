package app.teste.appprice;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class VisualizarLocalActivity extends Activity implements Config{
    private ListView lista;
    Cursor cursor;
    BancoController crud;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_local);
        initComponents();
    }

    @Override
    public void initComponents() {
        crud = new BancoController(getBaseContext());
        cursor = null;
        cursor = crud.carregaDados(3);

        String[] nomeCampos = new String[]{"_id", "nome"};
        int[] idVieews = new int[]{R.id.codlocal, R.id.nmLocal};

        SimpleCursorAdapter adaptador  = new SimpleCursorAdapter(getBaseContext(), R.layout.activity_visualizar_local, cursor,
                nomeCampos, idVieews, 0);
        lista = (ListView)findViewById(R.id.ListaView2);
        lista.setAdapter(adaptador);
    }

    @Override
    public void clearComponents() {

    }

    @Override
    public void ButtonEvent(View v) {

    }
}
