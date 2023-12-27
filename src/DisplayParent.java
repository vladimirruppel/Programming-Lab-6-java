public class DisplayParent<T extends DisplayItem> {
    public void Display(T object) {
        object.Display();
    }
}
