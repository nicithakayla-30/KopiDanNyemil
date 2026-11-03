package lat.pam.kopidannyemil.model

data class OrderModel(
    val orderId: String,
    val productName: String,
    val productPriceFormatted: String,
    val quantity: Int,
    val recipientName: String,
    val address: String,
    val landmark: String,
    val date: String,
    val status: String
)
