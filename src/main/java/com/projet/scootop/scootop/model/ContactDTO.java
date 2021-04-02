package com.projet.scootop.scootop.model;

import com.projet.scootop.scootop.user.User;


public class ContactDTO {

    public Integer id;
    public String email;
    public String tel;
    public String address;
    public String cp;
    public User user;
    public static ContactDTO create(String email, String tel, String address, String cp,User user){
        ContactDTO contactDTO= new ContactDTO();
        contactDTO.address=address;
        contactDTO.cp=cp;
        contactDTO.tel=tel;
        contactDTO.user=user;
        contactDTO.email=email;
      return   contactDTO;
    }
    public static ContactDTO get(Integer id,String email, String tel, String address, String cp,User user){
        ContactDTO contactDTO= new ContactDTO();
        contactDTO.id = id;
        contactDTO.address=address;
        contactDTO.cp=cp;
        contactDTO.tel=tel;
        contactDTO.user=user;
        contactDTO.email=email;
      return   contactDTO;
    }
}
