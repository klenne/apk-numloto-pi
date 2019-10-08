package br.com.klenne.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import br.com.klenne.model.NumeroCombinacao

class DataBaseNumeros(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSIOM) {


    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME " +
                "($ID Integer PRIMARY KEY AUTOINCREMENT  , $NUMEROCOMBINACAO TEXT, $TIPOJOGO TEXT)"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Called when the database needs to be upgraded
    }

    //Inserting (Creating) data
    fun addNumber(numeroCombinacao: NumeroCombinacao): Boolean {
        //Create and/or open a database that will be used for reading and writing.
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NUMEROCOMBINACAO, numeroCombinacao.numero)
        values.put(TIPOJOGO, numeroCombinacao.tipoJogo)
        val _success = db.insert(TABLE_NAME, null, values)
        db.close()
        Log.v("InsertedID", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }


    //get all users
    fun getAllNumbers(): List<NumeroCombinacao> {
        var listaNumeros = mutableListOf<NumeroCombinacao>()


        val db = readableDatabase
        val selectALLQuery = "SELECT * FROM  $TABLE_NAME"
        val cursor = db.rawQuery(selectALLQuery, null)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    val numero = NumeroCombinacao()
                    numero.id = cursor.getColumnIndex(ID)
                    numero.numero = cursor.getString(cursor.getColumnIndex(NUMEROCOMBINACAO))
                    numero.tipoJogo = cursor.getString(cursor.getColumnIndex(TIPOJOGO))

                    listaNumeros.add(numero)


                } while (cursor.moveToNext())
            }
        }
        cursor.close()
        db.close()
        return listaNumeros
    }

    //delete
    fun deleteNumber(numeroCombinacao: String) {

        val db = this.writableDatabase
        db.delete(TABLE_NAME, NUMEROCOMBINACAO + "=?", arrayOf(numeroCombinacao))

        db.close()
    }

    companion object {
        private val DB_NAME = "NumerosDB"
        private val DB_VERSIOM = 1;
        private val TABLE_NAME = "NUMEROCOMBINACAO"
        private val ID = "id_table_a"
        private val NUMEROCOMBINACAO = "numero_combinacao"
        private val TIPOJOGO = "tipo_jogo"
    }
}