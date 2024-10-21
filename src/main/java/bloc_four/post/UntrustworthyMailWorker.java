package bloc_four.post;

public class UntrustworthyMailWorker implements MailService {
    private final MailService[] mailServices;
    private final RealMailService realMailService = new RealMailService();

    public UntrustworthyMailWorker(MailService[] mailServices) {
        this.mailServices = mailServices;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        for (MailService services : mailServices) {
            mail = services.processMail(mail);
        }
        return realMailService.processMail(mail);
    }

    public RealMailService getRealMailService() {
        return realMailService;
    }
}
