import Driver.Driver;
import Driver.DriverB;
import Driver.DriverC;
import Driver.DriverD;
import Transport.Bus;
import Transport.Car;
import Transport.Transport;
import Transport.Truck;
import Transport.Sponsor;
import Transport.Mechanic;
import Transport.ServiceStation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Car subaru = new Car("Subaru", "Impreza", 2.0, Car.BodyType.SEDAN, true);
        Car mitsubishi = new Car("Mitsubishi", "Lancer", 2.5, null, true);
        Car citroen = new Car("Citroen", "C4", 2.2, Car.BodyType.HATCHBACK, true);
        Car ford = new Car("Ford", "Escort", 1.8, Car.BodyType.MINIVAN, false);
//        System.out.println(mitsubishi);
//        Car.BodyType.identifyBodyType(mitsubishi);
//        Car.BodyType.identifyBodyType(ford);
//        subaru.pitStop();
//        System.out.println("");

        Truck kamaz = new Truck("КАМАЗ", "4350-9", 12.0, Truck.CarryingCapacity.N2, true);
        Truck tatra = new Truck("Tatra", "T-138", 11.5, Truck.CarryingCapacity.N1, false);
        Truck iveco = new Truck("IVECO", "Iveco", 12.9, Truck.CarryingCapacity.N3, true);
        Truck ginaf = new Truck("Ginaf", "Rally Power", 11.7, null, true);
//        System.out.println(kamaz);
//        Truck.CarryingCapacity.identifyCarryingCapacity(iveco);
//        Truck.CarryingCapacity.identifyCarryingCapacity(ginaf);
//        tatra.bestLapTime();
//        System.out.println("");

        Bus man = new Bus("Man", "Lion’s City C", 9.0, Bus.SeatQuantity.SMALL);
        Bus volvo = new Bus("Volvo", "7900", 7.4, Bus.SeatQuantity.LARGE);
        Bus liaz = new Bus("ЛиАЗ", "5256.58", 6.7, Bus.SeatQuantity.EXTRA_LARGE);
        Bus hyundai = new Bus("Hyundai", "Aero Town", 7.5, null);
//        System.out.println(liaz);
//        Bus.SeatQuantity.identifySeatQuantity(man);
//        Bus.SeatQuantity.identifySeatQuantity(hyundai);
//        hyundai.maxSpeed();

        Set<Transport> racingTransport = new HashSet<>();
        racingTransport.add(subaru);
        racingTransport.add(mitsubishi);
        racingTransport.add(citroen);
        racingTransport.add(ford);
        racingTransport.add(kamaz);
        racingTransport.add(tatra);
        racingTransport.add(iveco);
        racingTransport.add(ginaf);
        racingTransport.add(man);
        racingTransport.add(volvo);
        racingTransport.add(liaz);
        racingTransport.add(hyundai);

        checkDiagnostics(racingTransport);
        System.out.println("");

        DriverB denis = new DriverB("Жосан Денис Сергеевич", true, 8);
        DriverC dmitriy = new DriverC("Василенко Дмитрий Петрович", true, 6);
        DriverD nicolai = new DriverD("Ткаченко Николай Александрович", true, 12);

        Set<Driver> drivers = new HashSet<>();
        drivers.add(denis);
        drivers.add(dmitriy);
        drivers.add(nicolai);

        denis.setDrivenTransport(subaru);
//        denis.startDriving();
//        denis.drive();
        dmitriy.setDrivenTransport(iveco);
//        dmitriy.drive();
        nicolai.setDrivenTransport(man);
//        nicolai.drive();

        Sponsor rosneft = new Sponsor("Роснефть");
        rosneft.sponsorRace(subaru, 100_000);
        rosneft.sponsorRace(mitsubishi, 50_000);
        Sponsor gazprom = new Sponsor("Газпром");
        Sponsor beeline = new Sponsor("Билайн");
        System.out.println("");

        Set<Sponsor> sponsors = new HashSet<>();
        sponsors.add(rosneft);
        sponsors.add(gazprom);
        sponsors.add(beeline);

        Mechanic<Bus, Sponsor> andrei = new Mechanic("Андрей", "Патрушев", rosneft);
        Mechanic<Car, Sponsor> vadim = new Mechanic("Вадим", "Белов", gazprom);
        Mechanic<Truck, Sponsor> michail = new Mechanic("Михаил", "Клинов", beeline);

        Set<Mechanic> mechanics = new HashSet<>();
        mechanics.add(andrei);
        mechanics.add(vadim);
        mechanics.add(michail);

        andrei.setTransportCanWork(man);
        andrei.setTransportCanWork(volvo);
        vadim.setTransportCanWork(subaru);
        andrei.doMaintenance(man);
        andrei.repairTransport(volvo);
        andrei.doMaintenance(hyundai);
        System.out.println("");

        checkTransportData(subaru);
        System.out.println("");

        ServiceStation<Transport> serviceStation = new ServiceStation<Transport>("Станция обслуживания");

        for (Transport transport : racingTransport) {
            serviceStation.addTransport(transport);
        }

        serviceStation.doDiagnostic();
    }

    public static void checkTransport(Set<Transport> list) {
        for (Transport transport : list) {
            if (transport.passedDiagnostics() && (transport.getClass() == Car.class || transport.getClass() == Truck.class)) {
                System.out.println("Транспорт " + transport.getBrand() + " " + transport.getModel() + " прошел диагностику");
            } else if (transport.getClass() == Bus.class) {
                System.out.println("Автобусу " + transport.getBrand() + " " + transport.getModel() + " не требуется диагностика");
            } else {
                throw new IllegalArgumentException("Транспортному средству " + transport.getBrand() + " " + transport.getModel() + " необходимо произвести диагностику");
            }
        }
    }

    public static void checkDiagnostics(Set<Transport> list) {
        try {
            checkTransport(list);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void checkTransportData(Transport transport) {
        System.out.println("Транспортное средство " + transport.getBrand() + " " + transport.getModel() + ", водитель " + transport.getAssignedDriver().getFullName() + ", механики " + transport.getAssignedMechanics() + ", спонсор " + transport.getSponsor().getName());
    }
}