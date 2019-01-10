package com.xxx.design.listener.chageproperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * 在属性变化时, 触发监听器.
 * 这里只是实现简单的监听器, 还可以实现 监听不同属性, 事件传播等功能.
 * JDK中为我们做了一个help class.PropertyChangeSupport, 该类实现了创建Listener,添加Listener,监听不同属性,事件传播等功能.
 * @author sicwen
 * @date 2019/01/10
 */
public class People2 {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private String name;
    private int age;
    private int weight;
    private int height;

    public void addPropertyListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }

    public void addPropertyListener(String propertyName,PropertyChangeListener listener){
        pcs.addPropertyChangeListener(propertyName, listener);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Object oldValue = this.name;
        this.name = name;
        pcs.firePropertyChange(new PropertyChangeEvent(this,"name",name,oldValue));
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        Object oldValue = this.age;
        this.age = age;
        pcs.firePropertyChange(new PropertyChangeEvent(this,"age",age,oldValue));
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        Object oldValue = this.weight;
        this.weight = weight;
        pcs.firePropertyChange(new PropertyChangeEvent(this,"weight",age,oldValue));
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        Object oldValue = this.height;
        this.height = height;
        pcs.firePropertyChange(new PropertyChangeEvent(this,"height",height,oldValue));
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
