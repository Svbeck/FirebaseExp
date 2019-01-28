package com.example.firebaseexp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TodoViewModel : ViewModel() {
    val db = FirebaseDatabase.getInstance()
    val todoRef = db.getReference("Todo")
    private lateinit var todoArray: Array<String>

    private var todoText = MutableLiveData<List<String>>()

    fun getTodos(): LiveData<List<String>>{
        todoText = MutableLiveData()

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var todoList = Array<String>(1,{i -> ""})
                todoList.set(0, dataSnapshot.getValue().toString())
                todoArray = parseDBGetToArray(todoList[0])

                Log.i("Get", todoList[0])
                Log.i("ParcedArray", todoArray[todoArray.size-1])

                todoText.value = todoList.toList()
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Log.w("XXXXXXXXXXX", "loadPost:onCancelled", databaseError.toException())            }
        }
        todoRef.addValueEventListener(postListener)

        return todoText
    }

    fun parseDBGetToArray(TodoString:String):Array<String> = TodoString
        .split(",").toTypedArray()


}