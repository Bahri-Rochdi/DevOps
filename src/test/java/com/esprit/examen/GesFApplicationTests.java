package com.esprit.examen;

import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.repositories.FormateurRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GesFApplicationTests {
    @Autowired
    FormateurRepository formateurRepository;

    @Test
    public void addFormateur() {
        Formateur formateur = new Formateur( 1L,"nomFormateur","prenomFormateur", Poste.Docteur, Contrat.CDI, "test@gmail.com","testFormateur" );
        formateurRepository.save(formateur);
    }

}
