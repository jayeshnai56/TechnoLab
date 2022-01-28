package com.lattitudetech.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.lattitudetech.R
import com.lattitudetech.TechnoLab

class Utils {


    companion object{
        fun isOnline(context: Context?): Boolean {
            if (context == null) return false
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw)
            return actNw != null && (actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                    || actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                    || actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
                    || actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH))
        }

         fun showSnackBar(string:String, view : View ){
            Snackbar.make(view, string, Snackbar.LENGTH_INDEFINITE).setAction(
                TechnoLab.context().getString(R.string.ok)
            ) {
            }.show()
        }
    }
}