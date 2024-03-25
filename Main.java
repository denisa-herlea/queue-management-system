import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

         View view = new View();
         Executie executie=new Executie(new ArrayList<>(), new ArrayList<>(), 0, 0, view);
         Controller controller = new Controller(view,executie);
    }
}
