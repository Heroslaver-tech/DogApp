package com.example.project.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.R
import android.content.Intent
import androidx.navigation.findNavController
import com.example.project.fragment.fragmentLogin

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

    override fun onBackPressed() {
        // Obtener el ID del fragmento actual
        val currentDestination = findNavController(R.id.navigationContainer).currentDestination?.id

        // Verificar si el fragmento actual es FragmentB
        if (currentDestination == R.id.fragmentLogin) {
            // Por ejemplo, puedes utilizar un Intent para abrir la pantalla de inicio (launcher) del dispositivo
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } else {
            // Si el fragmento actual no es FragmentB, dejar que el comportamiento predeterminado del botón de retroceso funcione
            super.onBackPressed()
        }
    }

}