package lat.pam.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lat.pam.kopidannyemil.adapter.ProductAdapter
import lat.pam.kopidannyemil.data.DummyData
import lat.pam.kopidannyemil.utils.SessionManager

class HomeActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sessionManager = SessionManager(this)

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        tvGreeting.text = "Halo, ${sessionManager.getCurrentFullname()}"

        val rvProducts = findViewById<RecyclerView>(R.id.rvProducts)
        rvProducts.layoutManager = LinearLayoutManager(this)

        val productList = DummyData.getProducts()
        val adapter = ProductAdapter(productList) { product ->
            val intent = Intent(this, OrderActivity::class.java).apply {
                putExtra("product_name", product.name)
                putExtra("product_price", product.price)
                putExtra("product_price_formatted", product.priceFormatted)
                putExtra("product_desc", product.description)
            }
            startActivity(intent)
        }
        rvProducts.adapter = adapter

        val btnProfile = findViewById<ImageButton>(R.id.btnProfile)
        btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        val btnNavHome = findViewById<Button>(R.id.btnNavHome)
        val btnNavHistory = findViewById<Button>(R.id.btnNavHistory)
        val btnNavOrder = findViewById<Button>(R.id.btnNavOrder)
        val btnNavProfile = findViewById<Button>(R.id.btnNavProfile)

        btnNavHome.setOnClickListener {
            // Already on home
        }

        btnNavHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        btnNavOrder.setOnClickListener {
            startActivity(Intent(this, OrderActivity::class.java))
        }

        btnNavProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        tvGreeting.text = "Halo, ${sessionManager.getCurrentFullname()}"
    }
}
