package com.xxx.design.listener;

import com.xxx.design.listener.chageproperty.People;
import com.xxx.design.listener.chageproperty.People2;
import com.xxx.design.listener.changeproperty.PropertyChangeListenerImpl;
import com.xxx.design.listener.vetoablechage.People3;
import com.xxx.design.listener.vetobechage.VetoableChangeListenerImpl;
import org.junit.Test;

import java.beans.PropertyVetoException;

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

    /**
     * 组织修改属性,会报异常.
     * @throws PropertyVetoException
     */
    @Test
    public void testVetoableChangeSupport() throws PropertyVetoException {
        People3 p = new People3();
        p.addPropertyListener(new VetoableChangeListenerImpl());
        p.setAge(18);
        p.setHeight(180);
        p.setName("小明");
        p.setWeight(60);
    }
}