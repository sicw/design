package com.xxx.design.listener.chageproperty;

import com.xxx.design.listener.changeproperty.MyPropertyChangeEvent;
import com.xxx.design.listener.changeproperty.MyPropertyChangeListener;
import com.xxx.design.listener.changeproperty.MyPropertyChangeListenerImpl;

/**
 * 在属性变化时, 触发监听器.
 * 这里只是实现简单的监听器, 还可以实现 监听不同属性, 事件传播等功能.
 * JDK中为我们做了一个help class.PropertyChangeSupport, 该类实现了创建Listener,添加Listener,监听不同属性,事件传播等功能.
 * @author sicwen
 * @date 2019/01/10
 */
public class People {

    private MyPropertyChangeListener listener = new MyPropertyChangeListenerImpl();

    private String name;
    private int age;
    private int weight;
    private int height;

    public void addPropertyListener(MyPropertyChangeListener listener){
        this.listener = listener;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Object oldValue = this.name;
        this.name = name;
        listener.propertyChange(new MyPropertyChangeEvent(this,"name",name,oldValue));
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        Object oldValue = this.age;
        this.age = age;
        listener.propertyChange(new MyPropertyChangeEvent(this,"age",age,oldValue));
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        Object oldValue = this.weight;
        this.weight = weight;
        listener.propertyChange(new MyPropertyChangeEvent(this,"weight",weight,oldValue));
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        Object oldValue = this.height;
        this.height = height;
        listener.propertyChange(new MyPropertyChangeEvent(this,"height",height,oldValue));
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
