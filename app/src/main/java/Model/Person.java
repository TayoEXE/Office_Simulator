package Model;
import java.util.*;

public class Person extends Interactable {

    public Person(String name, String description) {
        super(name, description);
    }

    @Override
    public void punch() {
        _observer.updateView("You punched " + _name + ". They got angry.");
    }

    @Override
    public void hug() {
        _observer.updateView(_name + " gives you a weird look.");
    }

    @Override
    public void grab() {
        _observer.updateView("You reach out, but " + _name + " slaps your hand away.");
    }

    @Override
    public void use() {
        _observer.updateView("You try to use " + _name + " but they didn't come with instructions.");

    }
}
