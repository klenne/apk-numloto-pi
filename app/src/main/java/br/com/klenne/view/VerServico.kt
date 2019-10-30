package br.com.klenne.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.klenne.model.NumeroCombinacao
import kotlinx.android.synthetic.main.activity_ver_servico.*
import kotlinx.android.synthetic.main.gerar_numeros.*

class VerServico : AppCompatActivity(), View.OnClickListener  {


    override fun onClick(v: View?) {


        when (val id = v!!.id) {

            R.id.btn_voltar_main-> {
                //chamando função para mostrar numeros gerados no txv

                val intent = Intent(this, TelaMain::class.java)
                startActivity(intent)
                finish()
            }

        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_servico)

        val descricao = intent.getStringExtra("descricao")

      txv_descricao.text=descricao
        btn_voltar_main.setOnClickListener(this)
    }

}
