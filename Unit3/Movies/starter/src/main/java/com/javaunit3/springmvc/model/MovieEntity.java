package com.javaunit3.springmvc.model;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "maturity_rating")
    private String maturity_rating;
    @Column(name = "genre")
    private String genre;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id")
    private List<VoteEntity> votes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaturity_rating() {
        return maturity_rating;
    }

    public void setMaturity_rating(String maturity_rating) {
        this.maturity_rating = maturity_rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<VoteEntity> getVotes() {
        return votes;
    }

    public void addVote(VoteEntity vote){
        if(this.votes == null){
            this.votes = new ArrayList<>();
        }

        this.votes.add(vote);
    }

    public void setVotes(List<VoteEntity> votes) {
        this.votes = votes;
    }

    @Override
    public String toString() {
        return "MovieEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", maturity_rating='" + maturity_rating + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }


}
