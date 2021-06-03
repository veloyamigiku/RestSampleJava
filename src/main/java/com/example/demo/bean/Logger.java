package com.example.demo.bean;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

// TODO Serializableの実装
@Entity
@Table(name = "logger")
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double longitude;

    private double latitude;

    private double altitude;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime gpstime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public LocalDateTime getGpstime() {
        return gpstime;
    }

    public void setGpstime(LocalDateTime gpstime) {
        this.gpstime = gpstime;
    }

}
