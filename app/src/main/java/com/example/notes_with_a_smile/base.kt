package com.example.notes_with_a_smile

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

abstract class BaseActivity (private var layoutId: Int) : AppCompatActivity() {



    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        loadLocate()

    }
    @Override
    @SuppressWarnings("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(layoutId)

onCreateMy()
    }


    fun initLanguage() {
        //  val actionBar = supportActionBar
        // actionBar!!.title = resources.getString(R.string.app_name)
        loadLocate()
        showChangeLang() }


abstract fun  onCreateMy()


    private fun setLocate(Lang: String) {

        val locale = Locale(Lang)

        Locale.setDefault(locale)

        val config = Configuration()

        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    private fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language: String? = sharedPreferences.getString("My_Lang", "")
        if (language != null) {
            setLocate(language)
        }
    }

    private fun showChangeLang() {

        val listItmes = arrayOf("Espain", "Kyrgyz", "English")

        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setTitle("Choose Language")
        mBuilder.setSingleChoiceItems(listItmes, -1) { dialog, which ->

            if (which == 0) {
                setLocate("es")
                recreate()
            } else if (which == 1) {
                setLocate("ky")
                recreate()
            } else if (which == 2) {
                setLocate("en")
                recreate()
            }

            dialog.dismiss()
        }
        val mDialog = mBuilder.create()
        mDialog.show()
    }
}