package Model;
import java.util.*;

// Later, add interactables and places through JSON instead of manually.
public class ModelLoader {
    private Map<String, Interactable> _interactablesMap;
    private Map<String, Place> _placesMap;

    public ModelLoader() {
        _interactablesMap = new HashMap<String, Interactable>();
        _placesMap = new HashMap<String, Place>();

        setInteractablesMap();
        setPlaces();
    }

    private void setInteractablesMap() {
        // _interactablesMap.put("", new Person("", ""));
        _interactablesMap.put("JENNA", new Person("JENNA", "Your coworker. A woman who helps you out in the IT department."));
        _interactablesMap.put("DESK", new Thing("DESK", "Your working area. It has a laptop with two monitors on top of it."));
        _interactablesMap.put("PHONE", new Phone("PHONE", "Your work phone. You can call people inside or outside the office."));
        _interactablesMap.put("COMPUTER", new Thing("COMPUTER", "Your work computer. It's a laptop with two large monitors."));
        _interactablesMap.put("READER", new Thing("READER", "A card reader. You can put in a PIV to log into a computer."));
        _interactablesMap.put("LEPRECHAUN", new Person("LEPRECHAUN", "A little Irishman. He's got a pot of gold somewhere and wears all green."));
        _interactablesMap.put("YOKO", new Yoko("YOKO", "Your beloved wife. She speaks Japanese and is very affectionate."));
        _interactablesMap.put("PIV", new Thing("PIV", "Your Personal Identification card. Use it to log into your computer or open doors."));
        _interactablesMap.put("IAN", new Ian("IAN", "Your brother. A tall guy with brown hair and a soccer jersey."));
        _interactablesMap.put("SINK", new Thing("SINK", "A sink. You can wash your hands here."));
        _interactablesMap.put("MIRROR", new Thing("MIRROR", "A large mirror. VIEW it to see your reflection."));
        _interactablesMap.put("TOILET", new Thing("TOILET", "A bathroom stall. You can USE the toilet if you need to."));
    }

    public Map<String, Interactable> loadInteractablesMap() {
        return _interactablesMap;
    }

    private void setPlaces() {
        _placesMap.put("OFFICE", new Place("OFFICE", "Your office area. A small room with two desks and computers."));
        _placesMap.get("OFFICE").setInteractablesMap(createInteractablesMap("OFFICE", "JENNA", "DESK", "PHONE",
                "COMPUTER", "READER", "PIV"));

        _placesMap.put("BATHROOM", new Place("BATHROOM", "The bathroom. It's got a sink, mirror, toilets."));
        _placesMap.get("BATHROOM").setInteractablesMap(createInteractablesMap("BATHROOM", "IAN", "LEPRACHAUN", "SINK",
                "MIRROR","TOILET"));
    }

    public Map<String, Place> loadPlaces() {
        return _placesMap;
    }

    private Map<String, Interactable> createInteractablesMap(String placeName, String... interactables) {
        Map<String, Interactable> newMap = new HashMap<String, Interactable>();

        for (String interactableName : interactables) {
            try {
                newMap.put(interactableName, _interactablesMap.get(interactableName));
            } catch (Exception e) {
                System.out.println("Error in createInteractablesMap(): " + e.getMessage());
            }
        }

        return newMap;
    }
}
