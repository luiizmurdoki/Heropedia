package com.example.heropedia.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.heropedia.R
import com.example.heropedia.ui.search.SearchActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item_hero.*
import kotlinx.android.synthetic.main.list_item_hero.view.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private val presenter: MainContract.Presenter by lazy {
        MainPresenter().apply {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this@MainActivity)
        setListener()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onPause() {
        super.onPause()
    }

    private fun setListener(){
        letsGoBtn.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java).apply{}
            startActivity(intent)
        }
    }

    override fun displayError() {
        Toast.makeText(this@MainActivity, getString(R.string.error), Toast.LENGTH_SHORT).show()
    }
}