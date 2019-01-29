package app.teste.appprice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper
{
    public static final String NOME_BANCO = "teste11.db";
    //Tabela Marca
    public static final String TABELAMARCA = "marca";
    public static final String MARCACODIGO = "_id";
    public static final String MARCANOME = "nome";
    //Tabela Seção
    public static final String TABELA_SECAO = "secao";
    public static final String SECAO_CODIGO = "_id";
    public static final String SECAO_NOME = "nome";
    //Tabela Local
    public static final String TABELA_LOCAL = "local";
    public static final String LOCAL_CODIGO = "_id";
    public static final String LOCAL_NOME = "nome";

    public static final int VERSAO = 3;

    public static final String sql = "CREATE TABLE IF NOT EXISTS "+ TABELAMARCA +" ( "
            + MARCACODIGO + " integer primary key autoincrement, "
            + MARCANOME  +" text );";

    private static final String sql1 = " CREATE TABLE IF NOT EXISTS "+ TABELA_SECAO +" ( "
            + SECAO_CODIGO + " integer primary key autoincrement, "
            + SECAO_NOME  +" text );";

    private static final String sql2 = " CREATE TABLE IF NOT EXISTS "+ TABELA_LOCAL +" ( "
            + LOCAL_CODIGO + " integer primary key autoincrement, "
            + LOCAL_NOME  +" text );";

    public CriaBanco(Context context)
    {
        super(context, NOME_BANCO,null,VERSAO);
    }//Construtor

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        db.execSQL(sql);
        db.execSQL(sql1);
        db.execSQL(sql2);
        /*sql = "CREATE TABLE "+ TABELA_LOCAL +" ( "
                + LOCAL_CODIGO + " integer primary key autoincrement, "
                + LOCAL_NOME  +" text )";
        db.execSQL(sql);*/
    }//onCreate

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABELAMARCA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_SECAO);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_LOCAL);
        onCreate(db);
    }//metodo onUpgrade
}
