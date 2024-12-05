package com.creators.myrecyclerview.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.creators.myrecyclerview.R

class PetsAdapater(
    val petsList: List<String>
): RecyclerView.Adapter<PetsAdapater.MyViewHolder>() {

//    val pets = petsList

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
// TODO: Handle individual UI element and settings
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_pet, parent, false)
        )
    }

    override fun getItemCount() = petsList.size

//    override fun getItemCount(): Int {
//        return petsList.size
//    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // TODO: Handle the individual current item in the list
    }


}