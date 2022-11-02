package Transport;

import java.util.ArrayList;

public class Sponsor<T extends Transport> {
    private String name;
    private int supportMoney;
    private ArrayList<T> sponsoredTransport;

    public Sponsor(String name) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            System.out.println("Требуется указать название/имя спонсора");
        }
    }

    public String getName() {
        return name;
    }

    public int getSupportMoney() {
        return supportMoney;
    }

    public ArrayList<T> getSponsoredTransport() {
        return sponsoredTransport;
    }

    public void setSupportMoney(int supportMoney) {
        if (supportMoney > 0) {
            this.supportMoney = this.supportMoney + supportMoney;
        }
    }

    public void setSponsoredTransport(T transport) {
        if (this.sponsoredTransport == null) {
            ArrayList<T> sponsored = new ArrayList<>();
            this.sponsoredTransport = sponsored;
            sponsored.add(transport);
        } else {
            getSponsoredTransport().add(transport);
        }

    }

    public void sponsorRace(T transport, int supportMoney) {
        setSponsoredTransport(transport);
        setSupportMoney(supportMoney);
        transport.setSponsor(this);
        System.out.println("Спонсор " + getName() + " поддерживает " + transport.getBrand() + " " + transport.getModel() + " на сумму " + supportMoney);
    }

    @Override
    public String toString() {
        return "Спонсор " + name +
                ", сумма поддержки - " + supportMoney +
                ", поддерживаемый транспорт - " + sponsoredTransport;
    }
}
