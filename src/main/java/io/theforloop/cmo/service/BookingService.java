package io.theforloop.cmo.service;

import io.theforloop.cmo.Entity.Booking;
import io.theforloop.cmo.Entity.MeetingRoom;
import io.theforloop.cmo.Entity.Participant;
import io.theforloop.cmo.Entity.Schedule;
import io.theforloop.cmo.dao.BookingsDao;
import io.theforloop.cmo.dao.MeetingRoomsDao;
import io.theforloop.cmo.dao.ParticipantDao;
import io.theforloop.cmo.pojo.BookingReq;
import io.theforloop.cmo.util.CommanUtis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shubham
 */
@Service
public class BookingService {

    @Autowired
    private BookingsDao bookingsDao;

    @Autowired
    private MeetingRoomsDao meetingRoomsDao;

    public String scheduleMeeting(BookingReq bookingReq){
        Booking booking = CommanUtis.getBookingFromBookingReq(bookingReq);
        boolean flag = bookingsDao.doBooking(booking);
        if(flag){
            return "Meeting Scheduled Successfully + \n"+booking.toString();
        }
        return "Meeting Scheduling Failed!!!!";
    }
    public List<Schedule> getScheduleForMeetingRoom(String meetingRoomName, String date){
        MeetingRoom meetingRoom = meetingRoomsDao.getMeetingRoom(meetingRoomName);
        if(meetingRoom!=null) {
            return meetingRoom.getSchedule().getOrDefault(date, new ArrayList<>());
        }
        return new ArrayList<>();
    }
    public List<Schedule> getScheduleForEmployee(String empName, String date){
        Participant participant = ParticipantDao.participantHashMap.get(empName);
        if(participant!=null){
            return participant.getSchedule().getOrDefault(date,new ArrayList<>());
        }
        return new ArrayList<>();
    }
}
