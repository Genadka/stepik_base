package bloc_four.post;

public class Inspector implements MailService {

    public static class IllegalPackageException extends RuntimeException {
    }

    public static class StolenPackageException extends RuntimeException {
    }

    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage) {
            MailPackage mailPackage = (MailPackage) mail;
            Package pkg = mailPackage.getContent();
            String content = pkg.getContent();

            if (WEAPONS.equals(content) || BANNED_SUBSTANCE.equals(content)) {
                throw new IllegalPackageException();
            } else if (content.contains("stones")) {
                throw new StolenPackageException();
            }
        }
        return mail;
    }
}
