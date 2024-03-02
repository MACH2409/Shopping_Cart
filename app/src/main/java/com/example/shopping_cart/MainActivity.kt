package com.example.shopping_cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopping_cart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : AdaptadorProducto

    var listaProductos = ArrayList<Producto>()
    var carroCompras = ArrayList<Producto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        agregarProductos()
        setupRecyclerView()
    }

    fun setupRecyclerView(){
        binding.rvListaProductos.layoutManager = LinearLayoutManager(this)
        adapter = AdaptadorProducto(this, binding.tvCantProductos, binding.btnVerCarro, listaProductos, carroCompras)
        binding.rvListaProductos.adapter = adapter
    }

    fun agregarProductos(){
        listaProductos.add(Producto("1","AIR JORDAN 1 RETRO HIGH OG 'Chicago Lost and Found'","Varsity Red/Black-Sail-Muslin",406.50))
        listaProductos.add(Producto("2","AIR JORDAN 1 RETRO HIGH OG 'UNC Toe'","University Blue/Black/White",183.00))
        listaProductos.add(Producto("3","AIR JORDAN 1 HIGH ZOOM COMFORT 2 'Bleached Aqua Citrus'","Bleached Aqua/Bright Citrus-Black-White",79.99))
        listaProductos.add(Producto("4","AIR JORDAN 1 RETRO HIGH OG 'Lucky Green'","Black/Lucky Green-White",137.00))
        listaProductos.add(Producto("5","AIR JORDAN 1 RETRO HIGH OG 'Colores y Vibras'","Multi-Color/Black-Pink Foam-Multi-Color",250.00))
        listaProductos.add(Producto("6","AIR JORDAN 1 RETRO HIGH UTILITY 'Prowler'","Black/Deadly Pink/Fierce Purple",500.00))
    }
}