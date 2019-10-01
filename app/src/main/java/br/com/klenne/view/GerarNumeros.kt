package br.com.klenne.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import br.com.klenne.db.DataBaseNumeros
import br.com.klenne.gerarnumeros.NumerosLoteria
import br.com.klenne.gerarnumeros.TipoDeJogo
import br.com.klenne.model.NumeroCombinacao
import kotlinx.android.synthetic.main.gerar_numeros.*


class GerarNumeros : AppCompatActivity(), View.OnClickListener {


    var dbHandler: DataBaseNumeros? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.gerar_numeros)
        btn_salvar.setOnClickListener(this)
        btn_gerar.setOnClickListener(this)
        btn_voltar.setOnClickListener(this)
        configureSpinner()
        dbHandler = DataBaseNumeros(this)

    }


    override fun onClick(v: View?) {


        when (val id = v!!.id) {

            R.id.btn_gerar -> {
                //chamando função para mostrar numeros gerados no txv
                setNumerosGerados()

            }
            R.id.btn_voltar -> {
                val intent = Intent(this, TelaMain::class.java)
                startActivity(intent)
                finish()
            }

            R.id.btn_salvar -> {
                val numeroSalvar: NumeroCombinacao = NumeroCombinacao()
                numeroSalvar.numero = txv_numeroGerado.text.toString()
                numeroSalvar.tipoJogo = spn_tiposDeJogos.selectedItem.toString()
                dbHandler?.addNumber(numeroSalvar)

                val toast = Toast.makeText(this, "Combinação Salva com Sucesso!", Toast.LENGTH_LONG).show()
            }
        }

    }


    fun setNumerosGerados() {
        val numerosGerados = NumerosLoteria()
        txv_numeroGerado.text = numerosGerados.selecionarJogo(spn_tiposDeJogos.selectedItem.toString())
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

        spn_tiposDeJogos.adapter = adapter

        //configurando o Spinner
        spn_tiposDeJogos.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {


            override fun onNothingSelected(parent: AdapterView<*>?) {
                //.
            }


            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                //mudando a imagem e strings de acordo com jogo selecionado

                when (parent.getItemAtPosition(position).toString()) {

                    TipoDeJogo.MEGASENA.tipoJogo -> {

                        txv_titulo.text = getString(R.string.gerar_megasena)
                        imv_logo.setImageResource(R.drawable.megasena)
                        setColor(R.color.MegaSena)
                        setNumerosGerados()

                    }
                    TipoDeJogo.QUINA.tipoJogo -> {

                        txv_titulo.text = getString(R.string.gerar_quina)
                        imv_logo.setImageResource(R.drawable.quina)
                        setColor(R.color.Quina)
                        setNumerosGerados()

                    }
                    TipoDeJogo.LOTOFACIL.tipoJogo -> {

                        txv_titulo.text = getString(R.string.gerar_lotoFacil)
                        imv_logo.setImageResource(R.drawable.lotofacil)
                        setColor(R.color.Facil)
                        setNumerosGerados()

                    }
                    TipoDeJogo.DUPLASENA.tipoJogo -> {

                        txv_titulo.text = getString(R.string.gerar_duplasena)
                        imv_logo.setImageResource(R.drawable.duplasena)
                        setColor(R.color.DuplaSena)
                        setNumerosGerados()
                    }
                    TipoDeJogo.DIADESORTE.tipoJogo -> {

                        txv_titulo.text = getString(R.string.gerar_dia_de_sorte)
                        imv_logo.setImageResource(R.drawable.diadesorte)
                        setColor(R.color.DiaDeSorte)
                        setNumerosGerados()


                    }
                    TipoDeJogo.LOTOMANIA.tipoJogo -> {

                        txv_titulo.text = getString(R.string.gerar_lotomania)
                        imv_logo.setImageResource(R.drawable.lotomania)
                        setColor(R.color.Mania)
                        setNumerosGerados()


                    }

                }
            }


        }
    }

    //função para mudar a cor de spinner e de botão
    fun setColor(cor: Int) {
        btn_salvar.setBackgroundResource(cor)
        spn_tiposDeJogos.setPopupBackgroundResource(cor)
        btn_gerar.setBackgroundResource(cor)
    }


}
