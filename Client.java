public class Client implements Comparable<Client> {

    private int id;
    private int arrivalTime;
    private int serviceTime;

    public Client(int id, int arrivalTime, int serviceTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    public int compareTo(Client client) {
        return this.arrivalTime - client.arrivalTime;
    }

    @Override
    public String toString() {
        return "("+this.id+","+this.arrivalTime+","+this.serviceTime+")";
    }
}
