package business.services;

import models.entities.Discipline;
import models.entities.Student;
import models.repositories.ManagerRepository;

public class DisciplineService {
    private static final ManagerRepository managerRepository = ManagerRepository.getInstance();

    public boolean registerDiscipline(String name, String code, String workload) {
        if(managerRepository.getDisciplineRepository().findByCode(code) != null) return false;
        
        Discipline discipline = new Discipline(name, code, workload);
        managerRepository.getDisciplineRepository().save(discipline);
        return true;
    }

    public boolean enrollStudent(String code, String registration) {
        Discipline discipline = managerRepository.getDisciplineRepository().findByCode(code);
        Student student = managerRepository.getStudentRepository().findByRegistration(registration);

        discipline.addStudent(student);
        return true;
    }

    public boolean unenrollStudent(String code, String registration) {
        Discipline discipline = managerRepository.getDisciplineRepository().findByCode(code);
        Student student = managerRepository.getStudentRepository().findByRegistration(registration);
        if (discipline == null || student == null) return false;

        discipline.removeStudent(student);
        return true;
    }

    public boolean delete(String code) {
        Discipline discipline = managerRepository.getDisciplineRepository().findByCode(code);
        if (discipline == null) return false;

        managerRepository.getDisciplineRepository().delete(discipline);
        return true;
    }

    public boolean update(String name, String code, String workload) {
        Discipline discipline = managerRepository.getDisciplineRepository().findByCode(code);
        if (discipline == null) return false;

        if (!name.isBlank() && !name.equals(discipline.getName())) discipline.setName(name);
        if (!workload.isBlank() && !workload.equals(discipline.getWorkload())) discipline.setWorkload(workload);
        managerRepository.getDisciplineRepository().update(discipline);
        return true;
    }

    public String findAll() {
        return managerRepository.getDisciplineRepository().findAll();
    }
}
