package char14.bounce.blockingQueue;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author gy1zc3@gmail.com
 *         Created by zacky on 15:50.
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter base directory (e.g. /usr/local/): ");
        String directory = in.nextLine();
        System.out.print("Enter keyword (e.g. volatile): ");
        String keyword = in.nextLine();

        final int FILE_QUEUE_SIZE = 10;
        final int SEARCH_THREADS = 100;

        BlockingQueue<File> queue = new ArrayBlockingQueue<>(FILE_QUEUE_SIZE);

        FileEnumerationTask enumerator = new FileEnumerationTask(queue, new File(directory));
        new Thread(enumerator).start();
        for (int i = 1; i <= SEARCH_THREADS; i++)
            new Thread(new SearchTask(queue,keyword)).start();
    }
}

class FileEnumerationTask implements Runnable{
    public static File DUMMY = new File("");
    private BlockingQueue<File> queue;
    private File startignDirectory;

    public FileEnumerationTask(BlockingQueue<File> queue, File startignDirectory){
        this.queue = queue;
        this.startignDirectory = startignDirectory;
    }

    @Override
    public void run() {
        try{
            enumerate(startignDirectory);
            queue.put(DUMMY);
        }
        catch (InterruptedException e){

        }
    }
    public void enumerate(File directory) throws InterruptedException{
        File[] files = directory.listFiles();
        for(File file : files){
            if(file.isDirectory()) enumerate(file);
            else queue.put(file);
        }
    }
}

class SearchTask implements Runnable{
    private BlockingQueue<File> queue;
    private String keyword;

    public SearchTask(BlockingQueue<File> queue, String keyword){
        this.queue = queue;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        try{
            boolean done = false;
            while (!done){
                File file = queue.take();
                if(file == FileEnumerationTask.DUMMY){
                    queue.put(file);
                    done = true;
                }
                else search(file);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (InterruptedException e){

        }
    }

    public void search(File file) throws IOException{
        try(Scanner in = new Scanner(file)){
            int lineNumber = 0;
            while (in.hasNext()){
                lineNumber++;
                String line = in.nextLine();
                if(line.contains(keyword))
                    System.out.printf("%s:%d%:%s%n",file.getPath(),lineNumber,line);
            }
        }
    }
}
