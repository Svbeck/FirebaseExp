package com.example.firebaseexp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoRecyclerViewAdapter(private val todoDataset: Array<String>):RecyclerView.Adapter<TodoRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(textView: TextView) : RecyclerView.ViewHolder(textView){
        var todo : TextView = textView.findViewById(R.id.TodoTextItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = LayoutInflater.from(parent.context).inflate(R.layout.list_todo, parent, false) as TextView
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.todo.text = todoDataset[position]
    }

    override fun getItemCount() = todoDataset.size
}