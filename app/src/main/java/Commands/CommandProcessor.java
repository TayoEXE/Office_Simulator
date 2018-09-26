package Commands;
import Model.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import Utilities.*;

// Processes commands and alters the model accordingly
public class CommandProcessor {
    private Model _model;
    private String _command;
    private List<String> _elements;
    private CommandMap _map;

    public CommandProcessor() {
        _model = Model.instance();
        _command = "HELP";
        _elements = new ArrayList<String>();
        _map = new CommandMap();
    }

    public void processCommand(String command) {
        // Check if it's the end of the game.
        if (command.equals("endgame")) {
            _model.getInteractionObserver().endGame();
            return;
        }

        _command = standardizeString(command);
        splitCommand();

        // Get the elements of the command
        String verb = _elements.get(0);
        String object = _elements.get(1);

        if (verb.equals("GO") || verb.equals("MOVE")) {
            processMove();

        } else {
            // Determine what to perform the command on
            Interactable interactable = _model.getCurrentPlace().getInteractablesMap().get(object);

            if (interactable == null) {
                _model.getInteractionObserver().updateView("You forgot who or what that is.");
            } else {
                try {
                    _map.runCommand(verb, interactable);
                } catch (Exception e) {
                    _model.getInteractionObserver().updateView(e.getMessage());
                    Time.wait(3);
                }
            }

        }
    }

    private void splitCommand() {
        _elements = Arrays.asList(_command.split(" "));
    }

    private String standardizeString(String string) {
        string = string.toUpperCase();
        // TODO: Other stuff to standardize the string

        return string;
    }

    private void processMove() {
        // Check surrouding areas. If a valid place, change current place to there.
    }
}
