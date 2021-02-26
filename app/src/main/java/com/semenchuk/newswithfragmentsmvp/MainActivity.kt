package com.semenchuk.newswithfragmentsmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.semenchuk.newswithfragmentsmvp.classes.FirstFragment
import com.semenchuk.newswithfragmentsmvp.classes.SecondFragment
import com.semenchuk.newswithfragmentsmvp.models.CategoryNewsAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isFirstFragmentLoaded = true
    private val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categoryListOfNews: ArrayList<String> = ArrayList()

        categoryListOfNews.add("Top")
        categoryListOfNews.add("Hello world")

        for (i in categoryListOfNews.size+1..10) {
            categoryListOfNews.add("Another item $i")
        }




        newsCategoryRecyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        newsCategoryRecyclerView.adapter = CategoryNewsAdapter(categoryListOfNews)


        showFragmentOne()

        btn_change.setOnClickListener {
            if (isFirstFragmentLoaded) {
                showFragmentTwo()
            } else {
                showFragmentOne()
            }
        }
    }

    private fun showFragmentOne() {
        val fragment = FirstFragment()
        manager.beginTransaction()
                .replace(R.id.fragment_holder, fragment)
                .addToBackStack(null)
                .commit()
        isFirstFragmentLoaded = true
    }

    private fun showFragmentTwo() {
        val fragment = SecondFragment()
        manager.beginTransaction()
                .replace(R.id.fragment_holder, fragment)
                .addToBackStack(null)
                .commit()
        isFirstFragmentLoaded = false

    }
}