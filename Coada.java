import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Coada extends Thread{

    private int idCoada;
    private String statusCoada;
    private Client clientCoada;
    private List<Client> clientiCoada=new ArrayList<>();
    private int simulationTime=0;
    private AtomicInteger waitingPeriod;
    private boolean deschisa;


    public Coada(int idCoada, int simulationTime, AtomicInteger waitingPeriod) {
        this.idCoada = idCoada;
        this.simulationTime = simulationTime;

        this.waitingPeriod = waitingPeriod;
    }

    public void setDeschisa(boolean deschisa) {
        this.deschisa = deschisa;
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public List<Client> getClientiCoada() {
        return clientiCoada;
    }

    public int getIdCoada() {
        return idCoada;
    }

    public void setIdCoada(int idCoada) {
        this.idCoada = idCoada;
    }

    public int getSimulationTime() {
        return simulationTime;
    }

    public void setSimulationTime(int simulationTime) {
        this.simulationTime = simulationTime;
    }

    public Client getClientCoada() {
        return clientCoada;
    }

    public void setClientCoada(Client clientCoada) {
        this.clientCoada = clientCoada;
    }

    public String getStatusCoada() {
        return statusCoada;
    }

    public void setStatusCoada(String statusCoada) {
        this.statusCoada = statusCoada;
    }

    public void addCoada(Client client)
    {
       clientiCoada.add(client);
       int i;
       for(i=1;i<=client.getServiceTime();i++)
           waitingPeriod.getAndIncrement();
    }

    public String toString(){
        if(clientiCoada.isEmpty()){
            return "Queue " + this.idCoada + ": closed";
        }
        else{
            return "Queue " + this.idCoada + ": " + clientiCoada;
        }
    }


    public void run () {
        while (deschisa) {
            clientCoada = null;
            try {
                if (clientiCoada.isEmpty()) {
                    Thread.sleep(1000);
                } else {
                    clientCoada = clientiCoada.get(0);
                    Thread.sleep(clientCoada.getServiceTime()* 1000L);
                    clientiCoada.remove(clientCoada);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }




