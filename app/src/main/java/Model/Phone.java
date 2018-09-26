package Model;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import Utilities.*;

class Phone extends Thing {

    public Phone(String name, String description) {
        super(name, description);
    }

    @Override
    public void punch() {
        _observer.updateView("You punched a " + _name + ". Way to go.");
    }

    @Override
    public void use() {
        usePhone();
    }

    private void usePhone() {
        _observer.updateView("You can make a phone call.");
        Time.wait(1);
        _observer.updateView("Who do you want to call?");
        dialPhone();
    }

    private void dialPhone() {
        Random rand = new Random();
        int numRings = rand.nextInt(4) + 1;
        String phoneNumber = _observer.getUserInput("Dial a number (format = last four digits inside the office): ");
        for (int i = 0; i < numRings; i++) {
            Time.wait(2);
            _observer.updateView("Ringing...");
        }
        Time.wait(2);
        _observer.updateView("\"Hello, this is Ian.\"");
    }
}
