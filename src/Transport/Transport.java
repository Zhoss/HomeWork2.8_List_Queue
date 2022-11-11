package Transport;

import Driver.Driver;

import java.util.ArrayList;

public abstract class Transport<T extends Mechanic, S extends Driver, M extends Sponsor> {
    private final String brand;
    private final String model;
    private double engineVolume;
    private ArrayList<T> assignedMechanics;
    private S assignedDriver;
    private M sponsor;

    public Transport(String brand, String model, double engineVolume) {
        if (brand != null && !brand.isBlank()) {
            this.brand = brand;
        } else {
            this.brand = "default";
        }

        if (model != null && !model.isBlank()) {
            this.model = model;
        } else {
            this.model = "default";
        }

        setEngineVolume(engineVolume);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public ArrayList<T> getAssignedMechanics() {
        return assignedMechanics;
    }

    public S getAssignedDriver() {
        return assignedDriver;
    }

    public M getSponsor() {
        return sponsor;
    }

    public void setEngineVolume(double engineVolume) {
        if (engineVolume > 0 && engineVolume < 30) {
            this.engineVolume = engineVolume;
        } else {
            this.engineVolume = 1.5;
        }
    }

    public void setAssignedMechanics(T assignedMechanics) {
        if (this.assignedMechanics == null) {
            ArrayList<T> mechanics = new ArrayList<>();
            this.assignedMechanics = mechanics;
            mechanics.add(assignedMechanics);
        } else {
            getAssignedMechanics().add(assignedMechanics);
        }
    }

    public void setAssignedDriver(S assignedDriver) {
        if (assignedDriver != null) {
            this.assignedDriver = assignedDriver;
        } else {
            System.out.println("Требуется указать назначенного водителя");
        }
    }

    public void setSponsor(M sponsor) {
        if (sponsor != null) {
            this.sponsor = sponsor;
        }
    }

    public abstract boolean passedDiagnostics();

    public abstract void startDriving();

    public abstract void finishDriving();

    @Override
    public String toString() {
        return "Транспорт " + getBrand() +
                ", модель - " + getModel() +
                ", объем двигателя - " + getEngineVolume() + " л" +
                ", " + getAssignedDriver() +
                ", механики " + getAssignedMechanics();
    }
}
