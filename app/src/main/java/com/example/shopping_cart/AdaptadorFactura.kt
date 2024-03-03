package com.example.shopping_cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorFactura(
    private val productos: List<Producto>
) : RecyclerView.Adapter<AdaptadorFactura.ProductoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_producto_factura, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = productos[position]
        holder.bind(producto)
    }

    override fun getItemCount(): Int = productos.size

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvNombreProducto: TextView = itemView.findViewById(R.id.tvNombreProducto)
        private val tvDescripcionProducto: TextView = itemView.findViewById(R.id.tvDescripcionProducto)
        private val tvPrecioProducto: TextView = itemView.findViewById(R.id.tvPrecioProducto)

        fun bind(producto: Producto) {
            tvNombreProducto.text = producto.nomProducto
            tvDescripcionProducto.text = producto.descripcion
            tvPrecioProducto.text = "Precio: ${producto.precio}"
        }
    }
}
