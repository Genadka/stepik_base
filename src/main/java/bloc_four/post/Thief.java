package bloc_four.post;

public class Thief implements MailService {
    private final int minPrice;
    private int stolenValue;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            Package pkg = mailPackage.getContent();
            if (pkg.getPrice() >= minPrice) {
                stolenValue += pkg.getPrice();
                Package fakePackage = new Package("stones instead of " + pkg.getContent(), 0);
                return new MailPackage(mailPackage.getFrom(), mailPackage.getTo(), fakePackage);
            }
        }
        return mail;
    }
}
