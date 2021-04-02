package com.projet.scootop.scootop.service.services.interaction;

import com.projet.scootop.scootop.domain.services.interaction.Invite;
import com.projet.scootop.scootop.model.services.interaction.InviteDTO;
import com.projet.scootop.scootop.repository.services.interaction.InviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class InviteService {
    @Autowired
    public InviteRepository inviteRepository;
    public InviteDTO add(InviteDTO inviteDTO){
        Invite invite= new Invite(inviteDTO.saison,inviteDTO.events,inviteDTO.user,inviteDTO.player,inviteDTO.createAt,inviteDTO.response);
        inviteRepository.save(invite);
        return inviteDTO;
    }
    public InviteDTO get(Integer id){

        Invite invite = inviteRepository.findById(id).orElse(null);
        if(invite==null){
            return null;
        }
        InviteDTO inviteDTO = InviteDTO.get(invite.id,invite.saison,invite.events,invite.user,invite.player,invite.createAt,invite.response);
        return inviteDTO;
    }
    public List<InviteDTO> getAll(){

        List<Invite> invites = inviteRepository.findAll();
        ArrayList<InviteDTO> inviteDTOArrayList = new ArrayList<>();
        for (Invite invite: invites
        ) {
            InviteDTO inviteDTO = InviteDTO.create(invite.saison,invite.events,invite.user,invite.player,invite.createAt,invite.response);
            inviteDTOArrayList.add(inviteDTO);

        }
        return inviteDTOArrayList;
    }
    public String delete(Integer id){
        Invite invite = inviteRepository.findById(id).orElse(null);
        if(invite==null){
            return null;
        }

        inviteRepository.deleteById(id);

        return "Deleted";
    }

}
