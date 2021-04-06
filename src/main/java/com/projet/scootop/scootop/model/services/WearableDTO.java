package com.projet.scootop.scootop.model.services;

import com.projet.scootop.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.scootop.domain.domainuser.Player;
import com.projet.scootop.scootop.domain.inprogess.MatchSheet;

public class WearableDTO {

    public Long id;
    public Player player;
    public Team team;
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

    public static WearableDTO create(Long id, Player player, Team team, MatchSheet matchSheet, Integer distanceRun, Integer distancePlay, Integer vMax, Integer vMaxWithBall, Integer ballPlay, Integer looseBall, Integer ballRecovered, Integer tackle, Integer foulSuffered, Integer failPass, Integer assist, Integer shortPass, Integer head, Integer headOffensive, Integer headDefensive, Integer shots, Integer shotOnTarget, Integer shotOffTarget, Integer longShot, Integer successSkill, Integer failSkill) {
        WearableDTO wearable = new WearableDTO();

        wearable.id = id;
        wearable.player = player;
        wearable.team = team;
        wearable.matchSheet = matchSheet;
        wearable.distanceRun = distanceRun;
        wearable.distancePlay = distancePlay;
        wearable.vMax = vMax;
        wearable.vMaxWithBall = vMaxWithBall;
        wearable.ballPlay = ballPlay;
        wearable.looseBall = looseBall;
        wearable.ballRecovered = ballRecovered;
        wearable.tackle = tackle;
        wearable.foulSuffered = foulSuffered;
        wearable.failPass = failPass;
        wearable.assist = assist;
        wearable.shortPass = shortPass;
        wearable.head = head;
        wearable.headOffensive = headOffensive;
        wearable.headDefensive = headDefensive;
        wearable.shots = shots;
        wearable.shotOnTarget = shotOnTarget;
        wearable.shotOffTarget = shotOffTarget;
        wearable.longShot = longShot;
        wearable.successSkill = successSkill;
        wearable.failSkill = failSkill;

        return wearable;
    }

    public static WearableDTO get(Long id, Player player, Team team, Integer distanceRun, Integer distancePlay, Integer vMax, Integer vMaxWithBall, Integer ballPlay, Integer looseBall, Integer ballRecovered, Integer tackle, Integer foulSuffered, Integer failPass, Integer assist, Integer shortPass, Integer head, Integer headOffensive, Integer headDefensive, Integer shots, Integer shotOnTarget, Integer shotOffTarget, Integer longShot, Integer successSkill, Integer failSkill) {
        WearableDTO wearable = new WearableDTO();

        wearable.id = id;
        wearable.player = player;
        wearable.team = team;
        wearable.distanceRun = distanceRun;
        wearable.distancePlay = distancePlay;
        wearable.vMax = vMax;
        wearable.vMaxWithBall = vMaxWithBall;
        wearable.ballPlay = ballPlay;
        wearable.looseBall = looseBall;
        wearable.ballRecovered = ballRecovered;
        wearable.tackle = tackle;
        wearable.foulSuffered = foulSuffered;
        wearable.failPass = failPass;
        wearable.assist = assist;
        wearable.shortPass = shortPass;
        wearable.head = head;
        wearable.headOffensive = headOffensive;
        wearable.headDefensive = headDefensive;
        wearable.shots = shots;
        wearable.shotOnTarget = shotOnTarget;
        wearable.shotOffTarget = shotOffTarget;
        wearable.longShot = longShot;
        wearable.successSkill = successSkill;
        wearable.failSkill = failSkill;

        return wearable;
    }

}
