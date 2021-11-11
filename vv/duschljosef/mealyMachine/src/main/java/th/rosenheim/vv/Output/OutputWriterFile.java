package th.rosenheim.vv.Output;

import th.rosenheim.vv.Helping.HelpingMethods;
import th.rosenheim.vv.Machine.Symbol;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.BlockingQueue;

public class OutputWriterFile implements Runnable {

    private BlockingQueue queueOutput;
    private final String DIRECTORY = "output/";
    private Symbol symbol;

    public OutputWriterFile(BlockingQueue queue) {
        this.queueOutput = queue;
    }

    @Override
    public void run() {
        while (Thread.currentThread().isAlive()) {
            Path path = null;
            try {
                String s = queueOutput.take().toString();
                path = Paths.get(DIRECTORY + s + ".msg");
                System.out.println(path.toString());
                Files.createFile(path);
                HelpingMethods.threadSleep(10, Thread.currentThread());
            } catch (InterruptedException | IOException e) {
                HelpingMethods.threadSleep(10, Thread.currentThread());
                continue;
            }
        }

    }
}
