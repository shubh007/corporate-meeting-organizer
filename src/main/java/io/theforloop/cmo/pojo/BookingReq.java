package io.theforloop.cmo.pojo;

import java.util.Set;

/**
 * @author Shubham
 */
public class BookingReq {
    private String date;
    private String start_time;
    private String end_time;
    private String meeting_room;
    private String subject;
    private String organizer;
    private Set<String> participants;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getMeeting_room() {
        return meeting_room;
    }

    public void setMeeting_room(String meeting_room) {
        this.meeting_room = meeting_room;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public Set<String> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<String> participants) {
        this.participants = participants;
    }

}
