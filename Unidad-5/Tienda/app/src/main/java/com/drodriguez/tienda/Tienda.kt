package com.drodriguez.tienda

data class Tienda(
    var id: Int = 0,
    var name: String, var phone: String = "", var isActive: Boolean = false
)