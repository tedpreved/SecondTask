package com.mytsyk.yalantis.secondtask.model;


public class ItemTestData {
    private String mTitle;
    private String mAddress;
    private String mDate;
    private String mDaysCount;

    public ItemTestData() {
        this.mDaysCount = null;
    }

    public ItemTestData(String title, String address, String date, String daysCount) {
        this.mTitle = title;
        this.mAddress = address;
        this.mDate = date;
        this.mDaysCount = daysCount;
    }

    public ItemTestData(String title, String address, String date) {
        this.mTitle = title;
        this.mAddress = address;
        this.mDate = date;
        this.mDaysCount = null;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        this.mAddress = address;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public String getDaysCount() {
        return mDaysCount;
    }

    public void setDaysCount(String daysCount) {
        this.mDaysCount = daysCount;
    }
}
