package lat.pam.kopidannyemil.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import lat.pam.kopidannyemil.R
import lat.pam.kopidannyemil.model.Product

class ProductAdapter(
    private val productList: List<Product>,
    private val onOrderClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivProduct: ImageView = itemView.findViewById(R.id.ivProduct)
        val tvProductName: TextView = itemView.findViewById(R.id.tvProductName)
        val tvProductDesc: TextView = itemView.findViewById(R.id.tvProductDesc)
        val tvProductPrice: TextView = itemView.findViewById(R.id.tvProductPrice)
        val btnOrder: Button = itemView.findViewById(R.id.btnOrder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.tvProductName.text = product.name
        holder.tvProductDesc.text = product.description
        holder.tvProductPrice.text = product.priceFormatted
        holder.ivProduct.setImageResource(product.imageResId)

        holder.btnOrder.setOnClickListener {
            onOrderClick(product)
        }
        
        holder.itemView.setOnClickListener {
            onOrderClick(product)
        }
    }

    override fun getItemCount(): Int = productList.size
}
