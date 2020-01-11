package io.theforloop.cmo.Entity;

import io.theforloop.cmo.util.DateUtil;

import java.util.Date;

/**
 * @author Shubham
 */
public class Schedule {
    private Date date;
    private Date startTime;
    private Date endTime;

    public Schedule(Date date, Date startTime, Date endTime) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                ", date=" + DateUtil.getStringDate(date) +
                ", startTime=" + DateUtil.getStringTime(startTime) +
                ", endTime=" + DateUtil.getStringTime(endTime) +
                '}';
    }
}
