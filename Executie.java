import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Executie extends Thread{

    private List<Client> waitingClients=new ArrayList<>();
    private List<Coada> cozi=new ArrayList<>();
    private List<Client> toRemove = new ArrayList<>();
    private double waitingTime;
    private int simulationTime;
    private int q,n;
    private View view;
    FileWriter fileWriter = new FileWriter("data.txt");
    PrintWriter printWriter = new PrintWriter("data.txt", "UTF-8");


    public Executie(List<Coada> cozi, List<Client> clienti, int n, int time, View view) throws IOException {
        this.cozi=cozi;
        this.waitingClients=clienti;
        this.n=n;
        this.simulationTime=time;
        this.view=view;
    }

    public void setN(int n) {
        this.n=n;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public void setSimulationTime(int simulationTime) {
        this.simulationTime = simulationTime;
    }

    public void addClient(Client client){
        waitingClients.add(client);
    }

    public void addQueue(Coada queue){
        cozi.add(queue);
    }

    public void minusServiceTime() {
        for (Coada coada : cozi) {
            if (!coada.getClientiCoada().isEmpty()) {
                Client client = coada.getClientiCoada().get(0);
                if (client.getServiceTime() == 1) {
                    client.setServiceTime(client.getServiceTime() - 1);
                    coada.getClientiCoada().remove(client);
                } else {
                    client.setServiceTime(client.getServiceTime() - 1);
                }
            }
        }
    }

    public void asezareCoada(Client t) {
        AtomicInteger  minTime = new AtomicInteger(9999);
        Coada chosenServer = cozi.get(0);
        for (Coada i : cozi) {
            if (i.getWaitingPeriod().get() < minTime.get()) {
                minTime = i.getWaitingPeriod();
                chosenServer = i;
            }
        }
        chosenServer.addCoada(t);
    }


    public void run() {

        for(Coada coada:cozi){
            coada.setDeschisa(true);
            coada.start();
            }

        int timp = 0;
        int nr = 0;
        double waitingTotal = 0;
        for (Client client : waitingClients) {
            waitingTotal += client.getServiceTime();
        }

        while(timp<simulationTime) {

            if (waitingClients.isEmpty()) {
                if (nr == q) {
                    //printWriter.close();
                    break;
                }
            }

            minusServiceTime();

            for (Client client : waitingClients) {
                if (timp == client.getArrivalTime()) {
                    asezareCoada(client);
                    toRemove.add(client);
                }
            }

            waitingClients.removeAll(toRemove);
            printWriter.print("Time " + timp);
            printWriter.println();

            printWriter.print("Waiting clients: ");

            for (Client client : waitingClients) {
                printWriter.print(client.toString() + ";");
            }

            nr = 0;
            printWriter.println();

            for (Coada coada : cozi) {
                if (coada.getClientiCoada().isEmpty()) {
                    nr++;
                    printWriter.print(coada);
                    printWriter.println();

                } else {
                    printWriter.print(coada);
                    printWriter.println();
                }
            }
            printWriter.println();
           timp++;
        }
        waitingTime =  waitingTotal / n;
        printWriter.print("Average waiting time: " + waitingTime);
        printWriter.close();
    }
}
