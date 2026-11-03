package lat.pam.kopidannyemil.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lat.pam.kopidannyemil.R
import lat.pam.kopidannyemil.model.OrderModel

class HistoryAdapter(
    private val historyList: List<OrderModel>,
    private val onItemClick: (OrderModel) -> Unit
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvHistoryOrderId: TextView = itemView.findViewById(R.id.tvHistoryOrderId)
        val tvHistoryStatus: TextView = itemView.findViewById(R.id.tvHistoryStatus)
        val tvHistoryProductName: TextView = itemView.findViewById(R.id.tvHistoryProductName)
        val tvHistoryDate: TextView = itemView.findViewById(R.id.tvHistoryDate)
        val tvHistoryPrice: TextView = itemView.findViewById(R.id.tvHistoryPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val order = historyList[position]
        holder.tvHistoryOrderId.text = "Order #${order.orderId}"
        holder.tvHistoryProductName.text = "${order.productName} (${order.quantity}x)"
        holder.tvHistoryDate.text = order.date
        holder.tvHistoryPrice.text = order.productPriceFormatted
        holder.tvHistoryStatus.text = order.status

        val badgeColor = when (order.status) {
            "Diproses" -> Color.parseColor("#E8A15A") // Orange
            "Sedang dikirim" -> Color.parseColor("#2196F3") // Blue
            "Selesai" -> Color.parseColor("#4CAF50") // Green
            else -> Color.parseColor("#795548") // Brown
        }

        val background = holder.tvHistoryStatus.background
        if (background is GradientDrawable) {
            background.setColor(badgeColor)
        }

        holder.itemView.setOnClickListener {
            onItemClick(order)
        }
    }

    override fun getItemCount(): Int = historyList.size
}
