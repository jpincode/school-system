package models.entities;

public class Discipline {
    private String name, code, workload;

    public Discipline(String name, String code, String workload) {
        this.name = name;
        this.code = code;
        this.workload = workload;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    @Override
    public String toString() {
        return "Discipline [name=" + name + ", code=" + code + ", workload=" + workload + "]";
    }
}
