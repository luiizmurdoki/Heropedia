package com.example.heropedia.ui.search

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heropedia.R
import com.example.heropedia.data.response.HeroInformation
import com.example.heropedia.ui.search.adapter.HeroListAdapter
import com.example.heropedia.ui.utils.loading.LoadingDialog
import kotlinx.android.synthetic.main.activity_search.*


class SearchActivity : AppCompatActivity(), SearchContract.View {

    private val progressDialog = LoadingDialog()
    private val presenter: SearchContract.Presenter by lazy {
        SearchPresenter().apply {}
    }

    private  val heroListAdapter: HeroListAdapter by lazy {
        val heroListAdapter = HeroListAdapter(this)
        heroRv.adapter = heroListAdapter
        heroRv.layoutManager = LinearLayoutManager(this)
        heroListAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        presenter.attachView(this@SearchActivity)
        setListeners()
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

    override fun displayError() {
        Toast.makeText(this@SearchActivity, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    private fun setListeners() {
        searchBtn.setOnClickListener {
            if (searchTv.text.isNotEmpty()) presenter.getSuperHeroList(searchTv.text.toString())
        }
    }


    override fun adapterData(data : List<HeroInformation>) {
        heroListAdapter.heroes = data
    }

    override fun displayLoading(loading: Boolean) {
        if(loading) progressDialog.show(this)
        else  progressDialog.dialog.dismiss()
    }
}