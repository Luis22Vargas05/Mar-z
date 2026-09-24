
package com.jdc.web2026ii.services;

import com.jdc.web2026ii.entity.SeccionalEntity;
import com.jdc.web2026ii.repository.SeccionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SeccionalServiceImpl implements SeccionalService {

    @Autowired
    private SeccionalRepository seccionalRepository;

    @Override
    public List<SeccionalEntity> findAll() {
        return StreamSupport
                .stream(seccionalRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<SeccionalEntity> consultarSeccionales() {
        return seccionalRepository.consultarSeccionales();
    }

    @Override
    public SeccionalEntity findById(Integer id) {
        return seccionalRepository.findById(id).orElse(null);
    }

    @Override
    public void save(SeccionalEntity seccional) {
        seccionalRepository.save(seccional);
    }

    @Override
    public void delete(Integer id) {
        seccionalRepository.deleteById(id);
    }
}