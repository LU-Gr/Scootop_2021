package com.projet.scootop.scootop.model.domainetools;

public class SkillDTO {
    public Long id;
    public String name;

    public static SkillDTO create(String name) {

        SkillDTO skillsfamilly = new SkillDTO();
        skillsfamilly.name = name;

        return skillsfamilly;
    }
    public static SkillDTO get(Long id, String name) {

        SkillDTO skillsfamilly = new SkillDTO();
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
