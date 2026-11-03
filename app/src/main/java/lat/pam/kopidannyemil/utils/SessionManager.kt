package lat.pam.kopidannyemil.utils

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("KopiDanNyemilPrefs", Context.MODE_PRIVATE)

    companion object {
        private const val KEY_IS_LOGGED_IN = "is_logged_in"
        private const val KEY_USERNAME = "current_username"
        private const val KEY_FULLNAME = "current_fullname"
    }

    fun saveUser(username: String, pass: String, fullname: String) {
        prefs.edit().apply {
            putString("user_$username", pass)
            putString("name_$username", fullname)
            apply()
        }
    }

    fun checkLogin(username: String, pass: String): Boolean {
        val savedPass = prefs.getString("user_$username", null)
        return savedPass != null && savedPass == pass
    }

    fun getFullName(username: String): String {
        return prefs.getString("name_$username", username) ?: username
    }

    fun createLoginSession(username: String) {
        val fullname = getFullName(username)
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, true)
            putString(KEY_USERNAME, username)
            putString(KEY_FULLNAME, fullname)
            apply()
        }
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(KEY_IS_LOGGED_IN, false)
    }

    fun getCurrentUsername(): String {
        return prefs.getString(KEY_USERNAME, "") ?: ""
    }

    fun getCurrentFullname(): String {
        return prefs.getString(KEY_FULLNAME, "Pengguna") ?: "Pengguna"
    }

    fun updateCurrentFullname(newFullname: String) {
        val username = getCurrentUsername()
        if (username.isNotEmpty()) {
            prefs.edit().apply {
                putString("name_$username", newFullname)
                putString(KEY_FULLNAME, newFullname)
                apply()
            }
        }
    }

    fun logout() {
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, false)
            remove(KEY_USERNAME)
            remove(KEY_FULLNAME)
            apply()
        }
    }
}
