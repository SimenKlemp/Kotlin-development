package com.example.ooving3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EditFriendActivity: Activity() {

    private var friends: Array<String> = arrayOf()
    private var posisjon = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        friends = intent.getStringArrayExtra("friendList") as Array<String>
        posisjon = intent.getIntExtra("posisjon", posisjon)
        editFriend(posisjon)

        setResult(RESULT_OK, Intent().putExtra("updatedFriends", friends))

    }

    fun editFriend(posisjon: Int) {
            findViewById<EditText>(R.id.addName).setText(
                friends[posisjon],
                TextView.BufferType.EDITABLE)

        findViewById<Button>(R.id.addFriendButton).setOnClickListener {
                var newName = findViewById<EditText>(R.id.addName).text.toString()
               // var newDate = findViewById<EditText>(R.id.addDate).text.toString()

                friends[posisjon]  = newName

                finish()

            }
        }
    }
