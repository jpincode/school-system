package business.services;

import business.dto.DisciplineDTO;
import models.entities.Discipline;
import models.entities.Student;
import models.repositories.DisciplineRepository;
import models.repositories.ManagerRepository;
import models.repositories.StudentRepository;

public class DisciplineService {
    private static final ManagerRepository managerRepository = ManagerRepository.getInstance();
    private DisciplineRepository disciplineRepository = managerRepository.getDisciplineRepository();
    private StudentRepository studentRepository = managerRepository.getStudentRepository();

    public boolean registerDiscipline(DisciplineDTO disciplineDTO) {
        if(disciplineRepository.findByCode(disciplineDTO.getCode()) != null) return false;
        
        Discipline discipline = new Discipline(disciplineDTO.getName(), disciplineDTO.getCode(), disciplineDTO.getWorkload());
        disciplineRepository.save(discipline);
        return true;
    }

    public boolean enrollStudent(String code, String registration) {
        Discipline discipline = disciplineRepository.findByCode(code);
        Student student = studentRepository.findByRegistration(registration);

        discipline.addStudent(student);
        return true;
    }

    public boolean unenrollStudent(String code, String registration) {
        Discipline discipline = disciplineRepository.findByCode(code);
        Student student = studentRepository.findByRegistration(registration);
        if (discipline == null || student == null) return false;

        discipline.removeStudent(student);
        return true;
    }

    public boolean delete(String code) {
        Discipline discipline = disciplineRepository.findByCode(code);
        if (discipline == null) return false;

        disciplineRepository.delete(discipline);
        return true;
    }

    public boolean update(DisciplineDTO disciplineDTO) {
        Discipline discipline = disciplineRepository.findByCode(disciplineDTO.getCode());
        if (discipline == null) return false;

        if (!disciplineDTO.getName().isBlank() && !disciplineDTO.getName().equals(discipline.getName())) discipline.setName(disciplineDTO.getName());
        if (!disciplineDTO.getWorkload().isBlank() && !disciplineDTO.getWorkload().equals(discipline.getWorkload())) discipline.setWorkload(disciplineDTO.getWorkload());
        disciplineRepository.update(discipline);
        return true;
    }

    public String findAll() {
        return disciplineRepository.findAll();
    }
}
