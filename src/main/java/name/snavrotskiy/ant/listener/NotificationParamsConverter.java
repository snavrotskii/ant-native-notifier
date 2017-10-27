package name.snavrotskiy.ant.listener;

import org.apache.tools.ant.BuildEvent;

import java.net.URL;

/**
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY.
 * <p>
 * This class converts ant build event to notification parameters.
 */
class NotificationParamsConverter {
    /**
     * Icon for successful build.
     */
    private static final String ICON_SUCCESS = "/image/positive.png";
    /**
     * Icon for build fail.
     */
    private static final String ICON_FAIL = "/image/negative.png";

    /**
     * Convert ant build event to notification parameters.
     *
     * @param buildEvent ant build event
     * @return notification parameters
     */
    NotificationParams convert(final BuildEvent buildEvent) {

        final NotificationParams notificationParams;

        final Throwable exception = buildEvent.getException();

        if (exception == null) {
            final URL icon = AntNativeNotificationListener.class.getResource(ICON_SUCCESS);
            notificationParams = new NotificationParams(icon, "Build success", "");
        } else {
            final URL icon = AntNativeNotificationListener.class.getResource(ICON_FAIL);
            final Throwable rootCause = findRootCause(exception);
            notificationParams = new NotificationParams(icon, "Build failed", rootCause.getMessage());
        }

        return notificationParams;
    }

    /**
     * Search for root cause of throwable.
     *
     * @param sourceThrowable exception
     * @return root cause ot itself
     */
    private Throwable findRootCause(final Throwable sourceThrowable) {
        Throwable rootCause = sourceThrowable;

        while (rootCause.getCause() != null) {
            rootCause = rootCause.getCause();
        }

        return rootCause;
    }
}
