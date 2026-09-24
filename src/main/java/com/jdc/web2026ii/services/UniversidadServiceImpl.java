package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.UniversidadEntity;
import com.jdc.web2026ii.repository.UniversidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UniversidadServiceImpl implements UniversidadService {

    @Autowired
    private UniversidadRepository universidadRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UniversidadEntity> findAll() {
        return (List<UniversidadEntity>) universidadRepository.findAll();
    }

    @Override
    @Transactional
    public UniversidadEntity findById(Long id) {
        return universidadRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(UniversidadEntity universidad) {
        universidadRepository.save(universidad);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        universidadRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void updateState(Long id) {
        universidadRepository.updateEstado(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UniversidadEntity> consultarUniversidades() {
        return universidadRepository.consultarUniversidades();
    }

    @Override
    public List<UniversidadEntity> findUniversidadesActivas() {
        return universidadRepository.findUniversidadesActivas();
    }
}