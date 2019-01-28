package com.example.firebaseexp.Model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable
import java.net.IDN

class Todo(
    var ID: Long  = 0,
    var text : String = ""
    ) : Serializable{

    override fun toString(): String {
        return "Todo{" + "id=" + ID + ", text=" + text + "}"
    }

}