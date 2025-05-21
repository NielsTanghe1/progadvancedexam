import models.Kamp;

import java.io.*;

public class PrintKamp {
    static void writeToFile(String fileName, Kamp kamp) throws IOException {
        File f = new File(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(kamp);
        oos.flush();
        oos.close();
    }
}
