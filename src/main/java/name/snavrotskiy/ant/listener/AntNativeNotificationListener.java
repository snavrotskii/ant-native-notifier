package name.snavrotskiy.ant.listener;

import org.apache.tools.ant.BuildEvent;
import org.apache.tools.ant.BuildListener;

/**
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY.
 * <p>
 * Apache Ant build tool listener to make system notification after build completion.
 */
public final class AntNativeNotificationListener implements BuildListener {
    /**
     * Signals that a build has started. This event
     * is fired before any targets have started.
     * <p>
     * Not implemented.
     *
     * @param buildEvent ant build event
     */
    public void buildStarted(final BuildEvent buildEvent) {
    }

    /**
     * Signals that the last target has finished. This event
     * will still be fired if an error occurred during the build.
     * <p>
     * Makes system notification.
     *
     * @param buildEvent ant build event
     */
    public void buildFinished(final BuildEvent buildEvent) {
        showTrayIcon(buildEvent);
    }

    /**
     * Signals that a target is starting.
     * <p>
     * Not implemented.
     *
     * @param buildEvent ant build event
     */
    public void targetStarted(final BuildEvent buildEvent) {
    }

    /**
     * Signals that a target has finished. This event will
     * still be fired if an error occurred during the build.
     * <p>
     * Not implemented.
     *
     * @param buildEvent ant build event
     */
    public void targetFinished(final BuildEvent buildEvent) {
    }

    /**
     * Signals that a task is starting.
     * <p>
     * Not implemented.
     *
     * @param buildEvent ant build event
     */
    public void taskStarted(final BuildEvent buildEvent) {
    }

    /**
     * Signals that a task has finished. This event will still
     * be fired if an error occurred during the build.
     * <p>
     * Not implemented.
     *
     * @param buildEvent ant build event
     */
    public void taskFinished(final BuildEvent buildEvent) {
    }

    /**
     * Signals a message logging event.
     * <p>
     * Not implemented.
     *
     * @param buildEvent ant build event
     */
    public void messageLogged(final BuildEvent buildEvent) {
    }

    /**
     * Start point to make notification.
     *
     * @param buildEvent ant build event
     */
    private void showTrayIcon(final BuildEvent buildEvent) {
        final NotificationParamsConverter paramsConverter = new NotificationParamsConverter();
        final NotificationParams notificationParams = paramsConverter.convert(buildEvent);
        NotificationProvider.notify(notificationParams);
    }
}
