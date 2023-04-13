package com.uni.proyecto01.controllers;

import com.uni.proyecto01.dao.Ipersona;
import com.uni.proyecto01.domains.Persona;
import com.uni.proyecto01.services.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

@Controller
@Slf4j

public class ControllerInicio {

    //injection of dependecies
    @Value("${index.saludo}")
    private String saludoOfProperties;

    @Autowired
    private Ipersona repo;

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String test(Model model){
        log.info("in teeeeeeeeeeeeeeeest");

        /*var personitas = repo.findAll();

        Iterable<Persona> pe = repo.findAll();

        var persona1 = new Persona();
        persona1.setNombre("mike");
        persona1.setApellido("Granados");
        persona1.setEmail("mike.granados@eninetworks.com");
        persona1.setTelefono("6421358012");

        var persona2 = new Persona();
        persona2.setNombre("angel");
        persona2.setApellido("vega");
        persona2.setEmail("angel.granados@eninetworks.com");
        persona2.setTelefono("6421419561");*/

        //how put or add a object of type person in arraylist of type persons
        /*  List<Persona> personas = new ArrayList<Persona>();
            personas.add(persona1);
            personas.add(persona2);
            */

        //other
        /*var personas = new ArrayList();
        personas.add(persona1);
        personas.add(persona2);*/
        // the best form

        //var personas = Arrays.asList(persona1, persona2);
        var personas =personaService.listPersons();



        var saludar = "hi Thymeleaf";
        model.addAttribute("msj", saludar);
        model.addAttribute("hiFromProperties", saludoOfProperties);
        model.addAttribute("objPersonas", personas);
        return "index";
    }

    @GetMapping("/add")
    public String addPerson(Persona ppersona){

        return "update";
    }


    @PostMapping("save")
    public String save(Persona persona){
        personaService.save(persona);
        return "redirect:/";
    }



    @GetMapping("/update/{id_persona}")
    public String update(Persona persona, Model model){

        persona = personaService.findPerson(persona);
        model.addAttribute("persona", persona);

        return "update";
    }

    @GetMapping("/delete/{id_persona}")
    public String delete(Persona persona){

        personaService.delete(persona.getId_persona());

        return "redirect:/";
    }
}
