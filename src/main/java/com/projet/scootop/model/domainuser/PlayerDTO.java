package com.projet.scootop.model.domainuser;

import java.time.LocalDate;
import java.util.List;

import com.projet.scootop.domain.domainconfiguration.Category;
import com.projet.scootop.domain.domainconfiguration.Team;
import com.projet.scootop.domain.inprogress.MatchSheet;
import com.projet.scootop.domain.inprogress.StatisticalSheet;
import com.projet.scootop.domain.servicetools.video.Video;
import com.projet.scootop.domain.statistical.physical.PlayerHead;
import com.projet.scootop.domain.user.User;

public class PlayerDTO {

    public Long id;
    public List<Team> teams;
    public Category category;
    public int evaluation;
    public LocalDate birthday;
    public int taille;
    public int poids;
    public int vma;
    public String nationalite;
    public String origin;
    public int interaction;
    public String strongFoot;
    public String weekFoot;
    public PlayerHead playerHead;
    public List<StatisticalSheet> statisticalSheets;
    public List<MatchSheet> matshSheets;
    public List<Video> videos;
    public User user;


    public static PlayerDTO create(List<Team> teams, Category category, int evaluation, LocalDate birthday, int taille, int poids, int vma, int interaction, String strongFoot, String weekFoot,PlayerHead playerHead,List<StatisticalSheet> statisticalSheets, List<MatchSheet> matchSheets, List<Video> videos, String origin, String nationalite, User user) {
        PlayerDTO player = new PlayerDTO();

        player.teams = teams;
        player.category = category;
        player.evaluation = evaluation;
        player.birthday = birthday;
        player.taille = taille;
        player.poids = poids;
        player.vma = vma;
        player.nationalite = nationalite;
        player.origin = origin;
        player.interaction = interaction;
        player.strongFoot = strongFoot;
        player.weekFoot = weekFoot;
        player.playerHead = playerHead;
        player.statisticalSheets = statisticalSheets;
        player.matshSheets = matchSheets;
        player.videos = videos;
        player.user=user;

        return player;
    }

    public static PlayerDTO get(Long id, List<Team> teams, Category category, int evaluation, LocalDate birthday, int taille, int poids, int vma, String nationalite,String origin, int interaction, String strongFoot, String weekFoot,PlayerHead playerHead, List<StatisticalSheet> statisticalSheets,List<MatchSheet> matchSheets, List<Video> videos, User user) {
        PlayerDTO player = new PlayerDTO();

        player.id = id;
        player.teams = teams;
        player.category = category;
        player.evaluation = evaluation;
        player.birthday = birthday;
        player.taille = taille;
        player.poids = poids;
        player.vma = vma;
        player.nationalite = nationalite;
        player.origin = origin;
        player.interaction = interaction;
        player.strongFoot = strongFoot;
        player.weekFoot = weekFoot;
        player.playerHead = playerHead;
        player.statisticalSheets = statisticalSheets;
        player.matshSheets = matchSheets;
        player.videos = videos;
        player.user=user;

        return player;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                ", team=" + teams +
                ", category=" + category +
                ", Evaluation=" + evaluation +
                ", Birthday=" + birthday +
                ", taille=" + taille +
                ", poids=" + poids +
                ", vma=" + vma +
                ", nationalite='" + nationalite + '\'' +
                ", origin='" + origin + '\'' +
                ", Interaction=" + interaction +
                ", strongFoot=" + strongFoot +
                ", weekFoot=" + weekFoot +
                ", playerHead=" + playerHead +
                //", Feet=" + Arrays.toString(feet) +
                ", statisticalSheets=" + statisticalSheets +
                ", videos=" + videos +
                '}';
    }
}
