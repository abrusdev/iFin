package com.abrusdev.credit.worthiness

import android.widget.Button
import com.abrusdev.credit.worthiness.base.BaseActivity
import com.abrusdev.credit.worthiness.steps.Step1Activity

class RegisterActivity: BaseActivity(R.layout.activity_register) {

    override fun initialize() {
        findViewById<Button>(R.id.btn_continue).setOnClickListener {
            addActivity(Step1Activity::class.java)
        }
    }
}