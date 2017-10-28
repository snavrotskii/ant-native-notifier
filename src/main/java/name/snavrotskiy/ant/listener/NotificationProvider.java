package name.snavrotskiy.ant.listener;

import fr.jcgay.notification.Application;
import fr.jcgay.notification.Icon;
import fr.jcgay.notification.Notification;
import fr.jcgay.notification.Notifier;
import fr.jcgay.notification.SendNotification;
import org.jetbrains.annotations.NotNull;

/**
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY.
 * <p>
 * This class can be used to make system notification with specified parameters.
 */
final class NotificationProvider {
    /**
     * Timeout for showing notification.
     */
    private static final int MAX_TIMEOUT_MILLIS = 2000;

    /**
     * Default constructor for notification provider.
     */
    private NotificationProvider() {
    }

    /**
     * Makes system notification.
     *
     * @param params notification parameters data object
     */
    static void notify(@NotNull final NotificationParams params) {
        final Application application = Application.builder()
                .id("send-notification")
                .name("SystemTray Example")
                .icon(Icon.create(params.getIcon(), "app"))
                .timeout(MAX_TIMEOUT_MILLIS)
                .build();

        final Notifier notifier = new SendNotification()
                .setApplication(application)
                .initNotifier();

        final Notification notification = Notification.builder()
                .title(params.getTitle())
                .message(params.getMessage())
                .icon(Icon.create(params.getIcon(), "ok"))
                .build();

        try {
            notifier.send(notification);
        } finally {
            notifier.close();
        }
    }
}
