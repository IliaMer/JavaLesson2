import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public static List<UserAddress> readBytesAddresses (Path path) throws IOException, ClassNotFoundException {
        FileInputStream s=new FileInputStream(path.toString());
        ObjectInputStream ois=new ObjectInputStream(s);
        List<User> users = ((List<User>) ois.readObject());
        List<UserAddress> addresses = new ArrayList<>();
        for (User user :
                users) {
            addresses.add(user.getAddress());
        }
        return addresses;
    }
}
