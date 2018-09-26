package Model;


class Yoko extends Person {

    public Yoko(String name, String description)  {
        super(name, description);
    }

    @Override
    public void punch() {
        _observer.updateView("You hear a voice: \"" + _user.getName() + ", that is a terrible idea.\"");
    }

    @Override
    public void hug() {
        _observer.updateView(_name + " hugs you back affectionately.");
    }

    @Override
    public void grab() {
        _observer.updateView("You take " + _name + " by the hand. She is now with you.");
    }

    @Override
    public void use() {
        _observer.updateView("You don't use " + _name + ", you love her.");
    }
}
