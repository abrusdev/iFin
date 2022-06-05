package com.abrusdev.credit.worthiness.steps

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.abrusdev.credit.worthiness.R
import com.abrusdev.credit.worthiness.base.BaseActivity

class Step1Activity : BaseActivity(R.layout.activity_step_1) {

    override fun initialize() {

        val ivAutoCredit = findViewById<ImageView>(R.id.iv_auto_credit)
        val ivMicroLoan = findViewById<ImageView>(R.id.iv_microloan)
        val ivMortgage = findViewById<ImageView>(R.id.iv_mortgage)
        val ivConsumerCredit = findViewById<ImageView>(R.id.iv_consumer_credit)

        ivAutoCredit.setOnClickListener {
            ivAutoCredit.setImageResource(R.drawable.ic_auto_credit_disabled)
            ivMicroLoan.setImageResource(R.drawable.ic_microloan_enabled)
            ivMortgage.setImageResource(R.drawable.ic_mortage_enabled)
            ivConsumerCredit.setImageResource(R.drawable.ic_consumer_credit_enabled)
        }

        ivMicroLoan.setOnClickListener {
            ivMicroLoan.setImageResource(R.drawable.ic_microloan_disabled)
            ivAutoCredit.setImageResource(R.drawable.ic_auto_credit_enabled)
            ivMortgage.setImageResource(R.drawable.ic_mortage_enabled)
            ivConsumerCredit.setImageResource(R.drawable.ic_consumer_credit_enabled)
        }

        ivMortgage.setOnClickListener {
            ivMortgage.setImageResource(R.drawable.ic_mortage_disabled)
            ivMicroLoan.setImageResource(R.drawable.ic_microloan_enabled)
            ivAutoCredit.setImageResource(R.drawable.ic_auto_credit_enabled)
            ivConsumerCredit.setImageResource(R.drawable.ic_consumer_credit_enabled)
        }

        ivConsumerCredit.setOnClickListener {
            ivAutoCredit.setImageResource(R.drawable.ic_auto_credit_enabled)
            ivMicroLoan.setImageResource(R.drawable.ic_microloan_enabled)
            ivMortgage.setImageResource(R.drawable.ic_mortage_enabled)
            ivConsumerCredit.setImageResource(R.drawable.ic_consumer_credit_disabled)
        }



        findViewById<RecyclerView>(R.id.rv_periods).adapter = PeriodsAdapter()

        findViewById<Button>(R.id.btn_continue).setOnClickListener {
            addActivity(Step2Activity::class.java)
        }
    }
}

class PeriodsAdapter : RecyclerView.Adapter<PeriodsAdapter.PeriodsViewHolder>() {

    private var activePos = 0
    private val data = arrayListOf<PeriodData>(
        PeriodData("1 year"),
        PeriodData("2 year"),
        PeriodData("3 year"),
        PeriodData("4 year"),
        PeriodData("5 year"),
        PeriodData("6 year"),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeriodsViewHolder {
        return PeriodsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_credit_period, parent, false)
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(
        holder: PeriodsViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        data[position].isActive = activePos == position

        holder.bind(data[position])

        holder.itemView.setOnClickListener {
            activePos = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = data.size

    inner class PeriodsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: PeriodData) {
            itemView.findViewById<TextView>(R.id.tv_year).let { tv ->
                tv.text = item.value

                if (item.isActive) {
                    tv.setBackgroundResource(R.drawable.bg_selected_year)
                    tv.setTextColor(getColor(itemView.context, R.color.color_white))
                }
                else {
                    tv.setBackgroundResource(R.drawable.bg_unselected_year)
                    tv.setTextColor(getColor(itemView.context, R.color.color_font))
                }
            }
        }
    }
}

data class PeriodData(
    var value: String,
    var isActive: Boolean = false
)