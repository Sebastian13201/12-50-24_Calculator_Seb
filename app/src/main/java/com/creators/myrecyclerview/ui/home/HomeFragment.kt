package com.creators.myrecyclerview.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.creators.myrecyclerview.databinding.FragmentHomeBinding
import com.creators.myrecyclerview.ui.home.PetList.dogList

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        binding.rvPets.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = PetsAdapater(dogList)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

object PetList {
    val dogList = listOf(
        "Husky",
        "German Shepherd",
        "Labrador",
        "Golden Retriever",
        "Great Dane",
        "Chiwawa",
        "Shiba",
        "Husky",
        "German Shepherd",
        "Labrador",
        "Golden Retriever",
        "Great Dane",
        "Chiwawa",
        "Shiba",
        "Husky",
        "German Shepherd",
        "Labrador",
        "Golden Retriever",
        "Great Dane",
        "Chiwawa",
        "Shiba",
        "Husky",
        "German Shepherd",
        "Labrador",
        "Golden Retriever",
        "Great Dane",
        "Chiwawa",
        "Shiba"
    )
}