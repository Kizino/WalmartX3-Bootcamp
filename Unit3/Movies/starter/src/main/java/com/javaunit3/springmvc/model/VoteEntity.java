package com.javaunit3.springmvc.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "votes")
public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "voter_name")
    private String voterName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    @Override
    public String toString() {
        return "VoteEntity{" +
                "id=" + id +
                ", voterName='" + voterName + '\'' +
                '}';
    }
}
