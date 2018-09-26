package Utilities;
import java.util.concurrent.TimeUnit;
import Model.*;

public class Time {
    private static Model _model = Model.instance();

    public static void wait(int seconds)  {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException ex) {
            if (_model.getInteractionObserver() != null) {
                _model.getInteractionObserver().updateView(ex.getMessage());
            }
        }
    }
}
