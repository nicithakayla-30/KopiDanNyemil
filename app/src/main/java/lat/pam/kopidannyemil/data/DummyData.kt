package lat.pam.kopidannyemil.data

import lat.pam.kopidannyemil.R
import lat.pam.kopidannyemil.model.Product

object DummyData {
    fun getProducts(): List<Product> {
        return listOf(
            Product(
                id = 1,
                name = "Kopi Susu Gula Aren",
                description = "Espresso, susu segar, dan gula aren pilihan",
                price = 22000,
                priceFormatted = "Rp22.000",
                imageResId = R.drawable.ic_coffee
            ),
            Product(
                id = 2,
                name = "Donat Cokelat",
                description = "Donat empuk dengan glaze cokelat lezat",
                price = 12000,
                priceFormatted = "Rp12.000",
                imageResId = R.drawable.ic_donut
            ),
            Product(
                id = 3,
                name = "Sourdough Loaf",
                description = "Roti fermentasi alami dengan tekstur renyah",
                price = 35000,
                priceFormatted = "Rp35.000",
                imageResId = R.drawable.ic_bread
            ),
            Product(
                id = 4,
                name = "Cappuccino",
                description = "Espresso dengan foam susu lembut dan seimbang",
                price = 25000,
                priceFormatted = "Rp25.000",
                imageResId = R.drawable.ic_cappuccino
            ),
            Product(
                id = 5,
                name = "Matcha Latte",
                description = "Matcha Jepang berkualitas tinggi dengan susu segar",
                price = 27000,
                priceFormatted = "Rp27.000",
                imageResId = R.drawable.ic_matcha
            )
        )
    }
}
