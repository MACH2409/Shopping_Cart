package com.example.shopping_cart

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FacturaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_factura)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val carroCompras = intent.getSerializableExtra("carro_compras") as ArrayList<Producto>

        val rvListaProductosFactura = findViewById<RecyclerView>(R.id.rvListaProductosFactura)
        rvListaProductosFactura.layoutManager = LinearLayoutManager(this)
        rvListaProductosFactura.adapter = AdaptadorFactura(carroCompras)

        calcularYMostrarTotal(carroCompras)
    }

    private fun calcularYMostrarTotal(productos: List<Producto>) {
        val total = productos.sumOf { it.precio }

        val tvSubTotalFactura = findViewById<TextView>(R.id.tvSubtotal)
        tvSubTotalFactura.text = "Total: $${total}"

        
        val tvTotalFactura = findViewById<TextView>(R.id.tvTotalFactura)
        tvTotalFactura.text = "Total: $${total}"



    }
}