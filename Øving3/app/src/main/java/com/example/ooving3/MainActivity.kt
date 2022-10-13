package com.example.ooving3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : Activity() {
    private var friends: Array<String> = arrayOf()
    val firstRequestCode = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListView()

        findViewById<Button>(R.id.addFriendButton).setOnClickListener {
            var name = findViewById<EditText>(R.id.addName).text.toString()
            var date = findViewById<EditText>(R.id.addDate).text.toString()
            friends = friends.plus(name)
            initListView()
        }
    }

    fun initListView() {
        //Her bruker jeg en adapter for å fylle gridView fra en String tabell "friends". Bruker simpleListItemActivated for å markere det elementet man trykker på i gridVie
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_activated_1, friends)
        val gridView = findViewById<ListView>(R.id.friendList)
        //setter gridView fra xml fil til å være lik adapter.
        gridView.adapter = adapter
        //Forteller adapter at kun et element kan trykkes på om gangen
        gridView.choiceMode = ListView.CHOICE_MODE_SINGLE
        //Legger til listener på om man klikker på elementer i gridView. Avgjør ut i fra posisjon. Kan bruke dette til å sette textView til element som er trykket på.
        gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent: AdapterView<*>?, valgt: View, posisjon: Int, id: Long ->
                val intent = Intent("editFriendActivity")
                intent.putExtra("friendList", friends)
                intent.putExtra("posisjon", posisjon)
                startActivityForResult(intent, firstRequestCode)
            }
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (resultCode != RESULT_OK) {
            Log.e("onActivityResult()", "Noe gikk galt")
            return
        }
        if (requestCode == firstRequestCode) {
            friends = data.getStringArrayExtra("updatedFriends") as Array<String>
            initListView()
        }
    }
}

