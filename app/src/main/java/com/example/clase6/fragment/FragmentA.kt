package com.example.clase6.fragment
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.clase6.Dialogos.DialogoEstandar.Companion.showDialog
import com.example.clase6.Dialogos.DialogoPersonalizado.Companion.showDialogPersonalizado
import com.example.clase6.R
import com.example.clase6.databinding.FragmentABinding
import java.util.Calendar

class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding
    private lateinit var calendar: Calendar;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentABinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calendar = Calendar.getInstance()
        //navigationStandar()
        navigationFragmentB()
        pasarDataEntreFragments()
        dialogoEstandar()
        dialogoPersonalizado()
        dialogoDataPicker()
        dialogoTimePicker()
        cardView()

    }

//    private fun navigationStandar() {
//        binding.btnFragmentB.setOnClickListener {
//            val fragmentB = FragmentB()
//            val transaction = requireActivity().supportFragmentManager.beginTransaction()
//            transaction.replace(R.id.fragmentContainerStatic, fragmentB)
//            transaction.addToBackStack(null) // Opcional, para permitir retroceder
//            transaction.commit()
//        }
//    }

    private fun navigationFragmentB(){
        binding.btnNavFragmentB.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentA_to_fragmentB)
        }
    }

    private fun pasarDataEntreFragments() {

        binding.btnPasarDatos.setOnClickListener {

            val dataEditText = binding.etName.text.toString()
            val bundle = Bundle()
            bundle.putString("clave", dataEditText)
            findNavController().navigate(R.id.action_fragmentA_to_fragmentB, bundle)
        }
    }

    private  fun dialogoEstandar(){
        binding.btnDialogStandar.setOnClickListener {
            showDialog(binding.root.context).show()
        }
    }

    private  fun dialogoPersonalizado(){
        binding.btnDialogPersonalizado.setOnClickListener {
            showDialogPersonalizado(binding.root.context)

        }
    }

    private  fun dialogoDataPicker(){
        binding.tvDataPicker.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private  fun dialogoTimePicker(){
        binding.tvTimePicker.setOnClickListener {
            showDateTimePicker()
        }
    }

    private fun showDateTimePicker() {
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        // Crea una instancia de TimePickerDialog
        val timePickerDialog = TimePickerDialog(
            context,
             { _, hourOfDay: Int, minuteOfHour: Int ->
                val selectedTime = "$hourOfDay:$minuteOfHour"
                Toast.makeText(context,"${selectedTime}", Toast.LENGTH_SHORT).show()
            },
            hour, // Hora inicial
            minute, // Minuto inicial
            true // Especifica si se muestra el modo de reloj de 24 horas
        )

        // Muestra el TimePickerDialog
        timePickerDialog.show()

    }

    private fun showDatePickerDialog() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
           { _, year: Int, monthOfYear: Int, dayOfMonth: Int ->

                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                Toast.makeText(context,"${selectedDate}", Toast.LENGTH_SHORT).show()
            },
            year,
            month,
            day
        )

        datePickerDialog.show()
    }

    private  fun cardView(){
        binding.btnCardView.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentA_to_fragmentCardView)

        }
    }
}