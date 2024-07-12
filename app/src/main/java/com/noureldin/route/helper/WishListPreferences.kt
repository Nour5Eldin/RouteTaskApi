package com.noureldin.route.helper

import android.content.Context
import android.content.SharedPreferences

class WishListPreferences(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("wishlist_prefs", Context.MODE_PRIVATE)
    fun setWishlistState(productId: String, isWishlist: Boolean) {
        prefs.edit().putBoolean(productId, isWishlist).apply()
    }

    fun getWishlistState(productId: String): Boolean {
        return prefs.getBoolean(productId, false)
    }
}