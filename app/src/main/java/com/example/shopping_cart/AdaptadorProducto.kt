package com.example.shopping_cart

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorProducto(
    var context: Context,
    var tvCantProductos:TextView,
    var btnVerCarro:Button,
    var listaProductos: ArrayList<Producto>,
    var carroCompras: ArrayList<Producto>
): RecyclerView.Adapter<AdaptadorProducto.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvNomProducto = itemView.findViewById(R.id.tvNomProducto) as TextView
        val tvDescripcion = itemView.findViewById(R.id.tvDescripcion) as TextView
        val cbCarro = itemView.findViewById(R.id.cbCarro) as CheckBox
        val tvPrecio = itemView.findViewById(R.id.tvPrecio) as TextView

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        var vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_productos,parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val producto = listaProductos[position]

        holder.tvNomProducto.text = producto.nomProducto
        holder.tvDescripcion.text = producto.descripcion
        holder.tvPrecio.text = producto.precio.toString()

        holder.cbCarro.setOnCheckedChangeListener { compoundButton, b ->
            if (holder.cbCarro.isChecked){
                tvCantProductos.text = "${Integer.parseInt(tvCantProductos.text.toString().trim()) + 1}"
                carroCompras.add(listaProductos[position]) // Agregar el producto al carro de compras
            } else {
                tvCantProductos.text = "${Integer.parseInt(tvCantProductos.text.toString().trim()) - 1}"
                carroCompras.remove(listaProductos[position]) // Quitar el producto del carro de compras
            }
        }

        // Acción al presionar el botón del Carrito de Compras
        btnVerCarro.setOnClickListener{
            val intent = Intent(context, CarroComprasActivity::class.java)
            intent.putExtra("carro_compras", carroCompras)
            context.startActivity(intent)
        }
    }

    // Regresamos el tamaño de la lista de Productos
    override fun getItemCount(): Int {
        return listaProductos.size

    }
}