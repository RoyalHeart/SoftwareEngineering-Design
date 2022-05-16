import java.util.ArrayList;

public class Hierarchy {
    public static void main(String[] args) throws Exception {
        Employee president = new Employee();
        president.setName("President1");
        president.setType("President");

        Employee dean = new Employee();
        dean.setName("Dean1");
        dean.setType("Dean");

        Employee lecturer = new Employee();
        lecturer.setName("Lecturer1");
        lecturer.setType("Lecturer");

        Employee assistant = new Employee();
        assistant.setName("Assistant");
        assistant.setType("Assistant");

        dean.addSubordinates(lecturer);
        dean.addSubordinates(assistant);

        president.addSubordinates(dean);

        dean.printHierarchy();
    }
}

class Employee {
    private String name;
    private String type;
    private ArrayList<Employee> subordinates = new ArrayList<Employee>();

    public void addSubordinates(Employee e) {
        this.subordinates.add(e);
    }

    public void removeSubordinates(Employee e) {
        this.subordinates.remove(e);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void printHierarchy() {
        if (this.subordinates.size() == 0) {
            System.out.println("Type: " + this.type + ", Name: " + this.name);
        } else {
            System.out.println("Type: " + this.type + ", Name: " + this.name);
            for (Employee e : this.subordinates) {
                e.printHierarchy();
            }
        }
    }
}
