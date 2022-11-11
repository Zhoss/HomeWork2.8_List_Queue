package Transport;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceStation <T extends Transport> {
    private String name;
    private Queue<T> queue = new LinkedList<>();

    public ServiceStation(String name) {
        if (name != null && !name.isEmpty() && !name.isBlank()) {
            this.name = name;
        } else {
            System.out.println("Необходимо указать название станции обслуживания");
        }
    }

    public String getName() {
        return name;
    }

    public Queue<T> getQueue() {
        return queue;
    }

    public void addTransport(T transport) {
        if (transport != null && transport.getClass() != Bus.class) {
            queue.offer(transport);
        }
    }

    public void doDiagnostic() {
        T transport = queue.poll();
        if (transport != null) {
            if (transport.passedDiagnostics()) {
                System.out.println("Транспорту " + transport.getBrand() + " " + transport.getModel() + " не требуется диагностика");
                doDiagnostic();
            } else {
                System.out.println("Транспорт " + transport.getBrand() + " " + transport.getModel() + " прошел диагностику");
                doDiagnostic();
            }
        }
    }
}
