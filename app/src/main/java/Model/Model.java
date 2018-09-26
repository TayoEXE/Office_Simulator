package Model;
import java.util.*;
import Commands.CommandProcessor;

public class Model {
    private static Model _instance;

    public static Model instance() {
        if (_instance == null) {
            _instance = new Model();
            _instance.setCommandProcessor(new CommandProcessor());
        }
        return _instance;
    }

    private Model() {
        _openingMessage = "Welcome to the Office Simulator.";

        _placesMap = new HashMap<String, Place>();
        _interactablesMap = new HashMap<String, Interactable>();

    }

    private CommandProcessor _processor; // Processes commands from the user.
    private Person _user;
    private Map<String, Interactable> _interactablesMap;
    private Map<String, Place> _placesMap;
    private Place _currentPlace;
    private ModelLoader _modelLoader;

    private String _openingMessage;

    private InteractionObserver _interactionObserver;

    public void initializeGame() {
        // Just for testing purposes --------------------
        _placesMap = _modelLoader.loadPlaces();
        _interactablesMap = _modelLoader.loadInteractablesMap();

        _currentPlace = _placesMap.get("OFFICE");
        // _currentPlace.setInteractablesMap(_interactablesMap);

        // ----------------------------------------------
    }

    public Person getUser() {
        return _user;
    }

    public void setUser(Person user) {
        _user = user;
        String profile = _user.getProfile();
    }

    private String getUserProfile() {
        return _user.getProfile();
    }

    public String getOpeningMessage() {
        return _openingMessage;
    }

    public Place getCurrentPlace() {
        return _currentPlace;
    }

    public void setCurrentPlace(String placeName) {
        // TODO: Later, make sure places has a surroundingPlaces variable. Have it check there instead.
        _currentPlace = _placesMap.get(placeName);
    }

    public void setCommandProcessor(CommandProcessor processor) {
        _processor = processor;
    }

    public void setModelLoader(ModelLoader modelLoader) {
        _modelLoader = modelLoader;
    }

    public InteractionObserver getInteractionObserver() {
        return _interactionObserver;
    }

    public void lookAround() {
        // This displays the current menu awaiting a command
        String lookAround = "---------------------------------------------------\n" +
                _currentPlace.getProfile() + "\n";
        lookAround += _currentPlace.getInteractablesMenu();
        lookAround += "---------------------------------------------------";
        _interactionObserver.updateView(lookAround);
    }

    public void processCommand(String command) {
        _processor.processCommand(command);
    }

    public void setInteractionObserver(InteractionObserver observer) {
        _interactionObserver = observer;
    }


    public interface InteractionObserver {
        public void updateView(String message);
        public String getUserInput(String prompt);
        public void endGame();
    }
}
