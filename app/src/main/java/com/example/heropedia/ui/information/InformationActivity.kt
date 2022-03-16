package com.example.heropedia.ui.information

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.heropedia.R
import com.example.heropedia.data.response.HeroInformation
import com.example.heropedia.ui.utils.Constants
import com.example.heropedia.ui.utils.loading.LoadingDialog
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_description.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.list_item_hero.view.*

class InformationActivity : AppCompatActivity(), InformationContract.View {

    private lateinit var hero: HeroInformation

    private val progressDialog = LoadingDialog()
    private lateinit var heroe: HeroInformation
    private val presenter: InformationContract.Presenter by lazy {
        InformationPresenter().apply {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)
        presenter.attachView(this@InformationActivity)
        getExtras()
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

    private fun getExtras() {
        hero = intent.getParcelableExtra("hero")
        displayData(hero)

    }

    private fun setListeners() {
        include.setOnClickListener { onBackPressed() }
    }


    private fun displayData(hero: HeroInformation) {
        heroName.text = hero.name
        Picasso.get()
            .load(hero.image.url)
            .error(R.drawable.ic_default_empty)
            .into(heroPictureIv, object : Callback {
                override fun onSuccess() {}
                override fun onError(e: Exception?) {}
            })
        fullname.text = hero.biography.fullName
        alteregos.text = hero.biography.alterEgo
        aliases.text = hero.biography.aliases.toString()
        placeBirth.text = hero.biography.placeOfBirth
        firstAppearance.text = hero.biography.firstAppearance
        publisher.text = hero.biography.publisher
        alignment.text = hero.biography.alignment
        gender.text = hero.appearance.gender
        race.text = hero.appearance.race
        height.text = hero.appearance.height.toString()
        weight.text = hero.appearance.weight.toString()
        eyeColor.text = hero.appearance.eyeColor
        hairColor.text = hero.appearance.hairColor
        occupation.text = hero.work.occupation
        base.text = hero.work.base
        when (hero.biography.alignment){
            Constants.ALIGNMENT_NEUTRAL ->  descriptionCl.background = getDrawable(R.drawable.bg_gradient_neutral)
            Constants.ALIGNMENT_HERO -> descriptionCl.background = getDrawable(R.drawable.bg_gradient_hero)
            else -> descriptionCl.background = getDrawable(R.drawable.bg_gradient_villan)
        }
    }

    override fun displayError() {
        Toast.makeText(this@InformationActivity, getString(R.string.error), Toast.LENGTH_SHORT)
            .show()
    }

    override fun displayLoading(loading: Boolean) {
        if (loading) progressDialog.show(this)
        else progressDialog.dialog.dismiss()
    }
}