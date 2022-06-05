package com.abrusdev.credit.worthiness

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.abrusdev.credit.worthiness.base.BaseActivity

class MainActivity : BaseActivity(R.layout.activity_launch) {

    override fun initialize() {
        findViewById<Button>(R.id.btn_started).setOnClickListener {
            addActivity(RegisterActivity::class.java)
        }
    }
}