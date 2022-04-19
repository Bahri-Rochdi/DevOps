package com.esprit.examen.services;

import com.esprit.examen.entities.*;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.examen.repositories.FormateurRepository;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class FormateurServiceTest {
    @Autowired
    FormateurRepository formateurRepository;
    @Autowired
    SessionRepository sessionRepository;
    @Autowired
    CoursRepository coursRepository;


    @Test
    public void addFormateur() {
        Formateur formateur = new Formateur(1L, "nomFormateur","prenomFormateur", Poste.Docteur, Contrat.CDI, "test@gmail.com","testFormateur" );
        formateurRepository.save(formateur);
    }


    @Test
    void modifierFormateur() {
        Formateur formateurModifier = formateurRepository.getOne(1L);
        if (formateurModifier.getId() != null){
            formateurModifier.setContrat(Contrat.EXPERT);
            formateurRepository.save(formateurModifier);
        } else {
            System.out.println("Formateur not exist ...");
        }

    }

    @Test
    void supprimerFormateur() {
        formateurRepository.deleteById(1L);
    }

    @Test
    void nombreFormateursImpliquesDansUnCours(TypeCours typeCours) {
        List<Cours> coursList = coursRepository.findAll();
        List<Formateur> formateurList = new ArrayList<>();
        for (Cours cours : coursList ) {
            if (cours.getTypeCours().equals(typeCours)){
                Set<Session> sessionSet = cours.getSessions();
                for (Session s : sessionSet) {
                     formateurList.add(s.getFormateur());
                }
                int n = formateurList.size();
                System.out.println("Le nombre de formateur est : " + n);
            }
        }
    }

    @Test
    void listFormateurs() {
        List<Formateur> formateurList = formateurRepository.findAll();

        for (Formateur f: formateurList) {
            System.out.println(f.getNom());
        }
    }
}