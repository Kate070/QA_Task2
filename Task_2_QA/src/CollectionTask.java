import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTask {
    private Collection<String> collectionA;
    private Collection<String> collectionB;
    CollectionTask(){
        this.collectionA = Arrays.asList("Oleg","Dima","Masha","Mira","Olga");
        this.collectionB = Arrays.asList("Mira","Oleg","Olga");
    }
    public  void compareCollections() {
        ArrayList<String> result = new ArrayList<>();
        for (String s : collectionA) {
            if (!collectionB.contains(s)) {
                result.add(s);
            }
        }
        for (String s : result) {
            System.out.println(s);
        }
    }
}
