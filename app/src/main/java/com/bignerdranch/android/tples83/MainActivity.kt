package com.bignerdranch.android.tples83

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var personsAdapter: PersonsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL))

        personsAdapter = PersonsAdapter(viewModel::deletePerson, viewModel::likePerson, viewModel::renamePerson)

        recyclerView.adapter = personsAdapter

        viewModel.person.observe(this){
            personsAdapter.reload(it)
        }

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            viewModel.addPerson()
        }
    }

}