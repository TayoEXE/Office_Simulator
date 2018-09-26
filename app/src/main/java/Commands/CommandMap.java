package Commands;
import java.util.*;
import java.util.concurrent.TimeUnit;
import Model.*;
import Utilities.*;


public class CommandMap {
    private Map<String, Command> _commandMap;
    private Interactable _currentInteractable;
    private Place _currentPlace;

    public CommandMap() {
        _currentInteractable = new Interactable("No Name","No Description");
        _commandMap = new HashMap<String, Command>();

        // TODO: Replace later with a function that gathers commands from a JSON file.
        loadCommands();
    }

    public void runCommand(String command, Interactable interactable) throws Exception {
        _currentInteractable = interactable;
        loadCommands();

        if (_commandMap.containsKey(command)) {
            try {
                _commandMap.get(command).run();
            } catch (Exception e) {
                throw new Exception(e.getClass().getName());
            }

            Time.wait(3);
        } else {
            throw new Exception("You forgot what you were doing.");
        }
    }

    private void loadCommands() {
        _commandMap.put("PUNCH", () -> _currentInteractable.punch());
        _commandMap.put("STRIKE", () -> _currentInteractable.punch());
        _commandMap.put("SLUG", () -> _currentInteractable.punch());
        _commandMap.put("HUG", () -> _currentInteractable.hug());
        _commandMap.put("GRAB", () -> _currentInteractable.grab());
        _commandMap.put("TAKE", () -> _currentInteractable.grab());
        _commandMap.put("HOLD", () -> _currentInteractable.grab());
        _commandMap.put("GET", () -> _currentInteractable.grab());
        _commandMap.put("USE", () -> _currentInteractable.use());
        _commandMap.put("MANIPULATE", () -> _currentInteractable.use());
    }
}