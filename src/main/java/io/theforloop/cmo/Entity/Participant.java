package io.theforloop.cmo.Entity;

import io.theforloop.cmo.util.CommanUtis;
import io.theforloop.cmo.util.DateUtil;

import java.util.*;

/**
 * @author Shubham
 */
public class Participant {
    private String name;
    private Map<String, List<Schedule>> dateScheduleMap ;

    public Participant(String name) {
        this.name = name;
        this.dateScheduleMap = new HashMap<>();
    }
    public String getName() {
        return name;
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
    public boolean isAvailable (Schedule schedule){
        return CommanUtis.isAvailable(schedule,dateScheduleMap);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Participant{" +
                "name='" + name + '\'' +
                ", dateScheduleMap=" + dateScheduleMap +
                '}';
    }
}
