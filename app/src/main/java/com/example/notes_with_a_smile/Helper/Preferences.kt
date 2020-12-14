package com.example.notes_with_a_smile.Helper

import android.content.Context
import android.content.SharedPreferences


class Preferences(context: Context) {
    private val sharedPreferences: SharedPreferences
    val isShown: Boolean
        get() = sharedPreferences.getBoolean("isShown", false)

    fun saveShown() {
        sharedPreferences.edit().putBoolean("isShown", true).apply()
    }

    companion object {
        @Volatile
        private var place: Preferences? = null
        fun getInstance(context: Context): Preferences? {
            if (place == null) Preferences(context)
            return place
        } }
    init {
        place = this
        sharedPreferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }
}