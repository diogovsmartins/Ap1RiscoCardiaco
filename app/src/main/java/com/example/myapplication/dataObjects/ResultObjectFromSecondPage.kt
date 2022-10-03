package com.example.myapplication.dataObjects

import android.os.Parcel
import android.os.Parcelable

data class ResultObjectFromSecondPage(var secondPageResults:Array<String>):Parcelable {
    constructor(parcel: Parcel) : this(parcel.createStringArray() as Array<String>) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringArray(secondPageResults)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultObjectFromSecondPage> {
        override fun createFromParcel(parcel: Parcel): ResultObjectFromSecondPage {
            return ResultObjectFromSecondPage(parcel)
        }

        override fun newArray(size: Int): Array<ResultObjectFromSecondPage?> {
            return arrayOfNulls(size)
        }
    }
}