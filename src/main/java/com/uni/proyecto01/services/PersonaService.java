package com.uni.proyecto01.services;

import com.uni.proyecto01.domains.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> listPersons();

    public void save(Persona dto);

    public void  delete(Long id);

    public Persona findPerson(Persona dto);
}
