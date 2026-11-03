package lat.pam.kopidannyemil.model

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Int,
    val priceFormatted: String,
    val imageResId: Int
)
