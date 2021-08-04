public class TaskRunner {
    public static void runTask1(){
        FileTask.createFiltredFile();
    }
    public static void runTask2(){
        FileTask.createSortedFile();
    }
    public static void runTask3(){
        CollectionTask collectionTask = new CollectionTask();
        collectionTask.compareCollections();
    }
    public static void runAll(){
        runTask1();
        runTask2();
        runTask3();
    }
}
