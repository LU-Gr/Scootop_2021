package com.projet.scootop.model.user;

import com.projet.scootop.domain.user.User;


public class ContactDTO {

    public Long id;
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
    public static ContactDTO get(Long id,String email, String tel, String address, String cp,User user){
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
