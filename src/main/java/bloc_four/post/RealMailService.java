package bloc_four.post;

public class RealMailService implements MailService {

    @Override
    public Sendable processMail(Sendable mail) {
        return mail;
    }
}