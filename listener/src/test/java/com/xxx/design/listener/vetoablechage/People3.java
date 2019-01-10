package com.xxx.design.listener.vetoablechage;

import java.beans.*;

/**
 * 在属性变化时, 触发监听器.
 * 这里只是实现简单的监听器, 还可以实现 监听不同属性, 事件传播等功能.
 * JDK中为我们做了一个help class.PropertyChangeSupport, 该类实现了创建Listener,添加Listener,监听不同属性,事件传播等功能.
 * @author sicwen
 * @date 2019/01/10
 */
public class People3 {

    private final VetoableChangeSupport vcs = new VetoableChangeSupport(this);
    
    private String name;
    private int age;
    private int weight;
    private int height;

    public void addPropertyListener(VetoableChangeListener listener){
        vcs.addVetoableChangeListener(listener);
    }

    public void addPropertyListener(String propertyName,VetoableChangeListener listener){
        vcs.addVetoableChangeListener(propertyName, listener);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws PropertyVetoException {
        Object oldValue = this.name;
        this.name = name;
        vcs.fireVetoableChange(new PropertyChangeEvent(this,"name",name,oldValue));
    }

    public int getAge() {
        return age;
    }

    /**
     * 拒绝修改属性值的操作 一定要在实际修改操作之前.
     * @param age
     * @throws PropertyVetoException
     */
    public void setAge(int age) throws PropertyVetoException {
        Object oldValue = this.age;
        vcs.fireVetoableChange(new PropertyChangeEvent(this,"age",age,oldValue));
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws PropertyVetoException {
        Object oldValue = this.weight;
        vcs.fireVetoableChange(new PropertyChangeEvent(this,"weight",age,oldValue));
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws PropertyVetoException {
        Object oldValue = this.height;
        vcs.fireVetoableChange(new PropertyChangeEvent(this,"height",height,oldValue));
        this.height = height;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }
}
