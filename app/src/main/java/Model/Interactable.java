package Model;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Interactable {
    protected static int _numInteractables = 0;
    protected int _id;
    protected boolean _isVisible;
    protected String _name;
    protected String _description;
    protected String _profile;
    protected List<Interactable> _inventory;
    protected Model.InteractionObserver _observer;
    protected Person _user;

    public Interactable(String name, String description) {
        _isVisible = true;
        _name = name;
        _description = description;
        _profile = "None yet";
        _inventory = new ArrayList<Interactable>();
        _observer = Model.instance().getInteractionObserver();
        _user = Model.instance().getUser();
        updateProfile();
        _id = _numInteractables;
        _numInteractables++;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    private void updateProfile() {
        _profile = new String();
        _profile += "Name: " + _name + "\n" +
                "Description: " + _description;
    }

    public String getProfile() {
        return _profile;
    }



    public void punch() {
        _observer.updateView("You can't punch a " + _name);
    }

    public void hug() {
        _observer.updateView("You gave the " + _name + "a hug, but you got no response.");
    }

    public void grab() {
        _observer.updateView("You grabbed for the " + _name + ", but you were pushed back by an unknown force.");
    }

    public void use() {
        _observer.updateView("You try to use the " + _name + ", but it's a waste of time.");
    }
}
