package com.example.firebaseexp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaseexp.Model.Todo
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ListTodo : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.temp_textview, container,false)
        val todoTextView = rootView.findViewById<TextView>(R.id.temp_tv)

        val todoViewModel = ViewModelProviders.of(this).get(TodoViewModel::class.java)
        todoViewModel.getTodos().observe(this, Observer<List<String>>{todo ->
            todoTextView.text = todo[0]
        })

        return rootView
    }
}