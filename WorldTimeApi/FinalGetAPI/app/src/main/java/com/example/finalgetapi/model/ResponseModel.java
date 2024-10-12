package com.example.finalgetapi.model;
import java.io.Serializable;
public class ResponseModel implements Serializable {
    private String abbreviation;
    private String client_ip;
    private String datetime;
    private int day_of_week;
    private int day_of_year;
    private boolean dst;
    private String dst_from;
    private int dst_offset;
    private String dst_until;
    private int raw_offset;
    private String timezone;
    private long unixtime;
    private String utc_datetime;
    private String utc_offset;
    private int week_number;

    // Getters and Setters
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getClientIp() {
        return client_ip;
    }

    public void setClientIp(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public int getDayOfWeek() {
        return day_of_week;
    }

    public void setDayOfWeek(int day_of_week) {
        this.day_of_week = day_of_week;
    }

    public int getDayOfYear() {
        return day_of_year;
    }

    public void setDayOfYear(int day_of_year) {
        this.day_of_year = day_of_year;
    }

    public boolean isDst() {
        return dst;
    }

    public void setDst(boolean dst) {
        this.dst = dst;
    }

    public String getDstFrom() {
        return dst_from;
    }

    public void setDstFrom(String dst_from) {
        this.dst_from = dst_from;
    }

    public int getDstOffset() {
        return dst_offset;
    }

    public void setDstOffset(int dst_offset) {
        this.dst_offset = dst_offset;
    }

    public String getDstUntil() {
        return dst_until;
    }

    public void setDstUntil(String dst_until) {
        this.dst_until = dst_until;
    }

    public int getRawOffset() {
        return raw_offset;
    }

    public void setRawOffset(int raw_offset) {
        this.raw_offset = raw_offset;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public long getUnixtime() {
        return unixtime;
    }

    public void setUnixtime(long unixtime) {
        this.unixtime = unixtime;
    }

    public String getUtcDatetime() {
        return utc_datetime;
    }

    public void setUtcDatetime(String utc_datetime) {
        this.utc_datetime = utc_datetime;
    }

    public String getUtcOffset() {
        return utc_offset;
    }

    public void setUtcOffset(String utc_offset) {
        this.utc_offset = utc_offset;
    }

    public int getWeekNumber() {
        return week_number;
    }

    public void setWeekNumber(int week_number) {
        this.week_number = week_number;
    }
}


