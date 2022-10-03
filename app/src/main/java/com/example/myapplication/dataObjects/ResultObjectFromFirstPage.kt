package com.example.myapplication.dataObjects

import android.os.Parcel
import android.os.Parcelable

data class ResultObjectFromFirstPage(var firstPageResults:Array<String>):Parcelable {
    constructor(parcel: Parcel) : this(parcel.createStringArray() as Array<String>) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringArray(firstPageResults)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultObjectFromFirstPage> {
        override fun createFromParcel(parcel: Parcel): ResultObjectFromFirstPage {
            return ResultObjectFromFirstPage(parcel)
        }

        override fun newArray(size: Int): Array<ResultObjectFromFirstPage?> {
            return arrayOfNulls(size)
        }
    }
}