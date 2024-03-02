package com.example.shopping_cart

import java.io.Serializable

data class Producto(
    var idProducto: String,
    var nomProducto: String,
    var descripcion: String,
    var precio: Double
): Serializable
