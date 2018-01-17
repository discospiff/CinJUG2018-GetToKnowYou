package com.plantflashcards.gettoknowyoutoo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import com.plantflashcards.gettoknowyoutoo.dto.Shortcut

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var edtName : EditText
    lateinit var edtShortcut : EditText
    lateinit var edtPurpose: EditText
    lateinit var edtAllShortcuts: EditText

    lateinit var allShortcuts : ArrayList<Shortcut>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        edtName = findViewById(R.id.edtName)
        edtShortcut = findViewById(R.id.edtShortcut)
        edtPurpose = findViewById(R.id.edtPurpose)
        edtAllShortcuts = findViewById(R.id.edtAllShortcuts)
        allShortcuts = ArrayList<Shortcut>()

        fab.setOnClickListener { view ->
            saveAndClear()
        }
    }

    fun saveAndClear() {
        val shortcut = Shortcut(name = edtName.text.toString(), shortcut = edtShortcut.text.toString(), purpose= edtPurpose.text.toString())
        allShortcuts.add(shortcut)
        edtAllShortcuts.append(shortcut.toString())
        edtAllShortcuts.append("\n")
        edtName.setText("");
        edtShortcut.setText("");
        edtPurpose.setText("");
    }

    fun filter(v: View) {
        edtAllShortcuts.setText("");
        val filteredShortcuts = allShortcuts.filter {!it.shortcut.contains("Control V")}
        filteredShortcuts.forEach{value -> edtAllShortcuts.append(value.toString())}

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
