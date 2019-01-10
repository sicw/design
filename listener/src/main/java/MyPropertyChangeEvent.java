import java.util.EventObject;

/**
 * 触发事件时，发送的事件对象.
 * @author sicwen
 * @date 2019/01/10
 */
public class MyPropertyChangeEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred. 触发事件的那个对象(事件源)
     * @throws IllegalArgumentException if source is null.
     */
    public MyPropertyChangeEvent(Object source, String propertyName, Object newValue, Object oldValue) {
        super(source);
        this.propertyName = propertyName;
        this.newValue = newValue;
        this.oldValue = oldValue;
    }

    /**
     * 属性名字
     */
    private String propertyName;

    /**
     * 新的属性值
     */
    private Object newValue;

    /**
     * 旧的属性值
     */
    private Object oldValue;

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Object getNewValue() {
        return newValue;
    }

    public Object getOldValue() {
        return oldValue;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
