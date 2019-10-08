package br.com.klenne.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import br.com.klenne.db.DataBaseNumeros
import br.com.klenne.listadaptors.NumeroListAdapter
import kotlinx.android.synthetic.main.activity_meus_numeros.*

class MeusNumeros : AppCompatActivity(), View.OnClickListener {

    var dbHandler: DataBaseNumeros? = null


    override fun onClick(v: View?) {


        when (val id = v!!.id) {


            R.id.btn_voltar_vernum_num -> {
                val intent = Intent(this, TelaMain::class.java)
                startActivity(intent)
                finish()
            }


        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meus_numeros)
        dbHandler = DataBaseNumeros(this)
        val listaNumeros = dbHandler!!.getAllNumbers()
        val recyclerView = numero_list_recyclerview
        recyclerView.adapter = NumeroListAdapter(listaNumeros, this) { numero ->
            val intent = Intent(this, VerNumero::class.java)
            intent.putExtra("numero",numero.numero)
            startActivity(intent)
        }
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        btn_voltar_vernum_num.setOnClickListener(this)


    }


}


