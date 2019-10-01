package br.com.klenne.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.klenne.db.DataBaseNumeros
import kotlinx.android.synthetic.main.activity_meus_numeros.*

class MeusNumeros : AppCompatActivity() {

    var dbHandler: DataBaseNumeros? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_numeros)
        dbHandler = DataBaseNumeros(this)

        button.setOnClickListener {
            val numeros = dbHandler!!.getAllNumbers()
            txv_numeros.text = numeros
        }
    }
}
