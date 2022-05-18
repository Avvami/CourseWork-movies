package com.bignerdranch.android.coursework_movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.coursework_movies.data.ResourceData
import com.bignerdranch.android.coursework_movies.screens.fragments.adapters.rvAdapter
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ResourcelistActivity : AppCompatActivity() {

    //private lateinit var dbref : DatabaseReference
    private lateinit var resourceRecyclerView : RecyclerView
    private lateinit var resourceArrayList : ArrayList<ResourceData>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlist_activiry)

        resourceRecyclerView = findViewById(R.id.resourceList)
        resourceRecyclerView.layoutManager = LinearLayoutManager(this)
        resourceRecyclerView.setHasFixedSize(true)

        resourceArrayList = arrayListOf<ResourceData>()
        getResourceData()
    }

    private fun getResourceData() {

        val dbref = Firebase.database.getReference("movies")
        //dbref = FirebaseDatabase.getInstance().getReference("movies")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(p0: DataSnapshot) {

                if (p0.exists()) {

                    for (resourceSnapshot in p0.children) {

                        val resource = resourceSnapshot.getValue(ResourceData::class.java)
                        resourceArrayList.add(resource!!)

                        Log.d("Data", resourceArrayList.toString())
                    }

                    resourceRecyclerView.adapter = rvAdapter(resourceArrayList)
                }
            }

            override fun onCancelled(p0: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}