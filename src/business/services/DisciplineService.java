package business.services;

import models.entities.Discipline;
import models.entities.Student;
import models.repositories.DisciplineRepository;
import models.repositories.StudentRepository;

public class DisciplineService {
    private static final DisciplineRepository disciplineRepository = new DisciplineRepository();
    private static final StudentRepository studentRepository = StudentRepository.getInstance();

    public boolean registerDiscipline(String name, String code, String workload) {
        if(disciplineRepository.findByCode(code) != null) return false;
        
        Discipline discipline = new Discipline(name, code, workload);
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

    public boolean update(String name, String code, String workload) {
        Discipline discipline = disciplineRepository.findByCode(code);
        if (discipline == null) return false;

        if (!name.isBlank() && !name.equals(discipline.getName())) discipline.setName(name);
        if (!workload.isBlank() && !workload.equals(discipline.getWorkload())) discipline.setWorkload(workload);
        disciplineRepository.update(discipline);
        return true;
    }

    public String findAll() {
        return disciplineRepository.findAll();
    }
}
