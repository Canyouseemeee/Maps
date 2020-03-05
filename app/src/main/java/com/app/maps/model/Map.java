package com.app.maps.model;

public class Map {

    private String MapID;
    private String OrderID;
    private double Latitude;
    private double Longitude;

    public Map() {
    }

    public Map(String mapID, String orderID, double latitude, double longitude) {
        MapID = mapID;
        OrderID = orderID;
        Latitude = latitude;
        Longitude = longitude;
    }

    public String getMapID() {
        return MapID;
    }

    public void setMapID(String mapID) {
        MapID = mapID;
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
