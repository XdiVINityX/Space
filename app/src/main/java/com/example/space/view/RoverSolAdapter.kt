package com.example.space.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.space.R

class RoverSolAdapter : RecyclerView.Adapter<RoverSolAdapter.RoverSolHolder>() {

    private var solList = (1..1000).toList()

    inner class RoverSolHolder(itemView: View) : ViewHolder(itemView) {
        fun render(position: Int) {
            itemView.findViewById<TextView>(R.id.roverSol).text = position.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoverSolHolder {
        return RoverSolHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_sol_recycler_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 1000
    }

    override fun onBindViewHolder(holder: RoverSolHolder, position: Int) {
        holder.render(solList[position])
    }
}