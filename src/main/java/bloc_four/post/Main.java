package bloc_four.post;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        String from = "John Doe";
        String to = "Austin Powers";
        String messageContent = "Hello, how are you?";
        String dangerousContent = "weapons";
        String expensiveContent = "expensive watch";

        MailMessage simpleMessage = new MailMessage(from, to, messageContent);
        Package expensivePackage = new Package(expensiveContent, 1000);
        MailPackage mailPackage = new MailPackage(from, to, expensivePackage);

        Logger logger = Logger.getLogger(Main.class.getName());

        Spy spy = new Spy(logger);
        spy.processMail(simpleMessage);
        spy.processMail(new MailMessage(Spy.AUSTIN_POWERS, to, "Secret message"));

        Thief thief = new Thief(500);
        Sendable stolenPackage = thief.processMail(mailPackage);

        if (stolenPackage instanceof MailPackage) {
            MailPackage stolenMailPackage = (MailPackage) stolenPackage;
            System.out.println("Content after theft: " + stolenMailPackage.getContent().getContent());
        }
        System.out.println("Total stolen value: " + thief.getStolenValue());

        Inspector inspector = new Inspector();
        try {
            inspector.processMail(new MailPackage(from, to, new Package(dangerousContent, 300)));
        } catch (Inspector.IllegalPackageException e) {
            System.out.println("Inspector caught an illegal package!");
        }

        MailService[] services = {spy, thief, inspector};
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(services);
        Sendable finalMail = worker.processMail(mailPackage);
        System.out.println("Final mail after all services processed it: " + finalMail.getClass().getSimpleName());
    }
}
