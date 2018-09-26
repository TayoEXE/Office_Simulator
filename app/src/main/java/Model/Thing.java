package Model;
import java.util.*;

public class Thing extends Interactable {

    public Thing(String name, String description) {
        super(name, description);
    }

    @Override
    public void punch() {
        _observer.updateView("You punched the " + _name + ". Ow.");
    }

    @Override
    public void hug() {
        _observer.updateView("You hugged the " + _name + " for some reason.");
    }

    @Override
    public void grab() {
        _observer.updateView("You got the " + _name);
    }

    @Override
    public void use() {
        _observer.updateView("You couldn't figure out how to use the " + _name + ".");
    }
}
