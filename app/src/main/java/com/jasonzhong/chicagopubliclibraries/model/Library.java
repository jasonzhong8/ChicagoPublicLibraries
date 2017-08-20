package com.jasonzhong.chicagopubliclibraries.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by junzhong on 2017-08-20.
 */

public class Library implements Parcelable {
    private String teacher_in_the_library;
    private String zip;
    private String hours_of_operation;
    private String website;
    private String address;
    private String city;
    private String phone;
    private String latitude;
    private String longitude;
    private boolean needs_recoding;
    private String state;
    private String cybernavigator;
    private String name_;

    public String getTeacher_in_the_library() {
        return teacher_in_the_library;
    }

    public void setTeacher_in_the_library(String teacher_in_the_library) {
        this.teacher_in_the_library = teacher_in_the_library;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getHours_of_operation() {
        return hours_of_operation;
    }

    public void setHours_of_operation(String hours_of_operation) {
        this.hours_of_operation = hours_of_operation;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public boolean isNeeds_recoding() {
        return needs_recoding;
    }

    public void setNeeds_recoding(boolean needs_recoding) {
        this.needs_recoding = needs_recoding;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCybernavigator() {
        return cybernavigator;
    }

    public void setCybernavigator(String cybernavigator) {
        this.cybernavigator = cybernavigator;
    }

    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }

    @Override
    public String toString() {
        return "Library{" +
                "teacher_in_the_library='" + teacher_in_the_library + '\'' +
                ", zip='" + zip + '\'' +
                ", hours_of_operation='" + hours_of_operation + '\'' +
                ", website='" + website + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", needs_recoding=" + needs_recoding +
                ", state='" + state + '\'' +
                ", cybernavigator='" + cybernavigator + '\'' +
                ", name_='" + name_ + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.teacher_in_the_library);
        dest.writeString(this.zip);
        dest.writeString(this.hours_of_operation);
        dest.writeString(this.website);
        dest.writeString(this.address);
        dest.writeString(this.city);
        dest.writeString(this.phone);
        dest.writeString(this.latitude);
        dest.writeString(this.longitude);
        dest.writeByte(this.needs_recoding ? (byte) 1 : (byte) 0);
        dest.writeString(this.state);
        dest.writeString(this.cybernavigator);
        dest.writeString(this.name_);
    }

    public Library() {
    }

    protected Library(Parcel in) {
        this.teacher_in_the_library = in.readString();
        this.zip = in.readString();
        this.hours_of_operation = in.readString();
        this.website = in.readString();
        this.address = in.readString();
        this.city = in.readString();
        this.phone = in.readString();
        this.latitude = in.readString();
        this.longitude = in.readString();
        this.needs_recoding = in.readByte() != 0;
        this.state = in.readString();
        this.cybernavigator = in.readString();
        this.name_ = in.readString();
    }

    public static final Parcelable.Creator<Library> CREATOR = new Parcelable.Creator<Library>() {
        @Override
        public Library createFromParcel(Parcel source) {
            return new Library(source);
        }

        @Override
        public Library[] newArray(int size) {
            return new Library[size];
        }
    };
}

