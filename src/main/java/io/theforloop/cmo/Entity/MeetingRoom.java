package io.theforloop.cmo.Entity;

import io.theforloop.cmo.pojo.MeetingReq;
import io.theforloop.cmo.util.CommanUtis;
import io.theforloop.cmo.util.DateUtil;

import java.util.*;

/**
 * @author Shubham
 */
public class MeetingRoom {
    private String name;
    private int capacity;
    private Map<String, List<Schedule>> dateScheduleMap ;

    public MeetingRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.dateScheduleMap = new HashMap<>();
    }
    public MeetingRoom(MeetingReq meetingReq) {
        this.name = meetingReq.getName();
        this.capacity = meetingReq.getCapacity();
        this.dateScheduleMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public Map<String, List<Schedule>> getSchedule() {
        return dateScheduleMap;
    }
    public Map<String, List<Schedule>> addSchedule(Schedule schedule){
        if(isAvailable(schedule)){
            List<Schedule> schedules = dateScheduleMap.getOrDefault(
                    DateUtil.getStringDate(schedule.getDate()),new ArrayList<>());
            schedules.add(schedule);
            dateScheduleMap.put(DateUtil.getStringDate(schedule.getDate()),schedules);
        }
        return dateScheduleMap;
    }
    public boolean isAvailable (Schedule schedule) {
        return CommanUtis.isAvailable(schedule,dateScheduleMap);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeetingRoom that = (MeetingRoom) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", dateScheduleMap=" + dateScheduleMap +
                '}';
    }
}
