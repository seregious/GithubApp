package com.example.githubtestapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubtestapp.R
import com.example.githubtestapp.databinding.RepCardBinding
import com.example.githubtestapp.domain.Rep

class RepAdapter(
    private val listener: Listener
): RecyclerView.Adapter<RepAdapter.RepHolder>() {

    var repList: List<Rep> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class RepHolder(view: View): RecyclerView.ViewHolder(view) {
        private var binding = RepCardBinding.bind(view)

        fun bind(rep: Rep, listener: Listener) = with(binding){
            repName.text = rep.name
            repLanguage.text = rep.language
            repDescription.text = rep.description
            itemView.setOnClickListener {
                listener.onClick(rep)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rep_card, parent, false)
        return RepHolder(view)
    }

    override fun onBindViewHolder(holder: RepHolder, position: Int) {
        holder.bind(repList[position], listener)
    }

    override fun getItemCount(): Int {
        return repList.size
    }

    interface Listener {
        fun onClick(rep: Rep)
    }
}