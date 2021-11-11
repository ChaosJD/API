package th.rosenheim.vv.Helping;

/**
 * @author Josef Sebastian Duschl
 *
 * Created on 2018/12/01
 */
public class HelpingMethods {

    /**
     *
     * @param str check if the submitter string is full
     * @return true if its null or Empty
     */
    public static boolean isNullOrEmptyString(String str) {
        return (str == null || str.isEmpty());
    }

    /**
     *
     * @param time takes the time in ms to sleep
     * @param thread takes the thread, that really the current thread sleeps
     */
    public static void threadSleep(int time, Thread thread) {
        try {
            thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }
}
