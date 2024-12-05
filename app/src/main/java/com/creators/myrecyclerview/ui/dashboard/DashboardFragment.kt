package com.creators.myrecyclerview.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.creators.myrecyclerview.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private var display: String = ""

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.apply {
            updateUI()
            One.setOnClickListener {
                display = "${display+1}"
                updateUI()
            }
            Two.setOnClickListener {
                display = "${display+2}"
                updateUI()
            }
            Three.setOnClickListener {
                display = "${display+3}"
                updateUI()
            }
            Four.setOnClickListener {
                display = "${display+4}"
                updateUI()
            }
            Five.setOnClickListener {
                display = "${display+5}"
                updateUI()
            }
            Six.setOnClickListener {
                display = "${display+6}"
                updateUI()
            }
            Seven.setOnClickListener {
                display = "${display+7}"
                updateUI()
            }
            Eight.setOnClickListener {
                display = "${display+8}"
                updateUI()
            }
            Nine.setOnClickListener {
                display = "${display+9}"
                updateUI()
            }
            Zero.setOnClickListener {
                display = "${display+0}"
                updateUI()
            }
            Plus.setOnClickListener {
                display = "${display+"+"}"
                updateUI()
            }
            Minus.setOnClickListener {
                display = "${display+"-"}"
                updateUI()
            }
            Multiply.setOnClickListener {
                display = "${display+"*"}"
                updateUI()
            }
            Divide.setOnClickListener {
                display = "${display+"/"}"
                updateUI()
            }
            Equal.setOnClickListener {
                display=calculate(display)
                updateUI()
            }
            C.setOnClickListener {
                display = ""
                updateUI()
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun FragmentDashboardBinding.updateUI(){
        tvDisplay.text = display
    }


    fun calculate(input:String):String {
        var number:String = ""
        val numList = mutableListOf<Double>()
        val calculateList = mutableListOf<Char>()

        for (char in display){
            if(char.isDigit()){
                number = "${number + char}"
            }else{
                numList.add(number.toDouble())
                number = ""
                calculateList.add(char)
            }
        }
        numList.add((number.toDouble()))

        var total = 0.0
        var firstLap = true
        var opCounter = 0

        for(num in numList){
            if(firstLap){
                total = num
                firstLap = false
            }else{
                when(calculateList.get(opCounter)){
                    '+'->{
                        total += num
                        opCounter++
                    }
                    '-'->{
                        total - num

                        opCounter++
                    }
                    '*'->{
                        total *= num
                        opCounter++
                    }
                    '/'->{
                        total/= num
                        opCounter++
                    }
                }
            }
        }
        return total.toString()
    }
}