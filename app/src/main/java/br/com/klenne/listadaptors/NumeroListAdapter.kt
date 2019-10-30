package br.com.klenne.listadaptors

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.klenne.gerarnumeros.TipoDeJogo
import br.com.klenne.model.NumeroCombinacao
import br.com.klenne.view.R
import kotlinx.android.synthetic.main.layout_numero.view.*


class NumeroListAdapter(private val numerosCombinacao: List<NumeroCombinacao>, private val context: Context,val listener: (NumeroCombinacao) -> Unit) :
    Adapter<NumeroListAdapter.ViewHolder>() {
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        val numero = numerosCombinacao[position]
        holder.itemView.setOnClickListener {
            listener(numerosCombinacao[position])
        }
        holder.bindView(numero)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_numero, parent, false)



        return ViewHolder(view)


    }


    override fun getItemCount(): Int {
        return numerosCombinacao.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

      fun bindView(combinacao: NumeroCombinacao) {


            val numero = itemView.titulo_servico
            val img = itemView.img_card

            when (combinacao.tipoJogo) {

                TipoDeJogo.MEGASENA.tipoJogo -> {
                    img.setImageResource(R.drawable.megasena)


                }
                TipoDeJogo.QUINA.tipoJogo -> {
                    img.setImageResource(R.drawable.quina)


                }
                TipoDeJogo.LOTOFACIL.tipoJogo -> {
                    img.setImageResource(R.drawable.lotofacil)


                }
                TipoDeJogo.DUPLASENA.tipoJogo -> {
                    img.setImageResource(R.drawable.duplasena)

                }
                TipoDeJogo.DIADESORTE.tipoJogo -> {

                    img.setImageResource(R.drawable.diadesorte)

                }
                TipoDeJogo.LOTOMANIA.tipoJogo -> {
                    img.setImageResource(R.drawable.lotomania)


                }

            }

            numero.text = combinacao.numero



        }




    }



}

