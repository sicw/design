/**
 * @author sicwen
 * @date 2019/01/10
 */
public class MyPropertyChangeListenerImpl implements MyPropertyChangeListener {
    @Override
    public void propertyChange(MyPropertyChangeEvent event) {
        System.out.println("属性名:" + event.getPropertyName());
        System.out.println(event.getOldValue() +" --> "+ event.getNewValue());
    }
}