package com.abrusdev.credit.worthiness.steps

import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import com.abrusdev.credit.worthiness.R
import com.abrusdev.credit.worthiness.base.BaseActivity

class Step2Activity: BaseActivity(R.layout.activity_step_2) {

    override fun initialize() {
        val progressLayout = findViewById<RelativeLayout>(R.id.rl_progress)

        findViewById<TextView>(R.id.tv_pay_with_payme).setOnClickListener {
            progressLayout.visibility = View.VISIBLE

            Handler(Looper.getMainLooper()).postDelayed({
                progressLayout.visibility = View.GONE
                addActivity(Step3Activity::class.java)
            }, 1000)
        }
    }
}