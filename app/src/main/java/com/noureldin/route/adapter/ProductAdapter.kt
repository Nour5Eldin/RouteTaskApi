package com.noureldin.route.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.noureldin.route.databinding.ItemProductBinding
import com.noureldin.route.model.Product

class ProductAdapter(private var products: List<Product>) :RecyclerView.Adapter<ProductAdapter.ProductVH>() {


    inner class ProductVH(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(product: Product) {
            binding.product = product
            binding.executePendingBindings()
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