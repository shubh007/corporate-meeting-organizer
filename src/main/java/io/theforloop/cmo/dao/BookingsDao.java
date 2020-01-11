package io.theforloop.cmo.dao;

import io.theforloop.cmo.Entity.Booking;
import io.theforloop.cmo.Entity.MeetingRoom;
import io.theforloop.cmo.Entity.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author Shubham
 */
@Component
public class BookingsDao {

    @Autowired
    MeetingRoomsDao meetingRoomsDao;

    public static List<Booking> bookings = new ArrayList<>();

    public boolean doBooking(Booking booking){
        boolean flag = true;
        Set<String> participants = booking.getParticipants();
        for(String participantName : participants){
            Participant participant = ParticipantDao.participantHashMap
                    .getOrDefault(participantName,new Participant(participantName));
            if(!participant.isAvailable(booking.getSchedule())){
                flag = false;
                break;
            }
        }
        MeetingRoom meetingRoom = meetingRoomsDao.getMeetingRoom(booking.getMeetingRoom());
        if(flag && (meetingRoom == null || !meetingRoom.isAvailable(booking.getSchedule()))){
            flag = false;
        }
        if(flag && (meetingRoom.getCapacity()<booking.getParticipants().size())){
            flag =false;
        }
        if(flag){
            meetingRoom.addSchedule(booking.getSchedule());
            for(String participantName : participants){
                Participant participant = ParticipantDao.participantHashMap
                        .getOrDefault(participantName,new Participant(participantName));
               participant.addSchedule(booking.getSchedule());
               ParticipantDao.participantHashMap.put(participantName,participant);
            }
            bookings.add(booking);
        }
        return flag;
    }

}
