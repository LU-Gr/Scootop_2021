package com.projet.scootop.scootop.model.domainetools;

public class SkillsFamillyDTO {
    public int id;
    public String name;

    public static SkillsFamillyDTO create(String name) {

        SkillsFamillyDTO skillsfamilly = new SkillsFamillyDTO();
        skillsfamilly.name = name;

        return skillsfamilly;
    }
    public static SkillsFamillyDTO get(int id, String name) {

        SkillsFamillyDTO skillsfamilly = new SkillsFamillyDTO();
        skillsfamilly.id = id;
        skillsfamilly.name = name;

        return skillsfamilly;
    }

    @Override
    public String toString() {
        return "SkillsFamillyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
