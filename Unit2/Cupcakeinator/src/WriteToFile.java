import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteToFile {
    public WriteToFile(ArrayList<Object> order) {
        try{
            FileWriter fw = new FileWriter("salesData.txt", true);
            PrintWriter salesWriter = new PrintWriter(fw);

            for (Object item: order){
                salesWriter.println(item);
            }

            salesWriter.close();
        }catch (IOException e){
            System.out.println("An error occured");
        }
    }
}
