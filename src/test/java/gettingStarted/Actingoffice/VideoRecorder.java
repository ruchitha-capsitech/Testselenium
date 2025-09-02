package gettingStarted.Actingoffice;

import org.monte.screenrecorder.ScreenRecorder;
import java.awt.*;
import java.io.File;

public class VideoRecorder {
    private static ScreenRecorder screenRecorder;
    private static String currentFilePath;

    public static void startRecording(String methodName) throws Exception {
        File file = new File("target/videos/");
        if (!file.exists()) {
            file.mkdirs();
        }

        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        screenRecorder = new SpecializedScreenRecorder(gc, gc.getBounds(), file, methodName);
        currentFilePath = "target/videos/" + methodName + ".avi";
        screenRecorder.start();
    }

    public static String stopRecording() throws Exception {
        if (screenRecorder != null) {
            screenRecorder.stop();
            return currentFilePath;  // return AVI path directly
        }
        return null;
    }
}
