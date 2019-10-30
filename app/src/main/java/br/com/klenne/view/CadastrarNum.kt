package br.com.klenne.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import br.com.klenne.db.DataBaseNumeros
import br.com.klenne.gerarnumeros.TipoDeJogo
import br.com.klenne.model.NumeroCombinacao
import kotlinx.android.synthetic.main.activity_cadastrar_num.*

class CadastrarNum : AppCompatActivity(), View.OnClickListener {

    var dbHandler: DataBaseNumeros? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_num)
        configureSpinner()
        btn_cadastrar.setOnClickListener(this)
        btn_voltar_cadastro.setOnClickListener(this)
        dbHandler = DataBaseNumeros(this)

    }


    override fun onClick(v: View?) {


        when (val id = v!!.id) {

            R.id.btn_cadastrar -> {
                val numero = edt_numeros.text.toString()
                val numeroSalvar = NumeroCombinacao()
                numeroSalvar.numero = numero
                numeroSalvar.tipoJogo = spn_cadastro.selectedItem.toString()

                if (numero.isNotEmpty()) {
                    dbHandler?.addNumber(numeroSalvar)
                    val intent = Intent(this, MeusNumeros::class.java)
                    startActivity(intent)
                    finish()

                } else {
                    val toast = Toast.makeText(this, "Digite um Número", Toast.LENGTH_LONG).show()

                }


            }
            R.id.btn_voltar_cadastro -> {
                val intent = Intent(this, MeusNumeros::class.java)
                startActivity(intent)
                finish()

            }


        }


    }

    private fun configureSpinner() {
        //preenchendo spinner
        val tiposDeJogo = arrayListOf(
            TipoDeJogo.MEGASENA.tipoJogo,
            TipoDeJogo.QUINA.tipoJogo,
            TipoDeJogo.LOTOFACIL.tipoJogo,
            TipoDeJogo.DUPLASENA.tipoJogo,
            TipoDeJogo.DIADESORTE.tipoJogo,
            TipoDeJogo.LOTOMANIA.tipoJogo
        )

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tiposDeJogo)

        spn_cadastro.adapter = adapter

    }
}
