package Presenters;
import java.io.IOException;
import Model.*;
import Views.IInteractionView;

public class InteractionPresenter implements Model.InteractionObserver {

    private Model _model;
    private IInteractionView _view;


    public InteractionPresenter(IInteractionView view) {
        _view = view;
        _model = Model.instance();
        _model.setInteractionObserver(this);
    }

    public String displayOpeningMessage() {
        return _model.getOpeningMessage();
    }

    public void setUser(String userName, String description) {
        _model.setUser(new Person(userName, description));
    }

    public void lookAround() {
        _model.lookAround();
    }

    public void initializeGame() {
        _model.setModelLoader(new ModelLoader());
        _model.initializeGame();
    }

    public void processCommand(String command) {
        _model.processCommand(command);
    }

    public void updateView(String message) {
        _view.print(message);
    }

    public String getUserInput(String prompt) {
        return _view.getUserInput(prompt);
    }

    public void endGame() {
        _view.setEnd(true);
    }
}
