package com.example.lab3_spinners

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    val names = listOf<String>("Sarah", "Dan", "Christina", "Maya", "Kevin", "Chris", "Matt", "Emma")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // spinner 1
        val spinner1: Spinner = findViewById(R.id.spinner1)
        spinner1.onItemSelectedListener = this

        // Spinner 2
        val spinner2: Spinner = findViewById(R.id.spinner2)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
                this,
                R.array.nba_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner2.adapter = adapter
        }
        spinner2.onItemSelectedListener = this


        // Spinner 3
        spinner3.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, names)
        spinner3.onItemSelectedListener = this

    }

    // Interface
    override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)

        // The parent object passed into the method is the spinner in which the item was selected
        val selection = parent.getItemAtPosition(pos) as? String
        Log.d("ItemSelected", parent.getItemAtPosition(pos) as? String)

        // get spinner id
         when(parent.id) {
                R.id.spinner3 ->
                        textView3.text = "Welcome, " + parent.getItemAtPosition(pos) as? String
                R.id.spinner2 ->
                        Toast.makeText(this, selection, Toast.LENGTH_SHORT).show()
                R.id.spinner1 ->
                        Toast.makeText(this, selection, Toast.LENGTH_SHORT).show()
         }

    }

    override fun onNothingSelected(parent: AdapterView<*>) {
        // Another interface callback
    }

}
