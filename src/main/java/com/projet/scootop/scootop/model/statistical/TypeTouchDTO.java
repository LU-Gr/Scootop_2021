package com.projet.scootop.scootop.model.statistical;


public class TypeTouchDTO {
    public Long id;
    public String physical;

    public static TypeTouchDTO create(String physical) {
        TypeTouchDTO typeTouchDTO= new TypeTouchDTO();
        typeTouchDTO.physical = physical;
        return typeTouchDTO;
    }


}
