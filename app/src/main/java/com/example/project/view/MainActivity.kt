package com.example.project.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //fragmentDinamico()

    }

//    private fun fragmentDinamico() {
//
//        // Obtén una instancia del FragmentManager
//        val fragmentManager = supportFragmentManager
//        // Crea una instancia del fragmento
//        val fragmentA = FragmentA()
//        // Agrega el fragmento al contenedor pasando el id del contenedor fragmentContainerA y el fragment
//        fragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainerDinamic, fragmentA)
//            .commit()
//    }



}