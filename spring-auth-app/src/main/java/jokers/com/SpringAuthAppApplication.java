package jokers.com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jokers.com.entities.AnneeScolaire;
import jokers.com.entities.Classe;
import jokers.com.entities.Discipline;
import jokers.com.entities.Etudiant;
import jokers.com.entities.Module;
import jokers.com.entities.Note;
import jokers.com.entities.Semestre;
import jokers.com.level.IntituleSemestre;
import jokers.com.level.NiveauClasse;
import jokers.com.level.SexeEtudiant;
import jokers.com.service.IAnneeScolaireImpl;
import jokers.com.service.IClasseImpl;
import jokers.com.service.IDisciplineImpl;
import jokers.com.service.IEtudiantImpl;
import jokers.com.service.IModuleImpl;
import jokers.com.service.INoteImpl;
import jokers.com.service.ISemestreImpl;

@SpringBootApplication
public class SpringAuthAppApplication implements CommandLineRunner {
	
	@Autowired
	public IEtudiantImpl etudiantImpl;
	@Autowired
	public IAnneeScolaireImpl anneeScolaireImpl;
	@Autowired
	public IClasseImpl classeImpl;
	@Autowired
	public ISemestreImpl semestreImpl;
	@Autowired
	public IDisciplineImpl disciplineImpl;
	@Autowired
	public IModuleImpl moduleImpl;
	@Autowired
	public INoteImpl noteImpl;

	LocalDate ldt1 = LocalDateTime.now().toLocalDate();
	LocalDate ldt2 = LocalDateTime.now().plusYears(1).toLocalDate();
	
	LocalDate lds1 = LocalDate.of(2018,9,15);
	LocalDate lds2 = LocalDate.of(2019,9,20);
	

	public static void main(String[] args) {
		SpringApplication.run(SpringAuthAppApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		AnneeScolaire as2018 = anneeScolaireImpl.save(new AnneeScolaire(ldt1, ldt2));
		
		String levelClasse1 = NiveauClasse.L1.getLevel();
		String levelClasse2 = NiveauClasse.L2.getLevel();
		String levelClasse3 = NiveauClasse.L3.getLevel();
		String levelClasse4 = NiveauClasse.M1.getLevel();
		String levelClasse5 = NiveauClasse.M2.getLevel();
		
		String semestre1 = IntituleSemestre.SEMESTRE_UN.getSemestre();
		String semestre2 = IntituleSemestre.SEMESTRE_DEUX.getSemestre();
		String semestre3 = IntituleSemestre.SEMESTRE_TROIS.getSemestre();
		String semestre4 = IntituleSemestre.SEMESTRE_QUATRE.getSemestre();
		String semestre5 = IntituleSemestre.SEMESTRE_CINQ.getSemestre();
		String semestre6 = IntituleSemestre.SEMESTRE_SIX.getSemestre();
		String semestre7 = IntituleSemestre.SEMESTRE_SEPT.getSemestre();
		String semestre8 = IntituleSemestre.SEMESTRE_HUIT.getSemestre();
		String semestre9 = IntituleSemestre.SEMESTRE_NEUF.getSemestre();
		String semestre10 = IntituleSemestre.SEMESTRE_DIX.getSemestre();
		
		String m = SexeEtudiant.MALE.getSexe();
		String f = SexeEtudiant.FEMALE.getSexe();
		
		Classe c1 = classeImpl.save(new Classe("Genie Telecommunication Informatique", levelClasse1, as2018));
		Classe c2 = classeImpl.save(new Classe("Genie Telecommunication Informatique", levelClasse2, as2018));
		Classe c3 = classeImpl.save(new Classe("Genie Telecommunication Informatique", levelClasse3, as2018));
		Classe c4 = classeImpl.save(new Classe("Genie Civil", levelClasse1, as2018));
		Classe c5 = classeImpl.save(new Classe("Genie Civil", levelClasse2, as2018));
		Classe c6 = classeImpl.save(new Classe("Genie Thermique", levelClasse1, as2018));
		
		Semestre s1 = semestreImpl.save(new Semestre(ldt1, lds1, semestre1, as2018));
		Semestre s2 = semestreImpl.save(new Semestre(ldt1, lds2, semestre2, as2018));
		Semestre s3 = semestreImpl.save(new Semestre(ldt1, lds2, semestre3, as2018));
		Semestre s4 = semestreImpl.save(new Semestre(ldt1, lds2, semestre4, as2018));
		Semestre s5 = semestreImpl.save(new Semestre(ldt1, lds2, semestre5, as2018));
		Semestre s6 = semestreImpl.save(new Semestre(ldt1, lds2, semestre6, as2018));
		Semestre s7 = semestreImpl.save(new Semestre(ldt1, lds2, semestre7, as2018));
		Semestre s8 = semestreImpl.save(new Semestre(ldt1, lds2, semestre8, as2018));
		Semestre s9 = semestreImpl.save(new Semestre(ldt1, lds2, semestre9, as2018));
		Semestre s10 = semestreImpl.save(new Semestre(ldt1, lds2, semestre10, as2018));
		
		
		Module m1 = moduleImpl.save(new Module("INFO538", "Reseaux mobiles et applications", c1));
		Module m2 = moduleImpl.save(new Module("INFO539", "Systemes distribues 2", c1));
		Module m3 = moduleImpl.save(new Module("INFO5310","Reseaux et securite", c1));
		
		Discipline d1 = disciplineImpl.save(new Discipline("Reseaux Mobile", 2, "RMS1M1", m1, s1));
		Discipline d6 = disciplineImpl.save(new Discipline("Reseaux Mobile", 2, "AMS1M1", m1, s1));
		Discipline d2 = disciplineImpl.save(new Discipline("Application Mobile", 2, "RMS1M1", m1, s1));
		Discipline d3 = disciplineImpl.save(new Discipline("Programmation concurrente et parallele", 2,"PCPS1M2", m2, s1));
		Discipline d4 = disciplineImpl.save(new Discipline("Applications distribuees ", 2,"ADS1M2", m2, s1));
		Discipline d5 = disciplineImpl.save(new Discipline("Technologies emergentes ", 2,"TES1M2", m2, s1));
		
				
		Etudiant etd1 = etudiantImpl.save(new Etudiant("CODA0710890800", "COULIBALY", "Daouda", new Date(), "KONZANSSO", "Sankareboubou", 654321789, m, "daoudi.dc@gmail.com", 78956852, "Daouda.jpg",c2));
		Etudiant etd2 = etudiantImpl.save(new Etudiant("KEOU0710910800", "KEITA", "Oumar", new Date(), "MPessoba", "Missira", 65699438, m, "keimar.ok@gmail.com", 72367980, "Oumar.jpg",c1));
		Etudiant etd3 = etudiantImpl.save(new Etudiant("TRLA2508891800", "TRAORE", "Lassana", new Date(), "Bamako", "Banconi", 123456789, m, "lassa09@gmail.com", 73315624, "Lassana.jpg",c1));
		Etudiant etd4 = etudiantImpl.save(new Etudiant("DEFA0710950800", "DEMBELE", "Fatoumata Mama", new Date(), "Koutiala", "Sincina", 987654321, f, "fatoumata.fmd@gmail.com", 89653214, "fatoumata.jpg",c2));
		
		Note note11 = noteImpl.save(new Note(15, 13, 10, 5, d1, etd1));
		Note note12 = noteImpl.save(new Note(12, 16, 13, 3, d2, etd1));
		Note note13 = noteImpl.save(new Note(11, 11, 19, 9, d3, etd1));
		Note note14 = noteImpl.save(new Note(17, 12, 15, 12, d4, etd1));
		Note note15 = noteImpl.save(new Note(13, 18, 12, 11, d5, etd1));
		
		Note note2 = noteImpl.save(new Note(13, 19, 17, 11, d1, etd2));
		Note note3 = noteImpl.save(new Note(11, 10, 11, 18, d1, etd3));
	}
}
