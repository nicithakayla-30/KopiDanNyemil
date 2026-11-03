package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import lat.pam.kopidannyemil.utils.SessionManager

class OrderActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        sessionManager = SessionManager(this)

        val productName = intent.getStringExtra("product_name") ?: "Kopi Susu Gula Aren"
        val productPriceFormatted = intent.getStringExtra("product_price_formatted") ?: "Rp22.000"
        val productDesc = intent.getStringExtra("product_desc") ?: "Espresso, susu segar, dan gula aren pilihan"

        val tvOrderProductName = findViewById<TextView>(R.id.tvOrderProductName)
        val tvOrderProductPrice = findViewById<TextView>(R.id.tvOrderProductPrice)
        val etOrderName = findViewById<TextInputEditText>(R.id.etOrderName)
        val etOrderAddress = findViewById<TextInputEditText>(R.id.etOrderAddress)
        val etOrderLandmark = findViewById<TextInputEditText>(R.id.etOrderLandmark)
        val btnSubmitOrder = findViewById<Button>(R.id.btnSubmitOrder)

        tvOrderProductName.text = "$productName - $productDesc"
        tvOrderProductPrice.text = productPriceFormatted

        etOrderName.setText(sessionManager.getCurrentFullname())

        btnSubmitOrder.setOnClickListener {
            val name = etOrderName.text.toString().trim()
            val address = etOrderAddress.text.toString().trim()
            val landmark = etOrderLandmark.text.toString().trim()

            if (name.isEmpty() || address.isEmpty() || landmark.isEmpty()) {
                Toast.makeText(this, "Semua field alamat dan nama wajib diisi!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ConfirmationActivity::class.java).apply {
                    putExtra("product_name", productName)
                    putExtra("product_price_formatted", productPriceFormatted)
                    putExtra("order_name", name)
                    putExtra("order_address", address)
                    putExtra("order_landmark", landmark)
                }
                startActivity(intent)
                finish()
            }
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
            startActivity(Intent(this, HistoryActivity::class.java))
            finish()
        }

        btnNavOrder.setOnClickListener {
            // Already on order
        }

        btnNavProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }
}
