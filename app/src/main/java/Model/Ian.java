package Model;

class Ian extends Person {

    public Ian(String name, String description)  {
        super(name, description);
    }

    @Override
    public void punch() {
        _observer.updateView("\"Dude, what the heck was that for?\" " + _name + " punches you back.");
    }

    @Override
    public void hug() {
        _observer.updateView("\"Well, that's kind of random.\" " + _name + " gives you a bro hug.");
    }

    @Override
    public void grab() {
        _observer.updateView(_name + " is now with you.");
    }

    @Override
    public void use() {
        _observer.updateView("... How do you use an " + _name + "?");
    }
}
