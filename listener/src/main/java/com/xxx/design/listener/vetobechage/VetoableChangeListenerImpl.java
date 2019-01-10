package com.xxx.design.listener.vetobechage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

/**
 * @author sicwen
 * @date 2019/01/10
 */
public class VetoableChangeListenerImpl implements VetoableChangeListener {
    @Override
    public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        throw new PropertyVetoException("Invalid change",evt);
    }
}
