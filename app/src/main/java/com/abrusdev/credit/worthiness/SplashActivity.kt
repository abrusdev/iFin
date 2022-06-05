package com.abrusdev.credit.worthiness

import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.abrusdev.credit.worthiness.base.BaseActivity

class SplashActivity: BaseActivity(R.layout.activity_splash) {

    override fun initialize() {
        Handler(Looper.getMainLooper()).postDelayed({
            addActivity(MainActivity::class.java)
            finish()
        }, 2000)
    }
}