package br.com.klenne.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.klenne.db.DataBaseNumeros
import kotlinx.android.synthetic.main.activity_ver_numero.*

class VerNumero : AppCompatActivity() {
    var dbHandler: DataBaseNumeros? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_numero)
        dbHandler = DataBaseNumeros(this)
      val nome = intent.getStringExtra("numero")
        edt_numero.setText(nome)
    }
}
