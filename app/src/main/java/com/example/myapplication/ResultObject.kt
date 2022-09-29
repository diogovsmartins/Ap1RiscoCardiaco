package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable

data class ResultObject(
    var ageQuestionAnswer:String?):Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(ageQuestionAnswer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ResultObject> {
        override fun createFromParcel(parcel: Parcel): ResultObject {
            return ResultObject(parcel)
        }

        override fun newArray(size: Int): Array<ResultObject?> {
            return arrayOfNulls(size)
        }
    }
}