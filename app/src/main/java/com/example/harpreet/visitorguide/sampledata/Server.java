package com.example.harpreet.visitorguide.sampledata;

public class Server {

    public String model;

    public Server() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Server(String url) {
        this.model = url;
    }

}
