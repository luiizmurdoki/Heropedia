package com.example.heropedia.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class AllInformationHero(
    @SerializedName("response") val response: String?,
    @SerializedName("results-for") val resultsFor: String,
    @SerializedName("results") val results: List<HeroInformation>
) : Parcelable

@Parcelize
data class HeroInformation(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("powerstats") val powerstats: Power,
    @SerializedName("biography") val biography: Biography,
    @SerializedName("appearance") val appearance: Appearance,
    @SerializedName("work") val work: Work,
    @SerializedName("connections") val connections: Connections,
    @SerializedName("image") val image: Image
) : Parcelable

@Parcelize
data class Power(
    @SerializedName("intelligence") val intelligence: String,
    @SerializedName("strength") val strength: String,
    @SerializedName("speed") val speed: String,
    @SerializedName("durability") val durability: String,
    @SerializedName("power") val power: String,
    @SerializedName("combat") val combat: String
) : Parcelable

@Parcelize
data class Biography(
    @SerializedName("full-name") val fullName: String,
    @SerializedName("alter-egos") val alterEgo: String,
    @SerializedName("aliases") val aliases: List<String>,
    @SerializedName("place-of-birth") val placeOfBirth: String,
    @SerializedName("first-appearance") val firstAppearance: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("alignment") val alignment: String
) : Parcelable

@Parcelize
data class Appearance(
    @SerializedName("gender") val gender: String,
    @SerializedName("race") val race: String,
    @SerializedName("height") val height: List<String>,
    @SerializedName("weight") val weight: List<String>,
    @SerializedName("eye-color") val eyeColor: String,
    @SerializedName("hair-color") val hairColor: String
) : Parcelable

@Parcelize
data class Work(
    @SerializedName("occupation") val occupation: String,
    @SerializedName("base") val base: String
) : Parcelable

@Parcelize
data class Connections(
    @SerializedName("group-affiliation") val groupAffiliation: String,
    @SerializedName("relatives") val relatives: String
) : Parcelable

@Parcelize
data class Image(
    @SerializedName("url") val url: String
) : Parcelable