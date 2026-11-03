package lat.pam.kopidannyemil.utils

import android.content.Context
import android.content.SharedPreferences
import lat.pam.kopidannyemil.model.OrderModel
import org.json.JSONArray
import org.json.JSONObject

class OrderHistoryManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("KopiDanNyemilHistoryPrefs", Context.MODE_PRIVATE)

    fun saveOrder(username: String, order: OrderModel) {
        val orders = getOrders(username).toMutableList()
        orders.add(0, order) // Add new order at the top

        val jsonArray = JSONArray()
        for (item in orders) {
            val jsonObj = JSONObject().apply {
                put("orderId", item.orderId)
                put("productName", item.productName)
                put("productPriceFormatted", item.productPriceFormatted)
                put("quantity", item.quantity)
                put("recipientName", item.recipientName)
                put("address", item.address)
                put("landmark", item.landmark)
                put("date", item.date)
                put("status", item.status)
            }
            jsonArray.put(jsonObj)
        }

        prefs.edit().putString("history_$username", jsonArray.toString()).apply()
    }

    fun getOrders(username: String): List<OrderModel> {
        val jsonString = prefs.getString("history_$username", null) ?: return emptyList()
        val list = mutableListOf<OrderModel>()
        try {
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                list.add(
                    OrderModel(
                        orderId = obj.getString("orderId"),
                        productName = obj.getString("productName"),
                        productPriceFormatted = obj.getString("productPriceFormatted"),
                        quantity = obj.optInt("quantity", 1),
                        recipientName = obj.getString("recipientName"),
                        address = obj.getString("address"),
                        landmark = obj.getString("landmark"),
                        date = obj.getString("date"),
                        status = obj.getString("status")
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return list
    }
}
