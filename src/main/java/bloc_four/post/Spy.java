package bloc_four.post;
import java.util.logging.*;

public class Spy implements MailService {
    private final Logger logger;
    public static final String AUSTIN_POWERS = "Austin Powers";

    public Spy(Logger logger) {
        this.logger = logger;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailMessage) {
            MailMessage message = (MailMessage) mail;
            String from = message.getFrom();
            String to = message.getTo();
            if (AUSTIN_POWERS.equals(from) || AUSTIN_POWERS.equals(to)) {
                logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                        new Object[]{from, to, message.getMessage()});
            } else {
                logger.log(Level.INFO, "Usual correspondence: from {0} to {1}", new Object[]{from, to});
            }
        }
        return mail;
    }
}
