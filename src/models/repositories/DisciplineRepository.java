package models.repositories;

import java.util.ArrayList;
import java.util.List;

import models.entities.Discipline;

public class DisciplineRepository {
    private List<Discipline> disciplines;

    public DisciplineRepository() {
        this.disciplines = new ArrayList<>();
    }

    public void save(Discipline entity) {
        disciplines.add(entity);
    }

    public void delete(Discipline entity) {
        disciplines.remove(entity);
    }

    public void update(Discipline entity) {
        for (int i = 0; i < disciplines.size(); i++) {
            if (disciplines.get(i).getCode().equals(entity.getCode())) {
                disciplines.get(i).setName(entity.getName());
                disciplines.get(i).setWorkload(entity.getWorkload());
                return;
            }
        }
    }

    public Discipline findByCode(String code) {
        for (Discipline discipline : disciplines) {
            if (discipline.getCode().equals(code)) {
                return discipline;
            }
        }
        return null;
    }

    public Discipline findByName(String name) {
        for (Discipline discipline : disciplines) {
            if (discipline.getName().equalsIgnoreCase(name)) {
                return discipline;
            }
        }
        return null;
    }

    public String findAll() {
        if(disciplines.isEmpty()) return null;

        StringBuilder sb = new StringBuilder();
        for (Discipline discipline : disciplines) {
            sb.append(discipline.toString()).append("\n");
        }
        return sb.toString();
    }
}
