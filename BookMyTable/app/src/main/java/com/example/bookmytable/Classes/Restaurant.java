package com.example.bookmytable.Classes;

import android.widget.RelativeLayout;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name,lat,lng,openTime,closeTime,description,image_source,tables,tableImage;

    public Restaurant(){}

    public Restaurant(String name,String lat,String lng,String openTime,String closeTime,String description,String image_source,String tables,String tableImage){
        this.name=name;
        this.lat=lat;
        this.lng=lng;
        this.openTime=openTime;
        this.closeTime=closeTime;
        this.description=description;
        this.image_source=image_source;
        this.tables=tables;
        this.tableImage=tableImage;
    }


    public String getTableImage() {
        return tableImage;
    }

    public void setTableImage(String tableImage) {
        this.tableImage = tableImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_source() {
        return image_source;
    }

    public void setImage_source(String image_source) {
        this.image_source = image_source;
    }

    public String getTables() {
        return tables;
    }

    public void setTables(String tables) {
        this.tables = tables;
    }
}
