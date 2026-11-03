package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lat.pam.kopidannyemil.adapter.HistoryAdapter
import lat.pam.kopidannyemil.utils.OrderHistoryManager
import lat.pam.kopidannyemil.utils.SessionManager

class HistoryActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var historyManager: OrderHistoryManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        sessionManager = SessionManager(this)
        historyManager = OrderHistoryManager(this)

        val rvHistory = findViewById<RecyclerView>(R.id.rvHistory)
        val layoutEmptyHistory = findViewById<LinearLayout>(R.id.layoutEmptyHistory)
        val btnStartShopping = findViewById<Button>(R.id.btnStartShopping)

        rvHistory.layoutManager = LinearLayoutManager(this)

        val username = sessionManager.getCurrentUsername()
        val orders = historyManager.getOrders(username)

        if (orders.isEmpty()) {
            rvHistory.visibility = View.GONE
            layoutEmptyHistory.visibility = View.VISIBLE
        } else {
            rvHistory.visibility = View.VISIBLE
            layoutEmptyHistory.visibility = View.GONE

            val adapter = HistoryAdapter(orders) { order ->
                val intent = Intent(this, OrderDetailActivity::class.java).apply {
                    putExtra("order_id", order.orderId)
                    putExtra("product_name", order.productName)
                    putExtra("product_price", order.productPriceFormatted)
                    putExtra("quantity", order.quantity)
                    putExtra("recipient_name", order.recipientName)
                    putExtra("address", order.address)
                    putExtra("landmark", order.landmark)
                    putExtra("date", order.date)
                    putExtra("status", order.status)
                }
                startActivity(intent)
            }
            rvHistory.adapter = adapter
        }

        btnStartShopping.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }

        // Bottom Navigation
        val btnNavHome = findViewById<Button>(R.id.btnNavHome)
        val btnNavHistory = findViewById<Button>(R.id.btnNavHistory)
        val btnNavOrder = findViewById<Button>(R.id.btnNavOrder)
        val btnNavProfile = findViewById<Button>(R.id.btnNavProfile)

        btnNavHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        btnNavHistory.setOnClickListener {
            // Already on history
        }

        btnNavOrder.setOnClickListener {
            startActivity(Intent(this, OrderActivity::class.java))
            finish()
        }

        btnNavProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }
}
