package com.example.heropedia.ui.search.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.heropedia.R
import com.example.heropedia.data.response.AllInformationHero
import com.example.heropedia.data.response.HeroInformation
import com.example.heropedia.ui.information.InformationActivity
import com.example.heropedia.ui.utils.base.SimpleBaseRecyclerViewAdapter
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.list_item_hero.view.*

class HeroListAdapter(context: Context) :  SimpleBaseRecyclerViewAdapter(context) {

    var heroes = listOf<HeroInformation>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getDisplayableItemsCount(): Int = heroes.size

    override fun onBindRecyclerViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is ItemViewHolder) {
            holder.bind(heroes[position])
        }
    }

    override fun getItemViewHolder(parent: ViewGroup?): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_hero, parent, false)
        return ItemViewHolder(view)
    }

    override fun getEmptyViewHolder(parent: ViewGroup?): androidx.recyclerview.widget.RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.empty_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(hero: HeroInformation) {
            itemView.name.text = hero.name
            Picasso.get()
                .load(hero.image.url)
                .error(R.drawable.ic_default_empty)
                .into(itemView.picture, object : Callback {
                    override fun onSuccess() {}
                    override fun onError(e: Exception?) {}
                })
            itemView.setOnClickListener {
                val intent = Intent(context, InformationActivity::class.java)
                intent.putExtra("hero", hero)
                context.startActivity(intent)
            }
        }
    }

}