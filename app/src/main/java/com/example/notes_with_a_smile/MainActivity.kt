package com.example.notes_with_a_smile

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

import com.example.notes_with_a_smile.Helper.Preferences
import com.example.notes_with_a_smile.ViewPager.ViewPagerActivity
import com.example.notes_with_a_smile.ui.*
import com.example.notes_with_a_smile.ui.game.GameFragment
import com.example.notes_with_a_smile.ui.mood.MoodFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(R.layout.activity_main),NavigationView.OnNavigationItemSelectedListener {
    lateinit var drawer: DrawerLayout
    lateinit var mToggle: ActionBarDrawerToggle

fun  method(){

    val toolbar: Toolbar = findViewById(R.id.toolbar)
    setSupportActionBar(toolbar)
    drawer = findViewById(R.id.drawer_layout)

    val navView: NavigationView = findViewById(R.id.nav_view)
    navView.setNavigationItemSelectedListener(this)


    mToggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close)
    drawer.addDrawerListener(mToggle)
    mToggle.syncState()
    supportActionBar?.setDisplayHomeAsUpEnabled(true)

    bottom_navigation.setOnNavigationItemSelectedListener { item->

        when (item.itemId) {
            R.id.nav_game -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, GameFragment()).commit()


        }
        true

    }







    val isShow: Boolean? = Preferences.getInstance(this)?.isShown
    if (!isShow!!) {
        startActivity(Intent(this, ViewPagerActivity::class.java))
        finish()
        return


    }



}


    override fun onCreateMy() {
        method()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {




        if (mToggle.onOptionsItemSelected(item)) {

            return true
        }else if (item.itemId==R.id.action_lang){

            initLanguage()

        }

        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen((GravityCompat.START))) {

            drawer.closeDrawer(GravityCompat.START)
        } else {


            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.nav_mood -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MoodFragment()).commit()
            R.id.nav_musicVideo -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MusicVideoFragment()).commit()
            R.id.nav_chatBot -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ChatBotFragment()).commit()
            R.id.nav_onlineChat -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, OnlineChatFireBaseFragment()).commit()
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }


}


