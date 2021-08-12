import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Writer {

    public static void writeObjectsToFile(Path path, List<Object> list) {
        ArrayList<String> data = new ArrayList<>();
        for (Object u : list) {
            data.add(u.toString());
        }
        try {
            Files.write(Paths.get(path.toString()), data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeBytesToFile(Path path, List<Object> list) throws IOException {
        FileOutputStream fos=new FileOutputStream(path.toString());
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        list.forEach(object -> {
            try {
                oos.writeObject(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        oos.close();
    }
}
