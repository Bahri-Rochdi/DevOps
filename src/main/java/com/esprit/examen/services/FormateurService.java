package com.esprit.examen.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.esprit.examen.entities.Cours;
import com.esprit.examen.entities.Session;
import com.esprit.examen.repositories.CoursRepository;
import com.esprit.examen.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.examen.entities.Formateur;
import com.esprit.examen.entities.TypeCours;
import com.esprit.examen.repositories.FormateurRepository;

@Service
public class FormateurService implements IFormateurService{

	@Autowired
	FormateurRepository formateurRepository;
	@Autowired
	SessionRepository sessionRepository;
	@Autowired
	CoursRepository coursRepository;
	@Override
	public Long addFormateur(Formateur formateur) {
		formateurRepository.save(formateur);
		return formateur.getId();
	}

	@Override
	public Long modifierFormateur(Formateur formateur) {
		formateurRepository.save(formateur);
		return formateur.getId();
	}

	@Override
	public void supprimerFormateur(Long formateurId) {
		formateurRepository.deleteById(formateurId);
		
	}

	@Override
	public Long nombreFormateursImpliquesDansUnCours(TypeCours typeCours) {
		List<Cours> coursList = coursRepository.findAll();
		List<Formateur> formateurList = new ArrayList<>();
		for (Cours cours : coursList ) {
			if (cours.getTypeCours().equals(typeCours)){
				Set<Session> sessionSet = cours.getSessions();
				for (Session s : sessionSet) {
					formateurList.add(s.getFormateur());
				}
			}
		}
		return Long.valueOf(formateurList.size());
	}



	@Override
	public List<Formateur> listFormateurs() {
		
		return formateurRepository.findAll();
	}


	
	

}
