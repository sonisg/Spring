package com.hibernatedemo.HibernatePractice;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    @Column(name = "youtube_channel")
    public String youTube;
    @Column(name = "HOBBY")
    public String hobby;

    @OneToOne(mappedBy = "instructor_id", cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;

    public InstructorDetail() {
    }

    public InstructorDetail( String youTube, String hobby) {

        this.youTube = youTube;
        this.hobby = hobby;
    }
    public InstructorDetail(int instructor_id, String youTube, String hobby) {
        this.id = instructor_id;
        this.youTube = youTube;
        this.hobby = hobby;
    }

    public int getInstructor_id() {
        return id;
    }

    public void setInstructor_id(int instructor_id) {
        this.id = instructor_id;
    }

    public String getYouTube() {
        return youTube;
    }

    public void setYouTube(String youTube) {
        this.youTube = youTube;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "instructor_id=" + id +
                ", youTube='" + youTube + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
