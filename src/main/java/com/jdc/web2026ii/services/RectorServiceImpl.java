package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.RectorEntity;
import com.jdc.web2026ii.repository.RectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RectorServiceImpl implements RectorService {

    @Autowired
    private RectorRepository rectorRepository;

    @Override
    public void save(RectorEntity rector) { rectorRepository.save(rector);}

    @Override
    @Transactional(readOnly = true)
    public List<RectorEntity> findAll() {
        return (List<RectorEntity>) rectorRepository.findAll();
    }

    @Override
    @Transactional
    public RectorEntity findById(Integer id) {
        return rectorRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        rectorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RectorEntity> consultarRectoresTipo1() {
        return rectorRepository.consultarRectoresTipo1();
    }

    @Override
    public RectorEntity findByUniversidad(Integer iduniversidad) {return rectorRepository.findByUniversidad(iduniversidad);
    }

}