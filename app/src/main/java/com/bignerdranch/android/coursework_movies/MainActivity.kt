package com.bignerdranch.android.coursework_movies

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.bignerdranch.android.coursework_movies.screens.fragments.FavouriteFragment
import com.bignerdranch.android.coursework_movies.screens.fragments.MoviesFragment
import com.bignerdranch.android.coursework_movies.screens.fragments.SeriesFragment
import com.bignerdranch.android.coursework_movies.screens.fragments.adapters.ViewPagerAdapter
import com.google.firebase.database.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnTabs()

        button.setOnClickListener {
            val intent = Intent(this@MainActivity, ResourcelistActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setOnTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(MoviesFragment(), "ФИЛЬМЫ")
        adapter.addFragment(SeriesFragment(), "СЕРИАЛЫ")
        adapter.addFragment(FavouriteFragment(), "МОЙ СПИСОК")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}