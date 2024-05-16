package com.example.project.view.fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.project.databinding.FragmentFormBinding
import com.example.project.model.Pet
import com.example.project.viewmodel.PetViewModel
import androidx.lifecycle.Observer
import androidx.lifecycle.LifecycleOwner

class FragmentForm : Fragment() {

    private lateinit var binding: FragmentFormBinding
    private val petViewModel: PetViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        drivers()
        //observerViewModel()
    }

    private fun drivers() {
        validarDatos()
        binding.btnSavePet.setOnClickListener {
            savePet()
        }


    }
    private fun savePet(){
        val name = binding.etName.text.toString()
        val race = binding.etRace.text.toString()
        val namePerson = binding.etNamePerson.text.toString()
        val tel = binding.etTel.text.toString().toLong()
        // Obtener el índice del elemento seleccionado en el Spinner
        val selectedPosition = binding.spSymptom.selectedItemPosition
        // Obtener el valor del elemento seleccionado utilizando el índice
        val symptom = binding.spSymptom.getItemAtPosition(selectedPosition).toString()
        val newPet = Pet(name = name, race = race, namePerson = namePerson, tel = tel, symptom = symptom)
        petViewModel.savePet(newPet)
        Log.d("test",newPet.toString())
        Toast.makeText(context,"Artículo guardado !!", Toast.LENGTH_SHORT).show()
        findNavController().popBackStack()

    }

    //Verifica que los datos se hayan llenado antes de mandar
    private fun validarDatos() {
        val listEditText = listOf(binding.etName, binding.etRace, binding.etNamePerson, binding.etTel)
        val spinner = binding.spSymptom // suponiendo que spinner es tu Spinner

        // Verifica solo los editText
        listEditText.forEach { editText ->
            editText.addTextChangedListener {
                val isListFull = listEditText.all { it.text.isNotEmpty() } && spinner.selectedItemPosition != 0
                binding.btnSavePet.isEnabled = isListFull
            }
        }

        //Verifica el spinner
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val isListFull = listEditText.all { it.text.isNotEmpty() } && position != 0
                binding.btnSavePet.isEnabled = isListFull
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No necesitamos hacer nada aquí
            }
        }
    }

}