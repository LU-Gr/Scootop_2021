package com.projet.scootop.scootop.domain.services;

import javax.persistence.*;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.inprogess.MatchSheet;

@Entity
@Table(name = "Wearable")

public class Wearable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne
    @JoinColumn(name = "player_id")

    public Player player;

    @ManyToOne
    @JoinColumn(name = "team_id")
    public Team team;


    @ManyToOne
    @JoinColumn(name = "Game_id")
    public MatchSheet matchSheet;
    public Integer distanceRun;
    public Integer distancePlay;
    public Integer vMax;
    public Integer vMaxWithBall;
    public Integer ballPlay;
    public Integer looseBall;
    public Integer ballRecovered;
    public Integer tackle;
    public Integer foulSuffered;
    public Integer failPass;
    public Integer assist;
    public Integer shortPass;
    public Integer head;
    public Integer headOffensive;
    public Integer headDefensive;
    public Integer shots;
    public Integer shotOnTarget;
    public Integer shotOffTarget;
    public Integer longShot;
    public Integer successSkill;
    public Integer failSkill;

    public Wearable() {

    }

    public Wearable(Player player, Team team, MatchSheet matchSheet, Integer distanceRun, Integer distancePlay, Integer vMax, Integer vMaxWithBall, Integer ballPlay, Integer looseBall, Integer ballRecovered, Integer tackle, Integer foulSuffered, Integer failPass, Integer assist, Integer shortPass, Integer head, Integer headOffensive, Integer headDefensive, Integer shots, Integer shotOnTarget, Integer shotOffTarget, Integer longShot, Integer successSkill, Integer failSkill) {
    }

    public Long getId() {
        return id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Integer getDistanceRun() {
        return distanceRun;
    }

    public void setDistanceRun(Integer distanceRun) {
        this.distanceRun = distanceRun;
    }

    public Integer getDistancePlay() {
        return distancePlay;
    }

    public void setDistancePlay(Integer distancePlay) {
        this.distancePlay = distancePlay;
    }

    public Integer getvMax() {
        return vMax;
    }

    public void setvMax(Integer vMax) {
        this.vMax = vMax;
    }

    public Integer getvMaxWithBall() {
        return vMaxWithBall;
    }

    public void setvMaxWithBall(Integer vMaxWithBall) {
        this.vMaxWithBall = vMaxWithBall;
    }

    public Integer getBallPlay() {
        return ballPlay;
    }

    public void setBallPlay(Integer ballPlay) {
        this.ballPlay = ballPlay;
    }

    public Integer getLooseBall() {
        return looseBall;
    }

    public void setLooseBall(Integer looseBall) {
        this.looseBall = looseBall;
    }

    public Integer getBallRecovered() {
        return ballRecovered;
    }

    public void setBallRecovered(Integer ballRecovered) {
        this.ballRecovered = ballRecovered;
    }

    public Integer getTackle() {
        return tackle;
    }

    public void setTackle(Integer tackle) {
        this.tackle = tackle;
    }

    public Integer getFoulSuffered() {
        return foulSuffered;
    }

    public void setFoulSuffered(Integer foulSuffered) {
        this.foulSuffered = foulSuffered;
    }

    public Integer getFailPass() {
        return failPass;
    }

    public void setFailPass(Integer failPass) {
        this.failPass = failPass;
    }

    public Integer getAssist() {
        return assist;
    }

    public void setAssist(Integer assist) {
        this.assist = assist;
    }

    public Integer getShortPass() {
        return shortPass;
    }

    public void setShortPass(Integer shortPass) {
        this.shortPass = shortPass;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public Integer getHeadOffensive() {
        return headOffensive;
    }

    public void setHeadOffensive(Integer headOffensive) {
        this.headOffensive = headOffensive;
    }

    public Integer getHeadDefensive() {
        return headDefensive;
    }

    public void setHeadDefensive(Integer headDefensive) {
        this.headDefensive = headDefensive;
    }

    public Integer getShots() {
        return shots;
    }

    public void setShots(Integer shots) {
        this.shots = shots;
    }

    public Integer getShotOnTarget() {
        return shotOnTarget;
    }

    public void setShotOnTarget(Integer shotOnTarget) {
        this.shotOnTarget = shotOnTarget;
    }

    public Integer getShotOffTarget() {
        return shotOffTarget;
    }

    public void setShotOffTarget(Integer shotOffTarget) {
        this.shotOffTarget = shotOffTarget;
    }

    public Integer getLongShot() {
        return longShot;
    }

    public void setLongShot(Integer longShot) {
        this.longShot = longShot;
    }

    public Integer getSuccessSkill() {
        return successSkill;
    }

    public void setSuccessSkill(Integer successSkill) {
        this.successSkill = successSkill;
    }

    public Integer getFailSkill() {
        return failSkill;
    }

    public void setFailSkill(Integer failSkill) {
        this.failSkill = failSkill;
    }

    public MatchSheet getMatchSheet() {
        return matchSheet;
    }

    public void setMatchSheet(MatchSheet matchSheet) {
        this.matchSheet = matchSheet;
    }
}
