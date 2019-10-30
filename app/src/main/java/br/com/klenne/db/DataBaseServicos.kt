package br.com.klenne.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import br.com.klenne.model.Servico
import br.com.klenne.model.Servicos

class DataBaseServicos(context: Context) :

    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSIOM) {


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME " +
                "($ID Integer PRIMARY KEY AUTOINCREMENT  , $NOME TEXT, $PRECO TEXT,$RESUMO TEXT,$DESCRICAO TEXT)"
        val servicos=Servicos()
        db?.execSQL(CREATE_TABLE)
        for (i in servicos.servicos.indices){
            db?.execSQL(servicos.servicos[i])
        }


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Called when the database needs to be upgraded
    }


    //get all users
    fun getAllServices(): List<Servico> {

        var listaServicos = mutableListOf<Servico>()


        val db = readableDatabase
        val selectALLQuery = "SELECT * FROM  $TABLE_NAME"
        val cursor = db.rawQuery(selectALLQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val servico = Servico()
                    servico.id = cursor.getColumnIndex(ID)
                    servico.nome = cursor.getString(cursor.getColumnIndex(NOME))
                    servico.preco = cursor.getString(cursor.getColumnIndex(PRECO))
                    servico.descricao = cursor.getString(cursor.getColumnIndex(DESCRICAO))
                    servico.resumo = cursor.getString(cursor.getColumnIndex(RESUMO))
                    listaServicos.add(servico)


                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return listaServicos
    }



    companion object {
         val DB_NAME = "ServicosDB"
        val DB_VERSIOM = 1;
        val TABLE_NAME = "SERVICOS"
         val ID = "id_table_a"
         val NOME = "nome"
         val PRECO = "preco"
         val RESUMO = "resumo"
         val DESCRICAO = "descricao"
    }

}

