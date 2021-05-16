package com.projet.scootop.service.services.tools.video;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.scootop.domain.services.tools.video.SearchKeyWord;
import com.projet.scootop.mappers.services.tools.video.SearchKeyWordMapper;
import com.projet.scootop.model.services.tools.video.SearchKeyWordDTO;
import com.projet.scootop.repository.services.tools.video.SearchKeyWordRepository;

@Service
public class SearchKeyWordService {
	
	@Autowired SearchKeyWordRepository repository;
	@Autowired SearchKeyWordMapper mapper;
	
	public SearchKeyWordDTO add(SearchKeyWordDTO searchKeyWordDTO){
		SearchKeyWord searchKeyWord = mapper.mapTo(searchKeyWordDTO);
		repository.save(searchKeyWord);
        return mapper.mapToDTO(searchKeyWord);

    }
    public SearchKeyWordDTO update(SearchKeyWordDTO searchKeyWordDTO){
    	SearchKeyWord searchKeyWord = mapper.mapTo(searchKeyWordDTO);
    	repository.save(searchKeyWord);
        return mapper.mapToDTO(searchKeyWord);

    }
    public SearchKeyWordDTO get(Long id){
    	SearchKeyWord searchKeyWord = repository.findById(id).orElse(null);
        return mapper.mapToDTO(searchKeyWord);

    }
    public List<SearchKeyWordDTO> getAll(){
    	List<SearchKeyWord> searchKeyWords = repository.findAll();
        return mapper.mapToDTO(searchKeyWords);
    }
    
    public String delete(Long id){
    	SearchKeyWord searchKeyWord = repository.findById(id).orElse(null);
        if(searchKeyWord==null){
            return null;
        }
        repository.deleteById(id);

        return "Deleted";
    }

}
