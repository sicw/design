package com.xxx.design.listener.changeproperty;

import java.util.EventListener;

/**
 * 监听属性变化
 * @author sicwen
 * @date 2019/01/10
 */
public interface MyPropertyChangeListener extends EventListener {
    void propertyChange(MyPropertyChangeEvent event);
}