package th.rosenheim.vv.reading;


import th.rosenheim.vv.Helping.HelpingMethods;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * @author Josef Sebastian Duschl
 * <p>
 * Created on 2018/11/30
 */
public class InputReaderFile implements Runnable {

    private BlockingQueue queue;

    public InputReaderFile(BlockingQueue queue) {
        this.queue = queue;
    }

    public InputReaderFile() {
    }

    @Override
    public void run() {
        while (Thread.currentThread().isAlive()) {
            Path path = Paths.get("input");
            File parent = new File(path.toString());
            String extension = ".msg";

            File[] files = parent.listFiles(new FileFilter() {

                public boolean accept(File dir) {
                    String name = dir.getName();
                    if (name.endsWith(extension)) {
                        return true;
                    }
                    return false;
                }
            });

            List<File> retval = Arrays.asList(files);

            if (retval.isEmpty()) {
                HelpingMethods.threadSleep(10, Thread.currentThread());
                continue;
            }

            String filename = retval.get(0).toString();
            String[] result = filename.split("\\.")[0].split("/")[1].split("");
            for (String s : result) {
                try {
                    queue.put(s);
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                    System.out.println("e.printSTrackTrace Error");
                    HelpingMethods.threadSleep(10, Thread.currentThread());
                    continue;
                }
            }

            try {
                Files.delete(Paths.get(filename));
            } catch (IOException e) {
                e.printStackTrace();
            }
            HelpingMethods.threadSleep(10, Thread.currentThread());
        }

    }

}
