package models.repositories;

public class ManagerRepository {
    private static ManagerRepository instance;
    private StudentRepository studentRepository;
    private DisciplineRepository disciplineRepository;

    private ManagerRepository() {
        this.studentRepository = new StudentRepository();
        this.disciplineRepository = new DisciplineRepository();
    }

    public static ManagerRepository getInstance() {
        if (instance == null) {
            instance = new ManagerRepository();
        }
        return instance;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public DisciplineRepository getDisciplineRepository() {
        return disciplineRepository;
    }
}
