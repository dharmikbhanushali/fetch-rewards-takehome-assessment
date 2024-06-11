package com.example.fetchrewards_codingexcercise

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.List
import android.view.View

/** Mainactivity handles data requests and responses in a recyclerview*/
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: ItemAdapter
    private lateinit var errorMessage: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize recyclerview and set layout manager
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // textview for error messages
        errorMessage = findViewById(R.id.errorMessage)

        fetchItems()
    }

    /** This function fetches items from the API and handles the response*/
    private fun fetchItems(){
        val fetchService = fetchClient.getRetrofitInstance().create(fetchService::class.java)
        val call = fetchService.items

        call.enqueue(object : Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {

                // this filters and sorts the items in the list based on requirements
                //this sorts results first by listID and then by name(considering name as a string and sorting it lexicographically)
                if (response.isSuccessful && response.body() != null) {
                    val items = response.body()!!
                        .filter { it.name != null && it.name!!.isNotEmpty() }
                        .sortedWith(compareBy({ it.listId }, { it.name }))

                  // Alternate solution - if we want to sort the name by considering it as a string
                  //consider the substring after "Item " and sort it numerically
//                if (response.isSuccessful && response.body() != null) {
//                    val items = response.body()!!
//                        .filter { it.name != null && it.name!!.isNotEmpty() }
//                        .sortedWith(compareBy({ it.listId }, { it.name!!.substringAfter("Item ").toIntOrNull() ?: 0 }))

                    itemAdapter = ItemAdapter(items)
                    recyclerView.adapter = itemAdapter
                    recyclerView.visibility = View.VISIBLE
                    errorMessage.visibility = View.GONE
                } else {
                    showError("Failed to load data")
                }
            }

            /** error message if APi call fails*/
            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                showError("Cannot fetch api data")
            }
        })
    }

    //display error message and hide the recyclerview
    private fun showError(message: String) {
        errorMessage.text = message
        errorMessage.visibility = View.VISIBLE
        recyclerView.visibility = View.GONE
    }
}
