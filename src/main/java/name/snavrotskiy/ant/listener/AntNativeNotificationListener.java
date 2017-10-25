package name.snavrotskiy.ant.listener;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;

import java.awt.*;

import static java.awt.TrayIcon.MessageType.ERROR;
import static java.awt.TrayIcon.MessageType.INFO;

/**
 * Ant listener to make system notification after build finished
 */
public class AntNativeNotificationListener implements BuildListener {
    public void buildStarted(BuildEvent buildEvent) {
    }

    public void buildFinished(BuildEvent buildEvent) {
        showTrayIcon(buildEvent);
    }

    public void targetStarted(BuildEvent buildEvent) {
    }

    public void targetFinished(BuildEvent buildEvent) {
    }

    public void taskStarted(BuildEvent buildEvent) {
    }

    public void taskFinished(BuildEvent buildEvent) {
    }

    public void messageLogged(BuildEvent buildEvent) {
    }

    private void showTrayIcon(BuildEvent buildEvent) {
        final Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        final TrayIcon trayIcon = new TrayIcon(image, "Ant build notifier");
        trayIcon.setImageAutoSize(true);

        try {
            SystemTray.getSystemTray().add(trayIcon);
        } catch (AWTException e) {
            System.err.println("AWTException occurred during showing the notification. Error message = " + e.getMessage());
            return;
        }

        final Throwable exception = buildEvent.getException();
        if (exception == null) {
            trayIcon.displayMessage("Build success", "", INFO);
        } else {
            final Throwable rootCause = findRootCause(exception);
            trayIcon.displayMessage("Build failed", rootCause.getMessage(), ERROR);
        }
    }

    private Throwable findRootCause(Throwable sourceThrowable) {
        Throwable lastCause = sourceThrowable;

        while (lastCause.getCause() != null) {
            lastCause = lastCause.getCause();
        }

        return lastCause;
    }
}
