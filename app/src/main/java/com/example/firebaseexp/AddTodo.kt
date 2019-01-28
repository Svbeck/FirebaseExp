package com.example.firebaseexp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.FirebaseDatabase

class AddTodo : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.add_todo, container,false)

        val db = FirebaseDatabase.getInstance()
        val todoRef = db.getReference("Todo")

        val addTodoButton = rootView.findViewById<Button>(R.id.add__todo_button)
        val todoInputText = rootView.findViewById<TextInputEditText>(R.id.add_todo_input)

        addTodoButton.setOnClickListener {

            //Send input to Firebase db
            todoRef.push().setValue(todoInputText.text.toString())
        }

        return rootView
    }
}