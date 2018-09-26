import java.util.*;
import Model.Person;
import Views.InteractionView;
import java.lang.*;

class Simulator {
    public static void main(String[] args) {
        InteractionView view = new InteractionView();
        boolean test = false;

        view.gameCycle();
    }
}


/* TODO:

- Make Thing and Person both inherit Noun for polymorphism. [DONE]
- Change the Model's list of people, things, locations, etc. to maps. [DONE]
- Implement some kind of processor to determine what kind of commands are coming in.
- Make it so that by default, only the description of the place comes up, but the user can command "Look" to see the objects.
*/


/* HOW TO
1. Add new commands:
First, add a new method in Interactable.java, and then override the
children classes (Thing and Person, etc.) with the same method if you
want a different reaction based on the type of object. Then, add command
words that will activate those methods. These can be one or even multiple
synonyms. Add them in the loadCommands() of CommandMap.java.


*/