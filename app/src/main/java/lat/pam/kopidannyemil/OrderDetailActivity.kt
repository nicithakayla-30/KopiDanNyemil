package lat.pam.kopidannyemil

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_detail)

        val orderId = intent.getStringExtra("order_id") ?: "123456"
        val productName = intent.getStringExtra("product_name") ?: "Kopi Susu Gula Aren"
        val productPrice = intent.getStringExtra("product_price") ?: "Rp22.000"
        val quantity = intent.getIntExtra("quantity", 1)
        val recipientName = intent.getStringExtra("recipient_name") ?: "-"
        val address = intent.getStringExtra("address") ?: "-"
        val landmark = intent.getStringExtra("landmark") ?: "-"
        val date = intent.getStringExtra("date") ?: "-"
        val status = intent.getStringExtra("status") ?: "Diproses"

        val tvDetailOrderIdHeader = findViewById<TextView>(R.id.tvDetailOrderIdHeader)
        val tvDetailStatus = findViewById<TextView>(R.id.tvDetailStatus)
        val tvDetailProductName = findViewById<TextView>(R.id.tvDetailProductName)
        val tvDetailQuantity = findViewById<TextView>(R.id.tvDetailQuantity)
        val tvDetailTotalPrice = findViewById<TextView>(R.id.tvDetailTotalPrice)
        val tvDetailRecipient = findViewById<TextView>(R.id.tvDetailRecipient)
        val tvDetailAddress = findViewById<TextView>(R.id.tvDetailAddress)
        val tvDetailLandmark = findViewById<TextView>(R.id.tvDetailLandmark)
        val tvDetailDate = findViewById<TextView>(R.id.tvDetailDate)
        val btnBackToHistory = findViewById<Button>(R.id.btnBackToHistory)

        tvDetailOrderIdHeader.text = "Order #$orderId"
        tvDetailStatus.text = status
        tvDetailProductName.text = productName
        tvDetailQuantity.text = "Jumlah: ${quantity}x"
        tvDetailTotalPrice.text = "Total Pembayaran: $productPrice"
        tvDetailRecipient.text = "Penerima: $recipientName"
        tvDetailAddress.text = "Alamat: $address"
        tvDetailLandmark.text = "Patokan: $landmark"
        tvDetailDate.text = "Tanggal: $date"

        val badgeColor = when (status) {
            "Diproses" -> Color.parseColor("#E8A15A")
            "Sedang dikirim" -> Color.parseColor("#2196F3")
            "Selesai" -> Color.parseColor("#4CAF50")
            else -> Color.parseColor("#795548")
        }

        val background = tvDetailStatus.background
        if (background is GradientDrawable) {
            background.setColor(badgeColor)
        }

        btnBackToHistory.setOnClickListener {
            finish()
        }
    }
}
