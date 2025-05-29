package business.services;

import models.entities.Discipline;
import models.repositories.DisciplineRepository;

public class DisciplineService {
    private DisciplineRepository disciplineRepository = new DisciplineRepository();

    public boolean registerDiscipline(String name, String code, String workload) {
        if(disciplineRepository.findByCode(code) != null) return false;
        if(disciplineRepository.findByName(name) != null) return false;
        
        Discipline discipline = new Discipline(name, code, workload);
        disciplineRepository.save(discipline);
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

        if (!name.isBlank() && name != discipline.getName()) discipline.setName(name);
        if (!workload.isBlank() && workload != discipline.getWorkload()) discipline.setWorkload(workload);
        disciplineRepository.update(discipline);
        return true;
    }

    public String findAll() {
        return disciplineRepository.findAll();
    }
}
