package app.teste.appprice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class BancoController
{
    /*
    * Codido das tabelas :
    * 1 - Marca
    * 2 - Secao
    * 3 - Local
    * 4 - Produto
    * 5 - Registra preço*/

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context)
    {
        banco = new CriaBanco(context);
    }//construtor

    public String insereDadosComplementares(int id, String nome)
    {
        ContentValues valores;
        long resultado = 0;
        db = banco.getWritableDatabase();
        valores = new ContentValues();
        switch (id)
        {
            case 1:
                {
                    valores.put(CriaBanco.MARCANOME, nome);
                    resultado = db.insert(CriaBanco.TABELAMARCA, null,valores);
                }break;
            case 2:
                {
                    valores.put(CriaBanco.SECAO_NOME, nome);
                    resultado = db.insert(CriaBanco.TABELA_SECAO, null,valores);
                }break;
            case 3:
            {
                valores.put(CriaBanco.LOCAL_NOME, nome);
                resultado = db.insert(CriaBanco.TABELA_LOCAL, null,valores);
            }break;
        }
        db.close();
        if (resultado == -1)
        {
                return "Erro ao inserir registro !";
        }
        else
            {
                return "Registro inserido com sucesso !";
            }
    }//metodo insereDadosComplementares

    public Cursor carregaDados(int id)
    {
        Cursor cursor;
        String bancodedados = null;
        String[] campos = {"_id", "nome"};
        db = banco.getReadableDatabase();
        switch (id)
        {
            case 1:{bancodedados = "marca";}break;
            case 2:{bancodedados = "secao";}break;
            case 3:{bancodedados = "local";}break;
        }
        cursor = db.query(bancodedados, campos, null, null, null, null, null, null);
        if (cursor != null)
        {
            cursor.moveToFirst();
        }
        db.close();
         return cursor;
    }

    public List<String> ListSpinner(int id)
    {
        String query,nomeselecao = "";

        List<String> listaitems = new ArrayList<String>();

        switch (id){
            case 1 :{
                query = "select _id, nome from secao;";
                nomeselecao = "selecione a seção";
            }break;
            case 2 :{
                query = "select _id, nome from marca;";
                nomeselecao = "Selecione a marca";
            }break;
            case 3 :{
                query = "select _id, nome from local;";
                nomeselecao = "Selecione o local";
            }break;
        }

        String selectQuery = "select _id, nome from secao;";
 
        db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.moveToFirst()){
            listaitems.add(nomeselecao);
            do {
                listaitems.add(cursor.getString(1));
            }while(cursor.moveToNext());
        }

        return listaitems;
    }

    public void alteraRegistroComplementares(int id, int codigo, String nome)
    {
        ContentValues valores;
        String where;

        db = banco.getWritableDatabase();

        where = " codigo = " + codigo;

        valores = new ContentValues();

        switch (id)
        {
            case 1:
                {
                    valores.put(CriaBanco.MARCANOME, nome);
                    db.update(CriaBanco.TABELAMARCA, valores, where, null);
                }break;
            case 2:
                {
                    valores.put(CriaBanco.SECAO_NOME, nome);
                    db.update(CriaBanco.TABELA_SECAO, valores, where, null);
                }break;
            case 3:
                {
                    valores.put(CriaBanco.LOCAL_NOME, nome);
                    db.update(CriaBanco.TABELA_LOCAL, valores, where, null);
                }break;
        }

        db.close();
    }//metodo alterarRegistro;

}


























































































