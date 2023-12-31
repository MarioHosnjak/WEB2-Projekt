package com.WEB2.backend.Model;

import com.WEB2.backend.Model.Scoringsystem;
import com.WEB2.backend.Model.Usertable;
import jakarta.persistence.*;

@Table(name = "tournament")
@Entity
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tournamentid", nullable = false)
    private Integer id;

    @Column(name = "tournamentname", nullable = false, length = 60)
    private String tournamentname;

    @ManyToOne(optional = false)
    @JoinColumn(name = "userid", nullable = false)
    private Usertable userid;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sportname", nullable = false)
    private Scoringsystem sportname;

    @Column(name = "tournamenthash", length = 10)
    private String tournamenthash;

    public Scoringsystem getSportname() {
        return sportname;
    }

    public void setSportname(Scoringsystem sportname) {
        this.sportname = sportname;
    }

    public Usertable getUserid() {
        return userid;
    }

    public void setUserid(Usertable userid) {
        this.userid = userid;
    }

    public String getTournamentname() {
        return tournamentname;
    }

    public void setTournamentname(String tournamentname) {
        this.tournamentname = tournamentname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTournamenthash() {
        return tournamenthash;
    }

    public void setTournamenthash(String tournamenthash) {
        this.tournamenthash = tournamenthash;
    }
}