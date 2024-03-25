import static java.lang.Integer.parseInt;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {

    private View view;
    private Executie executie;


    public Controller(View view,Executie executie){
        this.view=view;
        this.executie=executie;

        this.view.addStartListener(e->{
            try{
                int n;
                int q;
                int maxSimulationTime;
                int minArrivalTime, maxArrivalTime;
                int minServiceTime,maxServiceTime;

                n=Integer.parseInt(view.getnTextField());
                q=Integer.parseInt(view.getqTextField());
                maxSimulationTime=Integer.parseInt(view.getSimulationTimeTextArea());
                minArrivalTime=Integer.parseInt(view.getMinArrivalTextArea());
                maxArrivalTime=Integer.parseInt(view.getMaxArrivalTextArea());
                minServiceTime=Integer.parseInt(view.getMinServiceTextArea());
                maxServiceTime=Integer.parseInt(view.getMinServiceTextArea());

                for(int i=1;i<=n;i++) {
                    Random rand = new Random();
                    int arrivalTime = rand.nextInt(maxArrivalTime + 1 - minArrivalTime) + minArrivalTime;
                    int serviceTime = rand.nextInt(maxServiceTime + 1 - minServiceTime) + minServiceTime;

                    Client client = new Client(i, arrivalTime, serviceTime);

                    executie.addClient(client);

                }
                for(int i=1;i<=q;i++)
                {
                    Coada coada= new Coada(i,maxSimulationTime, new AtomicInteger(0));
                    executie.addQueue(coada);
                }
                executie.setSimulationTime(maxSimulationTime);
                executie.setQ(q);
                executie.setN(n);
                executie.start();

            }
            catch(Exception ex){
                System.out.println("eroare");
            }
        });
    }


}
