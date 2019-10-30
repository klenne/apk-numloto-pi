package br.com.klenne.listadaptors

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.klenne.model.NumeroCombinacao
import br.com.klenne.model.Servico
import br.com.klenne.view.R
import kotlinx.android.synthetic.main.layout_numero.view.*
import kotlinx.android.synthetic.main.layout_numero.view.titulo_servico
import kotlinx.android.synthetic.main.layout_servicos.view.*

class ServicoListAdaptor(private val servicos: List<Servico>, private val context: Context, val listener: (Servico) -> Unit) :
    RecyclerView.Adapter<ServicoListAdaptor.ViewHolder>() {
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onBindViewHolder(holder: ServicoListAdaptor.ViewHolder, position: Int, payloads: MutableList<Any>) {
        val servicoPos = servicos[position]
        holder.itemView.setOnClickListener {
            listener(servicos[position])
        }
        holder.bindView(servicoPos)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_servicos, parent, false)



        return ViewHolder(view)


    }


    override fun getItemCount(): Int {
        return servicos.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(servico: Servico) {
            val titulo= itemView.titulo_servico
            val preco=itemView.preco_servico
            val resumo=itemView.descricao_servico

            titulo.text=servico.nome
            preco.text=servico.preco
            resumo.text=servico.resumo









        }




    }



}

