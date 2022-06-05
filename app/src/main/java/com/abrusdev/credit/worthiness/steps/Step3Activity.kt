package com.abrusdev.credit.worthiness.steps

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abrusdev.credit.worthiness.R
import com.abrusdev.credit.worthiness.base.BaseActivity

class Step3Activity : BaseActivity(R.layout.activity_step_3) {
    override fun initialize() {
        findViewById<RecyclerView>(R.id.rv_banks).adapter = BanksAdapter()
    }
}


class BanksAdapter : RecyclerView.Adapter<BanksAdapter.BankViewHolder>() {

    private var activePos = 0
    private val data = arrayListOf<BankData>(
        BankData("Ishonch", R.drawable.image_asia_aliance_bank, 10_000_000, true),
        BankData("Ekspress-mikroqarz", R.drawable.image_trast_bank, 10_000_000, false),
        BankData("PRO-mikroqarz", R.drawable.image_orient_finanse_bank, 10_000_000, true),
        BankData("Fursat", R.drawable.image_asia_aliance_bank, 10_000_000, true),
        BankData("Mikroqarz", R.drawable.image_trast_bank, 10_000_000, false),
        BankData("Onlayn Mikroqarz", R.drawable.image_ipoteka_bank, 10_000_000, false),
        BankData("Mikroqarz", R.drawable.image_sqb, 10_000_000, true),
        BankData("Onlayn Mikroqarz", R.drawable.image_sqb, 10_000_000, true),
        BankData("Imkon", R.drawable.image_asia_aliance_bank, 10_000_000, false),
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        return BankViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_bank, parent, false)
        )
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(
        holder: BankViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        holder.bind(data[position])

        holder.itemView.setOnClickListener {
            activePos = position
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = data.size

    inner class BankViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: BankData) {

            itemView.findViewById<TextView>(R.id.tv_suitable).visibility =
                if (item.suitable) View.VISIBLE else View.GONE
            itemView.findViewById<TextView>(R.id.tv_unsuitable).visibility =
                if (!item.suitable) View.VISIBLE else View.GONE

            itemView.findViewById<TextView>(R.id.tv_name).text = item.name
            itemView.findViewById<TextView>(R.id.tv_amount).text = String.format(
                "Credit amount: %d so\'m", item.amount
            )
            itemView.findViewById<ImageView>(R.id.iv_bank).setImageResource(item.imageRes)

        }
    }
}

data class BankData(
    var name: String,
    var imageRes: Int,
    var amount: Int = 10_000_000,
    var suitable: Boolean = false
)