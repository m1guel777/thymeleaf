package com.uni.proyecto01.services;

import com.uni.proyecto01.dao.Ipersona;
import com.uni.proyecto01.domains.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonaServiceIMP implements PersonaService{

    @Autowired
    private Ipersona dao;

    @Override
    @Transactional(readOnly = true)
    public List<Persona> listPersons() {
        return (List<Persona>) dao.findAll();
    }

    @Override
    @Transactional
    public Persona findPerson(Persona dto) {
        return dao.findById(dto.getId_persona()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Persona dto) {
        dao.save(dto);
    }

    @Override
    public void delete(Long id) {

        dao.deleteById(id);
    }
}
