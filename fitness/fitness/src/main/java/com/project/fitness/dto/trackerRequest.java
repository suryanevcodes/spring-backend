package com.project.fitness.dto;

import java.sql.Time;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class trackerRequest {
    private Time time;
    private Date date;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserid() {
        return userid;
    }

    public trackerRequest setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    private int userid;
}
