package com.projet.scootop.scootop.model.provider;

import com.projet.scootop.scootop.user.User;

public class CameramanDTO {

    public Integer id;
    public Integer tarif;
    public Integer experience;
    public User user;

    public static CameramanDTO create(Integer tarif, Integer experience, User user) {
        CameramanDTO cameramanDTO = new CameramanDTO();
        cameramanDTO.tarif = tarif;
        cameramanDTO.experience = experience;
        cameramanDTO.user = user;
        return cameramanDTO;
    }
    public static CameramanDTO get(Integer id,Integer tarif, Integer experience, User user) {
        CameramanDTO cameramanDTO = new CameramanDTO();
        cameramanDTO.id = id;
        cameramanDTO.tarif = tarif;
        cameramanDTO.experience = experience;
        cameramanDTO.user = user;
        return cameramanDTO;
    }

    @Override
    public String toString() {
        return "CameramanDTO{" +
                "id=" + id +
                ", tarif=" + tarif +
                ", experience=" + experience +
                ", user=" + user +
                '}';
    }
}
