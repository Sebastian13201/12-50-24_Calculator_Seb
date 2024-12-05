package com.creators.myrecyclerview.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.creators.myrecyclerview.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var currValue: Double = 1.0
    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.apply {
            updateUi()
            dispCurren.doAfterTextChanged {
                text ->
                currValue = text.toString().toDouble()
            }

            convJap.setOnClickListener{
                currValue = currValue*0.0067
                    updateUi()
            }
            convUs.setOnClickListener {
                currValue = currValue * 149.39
                    updateUi()
            }
        }
        return root
    }
    private fun updateUi() {
        binding.dispCurren.setText(
            currValue.toFloat().toString()
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}