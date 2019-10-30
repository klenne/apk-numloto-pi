package br.com.klenne.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class LaunchScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch_screen)
        Handler().postDelayed({
            startActivity(Intent(this, TelaMain::class.java))
            finish()
        }, 5000)
    }
}
