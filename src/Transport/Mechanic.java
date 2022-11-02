package Transport;

import java.util.ArrayList;

public class Mechanic <T extends Transport, S extends Sponsor> {
    private String name;
    private String lastName;
    private S workCompany;
    private ArrayList<T> transportCanWork;

    public Mechanic(String name, String lastName, S workCompany) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            System.out.println("Требует указать имя механика");
        }

        if (lastName != null && !lastName.isEmpty() && !lastName.isBlank()) {
            this.lastName = lastName;
        } else {
            System.out.println("Требует указать фамилию механика");
        }

        setWorkCompany(workCompany);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public S getWorkCompany() {
        return workCompany;
    }

    public ArrayList<T> getTransportCanWork() {
        return transportCanWork;
    }

    public void setWorkCompany(S workCompany) {
        if (workCompany != null) {
            this.workCompany = workCompany;
        }
    }

    public void setTransportCanWork(T transportCanWork) {
        if (this.transportCanWork == null) {
            ArrayList<T> canWork = new ArrayList<>();
            this.transportCanWork = canWork;
            canWork.add(transportCanWork);
            transportCanWork.setAssignedMechanics(this);
        } else {
            getTransportCanWork().add(transportCanWork);
        }
    }

    @Override
    public String toString() {
        return "Механик " + name + " " + lastName +
                ", местро работы - " + workCompany.getName();
    }

    public void doMaintenance(T transport) {
        if (getTransportCanWork().contains(transport)) {
            System.out.println("Механик " + getName() + " " + getLastName() + " проводит техобслуживание транспортного средства " + transport.getBrand() + " " + transport.getModel());
        } else {
            System.out.println("Механик не обладает навыками для техобслуживаения транспортного средства " + transport.getBrand() + " " + transport.getModel());
        }
    }

    public void repairTransport(T transport) {
        if (getTransportCanWork().contains(transport)) {
            System.out.println("Механик " + getName() + " " + getLastName() + " проводит ремонт транспортного средства " + transport.getBrand() + " " + transport.getModel());
        } else {
            System.out.println("Механик не обладает навыками для ремонта транспортного средства " + transport.getBrand() + " " + transport.getModel());
        }
    }
}
