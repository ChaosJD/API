package th.rosenheim.vv.Main;

import th.rosenheim.vv.Machine.Machine;
import th.rosenheim.vv.Output.OutputWriterFile;
import th.rosenheim.vv.reading.InputReaderFile;
import javax.xml.bind.JAXBException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/11/30
 */
public class main {
    
    public static void main(String[] args) throws JAXBException {

        BlockingQueue inputQueue= new LinkedBlockingQueue(10);;
        BlockingQueue outputQueue = new LinkedBlockingQueue(10);

        Thread inputThread = new Thread(new InputReaderFile(inputQueue));
        Thread machineThread = new Thread(new Machine(inputQueue, outputQueue));
        Thread outputThread = new Thread(new OutputWriterFile(outputQueue));

       outputThread.start();
       machineThread.start();
       inputThread.start();
    }
}
