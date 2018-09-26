package Views;


public interface IInteractionView {
    public void gameCycle();
    public void displayOpeningMessage();
    public void setUser();
    public void print(String string);
    public String getUserInput(String prompt);
    public void setEnd(boolean isEnd);
    public void cleanUpInputStream();
}
