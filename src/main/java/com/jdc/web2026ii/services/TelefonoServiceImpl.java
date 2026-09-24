package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.TelefonoEntity;
import com.jdc.web2026ii.repository.TelefonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TelefonoServiceImpl implements TelefonoService {

    @Autowired
    private TelefonoRepository telefonoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TelefonoEntity> consultarPrimeros8() {
        return telefonoRepository.consultarPrimeros8();
    }
    @Override
    public List<TelefonoEntity> findAll() {
        return StreamSupport
                .stream(telefonoRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public TelefonoEntity findById(Integer id) {
        return telefonoRepository.findById(id).orElse(null);
    }

    @Override
    public void save(TelefonoEntity telefono) {
        telefonoRepository.save(telefono);
    }

    @Override
    public void delete(Integer id) {
        telefonoRepository.deleteById(id);
    }
}
