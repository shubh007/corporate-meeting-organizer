package io.theforloop.cmo.util;

import io.theforloop.cmo.Entity.Booking;
import io.theforloop.cmo.Entity.Schedule;
import io.theforloop.cmo.pojo.BookingReq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Shubham
 */
public class CommanUtis {
    public static boolean isAvailable(Schedule schedule, Map<String, List<Schedule>> dateScheduleMap){
        boolean flag = true;
        List<Schedule> schedules = dateScheduleMap.getOrDefault(
                DateUtil.getStringDate(schedule.getDate()), new ArrayList<>());
        if(schedule.getStartTime().before(schedule.getEndTime())){
            for (Schedule s : schedules) {
                if (schedule.getEndTime().after(s.getStartTime()) &&
                        schedule.getStartTime().before(s.getEndTime())) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
    public static Booking getBookingFromBookingReq(BookingReq bookingReq){
        Booking booking = new Booking();
        booking.setMeetingRoom(bookingReq.getMeeting_room());
        booking.setOrganizer(bookingReq.getOrganizer());
        booking.setParticipants(bookingReq.getParticipants());
        booking.setSubject(bookingReq.getSubject());
        booking.setSchedule(getSchedule(bookingReq.getDate(),bookingReq.getStart_time(),bookingReq.getEnd_time()));
        return booking;
    }
    public static Schedule getSchedule(String sDate,String sStartTime,String sEndTime){
        Date date = DateUtil.getDate(sDate);
        Date startTime = DateUtil.getTime(sStartTime);
        Date endTime = DateUtil.getTime(sEndTime);
        Schedule schedule = new Schedule(date,startTime,endTime);
        return schedule;
    }
}
