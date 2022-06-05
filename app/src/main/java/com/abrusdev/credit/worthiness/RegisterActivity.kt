package com.abrusdev.credit.worthiness

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.abrusdev.credit.worthiness.base.BaseActivity
import com.abrusdev.credit.worthiness.steps.Step1Activity

class RegisterActivity : BaseActivity(R.layout.activity_register) {

    override fun initialize() {
        findViewById<Button>(R.id.btn_continue).setOnClickListener {
            if (isEdtEmpty(R.id.edt_age)) {
                Toast.makeText(this, "Fill your age", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (isEdtEmpty(R.id.edt_experience)) {
                Toast.makeText(this, "Fill your experience", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (isEdtEmpty(R.id.edt_earnings)) {
                Toast.makeText(this, "Fill your earnings", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (isEdtEmpty(R.id.edt_scode)) {
                Toast.makeText(this, "Fill credit score", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (isEdtEmpty(R.id.edt_rate)) {
                Toast.makeText(this, "Fill credit rate", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            addActivity(Step1Activity::class.java)
        }

        initYesNoLogic(findViewById(R.id.tv_estate_yes), findViewById(R.id.tv_estate_no))
        initYesNoLogic(findViewById(R.id.tv_vehicle_yes), findViewById(R.id.tv_vehicle_no))
        initYesNoLogic(findViewById(R.id.tv_guarantor_yes), findViewById(R.id.tv_guarantor_no))
        initYesNoLogic(findViewById(R.id.tv_debt_yes), findViewById(R.id.tv_debt_no))

    }

    private fun isEdtEmpty(resId: Int): Boolean {
        return findViewById<EditText>(resId).text.isEmpty()
    }

    private fun initYesNoLogic(tvYes: TextView, tvNo: TextView) {
        tvYes.setOnClickListener {
            tvYes.setBackgroundResource(R.drawable.bg_edt_active)
            tvNo.setBackgroundResource(R.drawable.bg_edt)
        }

        tvNo.setOnClickListener {
            tvYes.setBackgroundResource(R.drawable.bg_edt)
            tvNo.setBackgroundResource(R.drawable.bg_edt_disactive)
        }
    }
}