package name.snavrotskiy.ant.listener;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;

import java.net.URL;

/**
 * This code is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY.
 * <p>
 * Notification parameters
 */
class NotificationParams {
    /**
     * Tray icon.
     */
    private final URL icon;
    /**
     * Notification title.
     */
    private final String title;
    /**
     * Notification message.
     */
    private final String message;

    /**
     * Default constructor. All parameters have to be non-null
     *
     * @param trayIcon            tray icon
     * @param notificationTitle   notification title
     * @param notificationMessage notification message
     */
    NotificationParams(@NotNull final URL trayIcon, @NotNull final String notificationTitle, @NotNull final String notificationMessage) {
        Preconditions.checkNotNull(trayIcon);
        Preconditions.checkNotNull(notificationTitle);
        Preconditions.checkNotNull(notificationMessage);

        icon = trayIcon;
        title = notificationTitle;
        message = notificationMessage;
    }

    /**
     * Get uri for tray icon.
     *
     * @return uri
     */
    URL getIcon() {
        return icon;
    }

    /**
     * Get notification title.
     *
     * @return title
     */
    String getTitle() {
        return title;
    }

    /**
     * Get notification message.
     *
     * @return message
     */
    String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "NotificationParams{"
                + "icon=" + icon
                + ", title='" + title + '\''
                + ", message='" + message + '\''
                + '}';
    }
}
