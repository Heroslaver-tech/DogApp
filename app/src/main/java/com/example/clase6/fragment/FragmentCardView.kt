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
import com.example.clase6.databinding.FragmentCardViewBinding
import java.util.Calendar

class FragmentCardView : Fragment() {

    private lateinit var binding: FragmentCardViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCardViewBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}