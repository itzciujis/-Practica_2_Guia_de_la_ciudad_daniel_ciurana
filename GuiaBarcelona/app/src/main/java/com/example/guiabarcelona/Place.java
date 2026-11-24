package com.example.guiabarcelona;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class Place implements Parcelable {

    private final String name;
    private final String shortDescription;
    private final String description;
    private final String address;
    private final String phone;
    private final String website;
    private final double latitude;
    private final double longitude;
    private final int imageRes;

    public Place(String name, String shortDescription, String description, String address,
                 String phone, String website, double latitude, double longitude,
                 @DrawableRes int imageRes) {
        this.name = name;
        this.shortDescription = shortDescription;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageRes = imageRes;
    }

    protected Place(Parcel in) {
        name = in.readString();
        shortDescription = in.readString();
        description = in.readString();
        address = in.readString();
        phone = in.readString();
        website = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        imageRes = in.readInt();
    }

    public String getName() {
        return name;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getImageRes() {
        return imageRes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(shortDescription);
        dest.writeString(description);
        dest.writeString(address);
        dest.writeString(phone);
        dest.writeString(website);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeInt(imageRes);
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };
}
