package com.cutm.erp.fees.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="hostel_stay")
public class HostelStay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hostelStayId;

    @ManyToOne(targetEntity = StudentDetail.class)
    @JoinColumn(name = "student_id")
    private StudentDetail student;

    @ManyToOne(targetEntity = HostelMaster.class)
    @JoinColumn(name = "hostel_id")
    private HostelMaster hostel;

    private RoomCategory roomCategory;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private Date dateOfJoining;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MMM-yyyy")
    private Date dateOfLeave;

    public int getHostelStayId() {
        return hostelStayId;
    }

    public int getStudentId() {
        return student.getStudentId();
    }

    public String getStudentName(){return student.getUser().getUserName();}

    public void setStudent(StudentDetail student) {
        this.student = student;
    }

    public int getHostelMasterId() {
        return hostel.getHostelId();
    }

    public String getHostelName(){return hostel.getHostelName();}

    public void setHostelMaster(HostelMaster hostel) {
        this.hostel = hostel;
    }

    public RoomCategory getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(RoomCategory roomCategory) {
        this.roomCategory = roomCategory;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getDateOfLeave() {
        return dateOfLeave;
    }

    public void setDateOfLeave(Date dateOfLeave) {
        this.dateOfLeave = dateOfLeave;
    }
}