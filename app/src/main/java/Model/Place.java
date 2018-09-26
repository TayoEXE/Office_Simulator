package Model;
import java.util.*;
import Model.*;

public class Place {

    private static int _numPlaces = 0;
    private int _id;
    private String _name;
    private String _description;
    private String _profile;
    private Map<String, Interactable> _interactablesMap;
    private Map<String, Person> _peopleMap;
    private Map<String, Thing> _thingsMap;

    public Place(String name, String description) {
        _name = name;
        _description = description;
        _profile = "Not yet";
        _interactablesMap = new HashMap<String, Interactable>();
        _peopleMap = new HashMap<String, Person>();
        _thingsMap = new HashMap<String, Thing>();
        updateProfile();
        _id = _numPlaces;
        _numPlaces++;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
        updateProfile();
    }

    private void updateProfile() {
        _profile = new String();
        _profile += "Location: " + _name + "\n" +
                "Description: " + _description;
    }

    public String getProfile() {
        return _profile;
    }

    public Map<String, Person> getPeopleMap() {
        return _peopleMap;
    }

    private void setPeopleMap() {
        for (Map.Entry<String, Interactable> entry : _interactablesMap.entrySet()) {
            if (entry.getValue() instanceof Person) {
                _peopleMap.put(entry.getKey(), (Person) entry.getValue());
            }
        }
    }

    public Map<String, Thing> getThingsMap() {
        return _thingsMap;
    }

    private void setThingsMap() {
        for (Map.Entry<String, Interactable> entry : _interactablesMap.entrySet()) {
            if (entry.getValue() instanceof Thing) {
                _thingsMap.put(entry.getKey(), (Thing) entry.getValue());
            }
        }
    }

    public void setInteractablesMap(Map<String, Interactable> interactablesMap) {
        _interactablesMap = interactablesMap;
        setPeopleMap();
        setThingsMap();
    }

    public Map<String, Interactable> getInteractablesMap() {
        return _interactablesMap;
    }
    public String getInteractablesMenu() {
        String objects = "";
        int objectNum = 0;
        for (Map.Entry<String, Person> entry : _peopleMap.entrySet()) {
            objectNum++;
            objects += objectNum + ". " + entry.getValue().getName() + ": " + entry.getValue().getDescription() + "\n";
        }

        for (Map.Entry<String, Thing> entry : _thingsMap.entrySet()) {
            objectNum++;
            objects += objectNum + ". " + entry.getValue().getName() + ": " + entry.getValue().getDescription() + "\n";
        }

        return objects;
    }
}
