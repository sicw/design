import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author sicwen
 * @date 2019/01/10
 */
public class PropertyChangeListenerImpl implements PropertyChangeListener {
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("属性名:" + evt.getPropertyName());
        System.out.println(evt.getOldValue() +" --> "+ evt.getNewValue());
    }
}
