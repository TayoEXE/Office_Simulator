package Views;
import java.io.IOException;
import Presenters.InteractionPresenter;
import Utilities.InputHandler;

public class InteractionView implements IInteractionView {

    private InteractionPresenter _presenter;
    private String _userName;
    private String _userDescription;
    private boolean _isEnd;

    public InteractionView() {
        _presenter = new InteractionPresenter(this);
        _userName = "Default";
        _userDescription = "Default";
        _isEnd = false;
    }


    public void gameCycle() {
        displayOpeningMessage();
        setUser();
        _presenter.initializeGame();

        do {
            _presenter.lookAround();
            String userCommand = "HELP";
            userCommand = getUserInput("Command: ");

            _presenter.processCommand(userCommand);

        } while (_isEnd == false);

        print("Goodbye");
        cleanUpInputStream();
    }

    public void displayOpeningMessage() {
        print(_presenter.displayOpeningMessage());
    }

    public void setUser() {
        try {
            _userName = Utilities.InputHandler.getAlphaNumeric("Please enter your name: ");
            _userDescription = Utilities.InputHandler.getAlphaNumeric("Please describe your physical appearance: ");
            _presenter.setUser(_userName, _userDescription);
        } catch (IOException e) {
            print(e.getMessage());
        }

    }

    public void print(String string) {
        System.out.println(string + "\n");
    }

    public String getUserInput(String prompt) {
        String userInput = "Could not get user input";
        try {
            userInput = Utilities.InputHandler.getAlphaNumeric(prompt);
        } catch (IOException e) {
            return "Input error: " + e.getMessage();
        }
        return userInput;
    }

    public void setEnd(boolean isEnd) {
        _isEnd = isEnd;
    }

    public void cleanUpInputStream() {
        try {
            InputHandler.cleanUp();
        } catch (IOException e) {
            print("Error: Could not close input stream - " + e.getMessage());
        }
    }
}
