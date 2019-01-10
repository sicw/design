import org.junit.Test;

import java.beans.PropertyChangeListener;

/**
 * @author sicwen
 * @date 2019/01/10
 */
public class ListenerTest {
    @Test
    public void testProtertyChangeListener() {
        People p = new People();
        p.setAge(18);
        p.setHeight(180);
        p.setName("小明");
        p.setWeight(60);
    }

    @Test
    public void testPropertyChangeSupport() {
        People2 p = new People2();
        p.addPropertyListener(new PropertyChangeListenerImpl());
        p.addPropertyListener("age", new PropertyChangeListenerImpl());
        p.setAge(18);
        p.setHeight(180);
        p.setName("小明");
        p.setWeight(60);
    }

}