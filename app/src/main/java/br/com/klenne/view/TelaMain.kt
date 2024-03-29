package br.com.klenne.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import android.support.v7.widget.Toolbar
import android.view.Menu
import br.com.klenne.db.DataBaseServicos
import br.com.klenne.listadaptors.ServicoListAdaptor
import kotlinx.android.synthetic.main.activity_meus_numeros.*
import kotlinx.android.synthetic.main.content_menu_main.*

class TelaMain : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var dbHandler: DataBaseServicos? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)


        dbHandler = DataBaseServicos(this)
        val listaServicos = dbHandler!!.getAllServices()
        val recyclerView =servico_list_recyclerview
        recyclerView.adapter = ServicoListAdaptor(listaServicos, this) { servico ->

            val intent = Intent(this, VerServico::class.java)
            intent.putExtra("descricao", servico.descricao)
            startActivity(intent)

        }
        val layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.

        when (item.itemId) {

            R.id.nav_gerar_numeros -> {
                val intent = Intent(this,GerarNumeros::class.java)
                startActivity(intent)
                finish()
            }
            R.id.nav_meus_numeros -> {
                val intent = Intent(this,MeusNumeros::class.java)
                startActivity(intent)
                finish()
            }
            R.id.nav_lotericas_proximas -> {
                val intent = Intent(this,MapsActivity2::class.java)
                startActivity(intent)
                finish()
            }


        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
