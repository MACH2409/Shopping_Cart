package com.example.shopping_cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping_cart.databinding.ActivityCarroComprasBinding

class CarroComprasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCarroComprasBinding
    private lateinit var adapter: AdaptadorCarroCompras

    var carroCompras = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCarroComprasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtención de datos para el carro de compras
        carroCompras = intent.getSerializableExtra("carro_compras") as ArrayList<Producto>

        setupRecyclerView()
    }

    fun setupRecyclerView(){
        binding.rvListaCarro.layoutManager = LinearLayoutManager(this)
        adapter = AdaptadorCarroCompras(binding.tvTotal, carroCompras)
        binding.rvListaCarro.adapter = adapter
    }
}