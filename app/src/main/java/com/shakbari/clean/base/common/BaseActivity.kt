package com.shakbari.clean.base.common

import android.graphics.Bitmap
import android.os.Bundle
import android.os.PersistableBundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.RequestManager
import javax.inject.Inject

abstract class BaseActivity:AppCompatActivity() {

    @Inject
    lateinit var glide: RequestManager
    @Inject
    lateinit var glideWithBitmap: RequestBuilder<Bitmap>

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().permitAll().build())





        /*if (Build.VERSION.SDK_INT >= 21) {
            val window = window
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            if (this !is SplashActivity) {
                ThemeHelper.getInstance().setThemBasedOnUiMode(this)
            } else {
                supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
                window.statusBarColor = resources.getColor(R.color.primary_teaberry)
                window.navigationBarColor = resources.getColor(R.color.navigation_bar_color_splash)
            }
        }*/


    }
}