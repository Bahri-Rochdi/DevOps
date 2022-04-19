package com.esprit.examen;
import com.esprit.examen.entities.Contrat;
import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.Poste;
import com.esprit.examen.repositories.FormateurRepository;
import com.esprit.examen.services.FormateurService;
import com.esprit.examen.services.IFormateurService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class GesFApplication {

	public static void main(String[] args) {
		SpringApplication.run(GesFApplication.class, args);

		
		FormateurService formateurService = new FormateurService() ;
		Formateur formateur = new Formateur( 1L, "nomFormateur","prenomFormateur", Poste.Docteur, Contrat.CDI, "test@gmail.com","testFormateur" );
        formateurService.addFormateur(formateur);
        System.out.println("Fin Project ....");
	}
	
 
}
