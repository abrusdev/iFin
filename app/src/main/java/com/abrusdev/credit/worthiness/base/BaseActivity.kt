package com.abrusdev.credit.worthiness.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(
    private val layoutResID: Int
): AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResID)

        initialize()
    }

    abstract fun initialize()

    open fun addActivity(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
    }
}