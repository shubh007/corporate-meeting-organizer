package io.theforloop.cmo.service;

import io.theforloop.cmo.Entity.MeetingRoom;
import io.theforloop.cmo.Entity.Schedule;
import io.theforloop.cmo.dao.MeetingRoomsDao;
import io.theforloop.cmo.pojo.MeetingReq;
import io.theforloop.cmo.util.CommanUtis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shubham
 */
@Service
public class MeetingRoomService {
    @Autowired
    private MeetingRoomsDao meetingRoomsDao;

    public boolean addMeetingRoom(MeetingReq meetingReq){
        MeetingRoom meetingRoom = meetingRoomsDao.getMeetingRoom(meetingReq.getName());
        if(meetingRoom!=null ){
            return false;
        }
        meetingRoom = new MeetingRoom(meetingReq);
        meetingRoomsDao.addOrUpdateMeetingRoom(meetingRoom);
        return true;
    }
    public List<MeetingRoom> getMeetingRooms(String date,String startTime,String endTime,int capacity){
        Schedule schedule = CommanUtis.getSchedule(date,startTime,endTime);
        List<MeetingRoom> meetingRooms = meetingRoomsDao.getAvailableMeetingRoomsWithMinCapacity(capacity,schedule);
        if(meetingRooms!=null){
            return meetingRooms;
        }
        return new ArrayList<>();
    }
    public List<MeetingRoom> getMeetingRooms(){
        return meetingRoomsDao.getAllMeetingRooms();
    }
}
