package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import lat.pam.kopidannyemil.model.OrderModel
import lat.pam.kopidannyemil.utils.OrderHistoryManager
import lat.pam.kopidannyemil.utils.SessionManager
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var historyManager: OrderHistoryManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)

        sessionManager = SessionManager(this)
        historyManager = OrderHistoryManager(this)

        val productName = intent.getStringExtra("product_name") ?: "Kopi Susu Gula Aren"
        val productPrice = intent.getStringExtra("product_price_formatted") ?: "Rp22.000"
        val orderName = intent.getStringExtra("order_name") ?: sessionManager.getCurrentFullname()
        val orderAddress = intent.getStringExtra("order_address") ?: ""
        val orderLandmark = intent.getStringExtra("order_landmark") ?: ""

        val tvConfirmationGreeting = findViewById<TextView>(R.id.tvConfirmationGreeting)
        val tvConfProduct = findViewById<TextView>(R.id.tvConfProduct)
        val tvConfAddress = findViewById<TextView>(R.id.tvConfAddress)
        val btnOkConfirmation = findViewById<Button>(R.id.btnOkConfirmation)

        tvConfirmationGreeting.text = "Halo, $orderName"
        tvConfProduct.text = "Produk: $productName ($productPrice)"
        tvConfAddress.text = "Alamat: $orderAddress\nPatokan: $orderLandmark"

        // Save order to history once upon confirmation
        val orderId = (100000..999999).random().toString()
        val dateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
        val currentDate = dateFormat.format(Date())

        val orderModel = OrderModel(
            orderId = orderId,
            productName = productName,
            productPriceFormatted = productPrice,
            quantity = 1,
            recipientName = orderName,
            address = orderAddress,
            landmark = orderLandmark,
            date = currentDate,
            status = "Diproses"
        )

        val username = sessionManager.getCurrentUsername()
        // Save to history
        historyManager.saveOrder(username, orderModel)

        btnOkConfirmation.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}
