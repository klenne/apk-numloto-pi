package br.com.klenne.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import br.com.klenne.db.DataBaseNumeros
import kotlinx.android.synthetic.main.activity_ver_numero.*
import net.glxn.qrgen.android.QRCode

class VerNumero : AppCompatActivity(), View.OnClickListener {
    var dbHandler: DataBaseNumeros? = null
    private var mImagePreview: ImageView? = null
    lateinit var numero:String
    override fun onClick(v: View?) {


        when (val id = v!!.id) {


            R.id.btn_voltar_vernum_num -> {
                val intent = Intent(this, MeusNumeros::class.java)
                startActivity(intent)
                finish()
            }

            R.id.btn_deletar -> {

                dbHandler?.deleteNumber(numero)
                val intent = Intent(this, MeusNumeros::class.java)
                startActivity(intent)
                finish()
            }

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_numero)
        dbHandler = DataBaseNumeros(this)
        numero = intent.getStringExtra("numero")


        txv_numero_mostrar.text = numero

        mImagePreview = findViewById(R.id.imgQr) as ImageView
        val bitmap = QRCode.from(numero).withSize(1000, 1000).bitmap()
        (mImagePreview as ImageView).setImageBitmap(bitmap)

        btn_voltar_vernum_num.setOnClickListener(this)
        btn_deletar.setOnClickListener(this)

    }


}

