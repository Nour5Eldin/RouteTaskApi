package com.noureldin.route.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.noureldin.route.R
import com.noureldin.route.databinding.ItemProductBinding
import com.noureldin.route.helper.WishListPreferences
import com.noureldin.route.model.Product


class ProductAdapter(private var products: List<Product>,private val context: Context) :RecyclerView.Adapter<ProductAdapter.ProductVH>() {

    private val wishlistPreferences = WishListPreferences(context)
    private val productCountMap = mutableMapOf<Int, Int>()
    inner class ProductVH(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(product: Product) {
            binding.product = product
            binding.executePendingBindings()
            // Load wishlist state
            val isWishlist = wishlistPreferences.getWishlistState(product.id.toString())
            val initialDrawable = if (isWishlist) {
                R.drawable.ic_like
            } else {
                R.drawable.ic_add
            }
            binding.wishlistIcon.setImageResource(initialDrawable)
            binding.wishlistIcon.tag = isWishlist

            // Setup click listener for wishlist icon
            binding.wishlistIcon.setOnClickListener {
                // Toggle the state
                val currentState = binding.wishlistIcon.tag as Boolean
                val newState = !currentState

                // Save the new state in SharedPreferences
                wishlistPreferences.setWishlistState(product.id.toString(), newState)

                // Update the tag and drawable resource
                binding.wishlistIcon.tag = newState
                val newDrawable = if (newState) {
                    R.drawable.ic_like
                } else {
                    R.drawable.ic_add
                }
                binding.wishlistIcon.setImageResource(newDrawable)
            }
            if (!productCountMap.containsKey(product.id)) {
                productCountMap[product.id] = 0
            }
            binding.productCount.text = productCountMap[product.id].toString()

            // Setup click listener for add to cart button
            binding.addToCartBtn.setOnClickListener {
                val currentCount = productCountMap[product.id] ?: 0
                if (currentCount < 5) {
                    val newCount = currentCount + 1
                    productCountMap[product.id] = newCount
                    binding.productCount.text = newCount.toString()
                } else {
                    Toast.makeText(
                        context,
                        "Sorry, you reached the limit of the product",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductVH(binding)
    }

    override fun getItemCount(): Int {
      return  products.size
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
        val product = products[position]
        holder.bind(product)
    }
    fun setProducts(product:List<Product>){
        this.products = product
        notifyDataSetChanged()
    }
}