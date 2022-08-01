package com.example.test.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.test.R
import com.example.test.databinding.PersonElementBinding
import com.example.test.model.ModelJSONItem

class RecyclerAdapter(private val clickListener: ClickListener, private val context : Context) : RecyclerView.Adapter<RecyclerAdapter.PersonHolder>() {

    private var persons = ArrayList<ModelJSONItem>()

    class PersonHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = PersonElementBinding.bind(itemView)

        fun bind(person: ModelJSONItem, clickListener: ClickListener, context: Context) = with(binding) {
            textName.text = person.name
            Glide.with(context).load(person.picture).into(binding.imageFoto)
            binding.element.setOnClickListener {
                clickListener.onClick(person)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        return PersonHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.person_element, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.bind(persons[position],clickListener, context)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(newPersons: ArrayList<ModelJSONItem>) {
        persons.clear()
        persons.addAll(newPersons)
        notifyDataSetChanged()
    }
}
interface ClickListener {
    fun onClick(person: ModelJSONItem)
}