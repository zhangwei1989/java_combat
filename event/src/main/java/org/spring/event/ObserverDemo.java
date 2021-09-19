package org.spring.event;

import java.util.Observable;
import java.util.Observer;

/**
 * {@link Observer}
 * @ClassName ObserverDemo
 * @Description TODO
 * @Author zhangwei
 * @Date 2021-08-21 14:10
 * @Version 1.0
 */
public class ObserverDemo {

    public static void main(String[] args) {
        Observable observable = new EventObservable() ;
        observable.addObserver(new EventObserver());

        observable.notifyObservers("Hello World!");
    }

    static class EventObserver implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            System.out.println("收到事件： " + arg);
        }
    }

    static class EventObservable extends Observable {

        @Override
        public void setChanged() {
            super.setChanged();
        }

        @Override
        public void notifyObservers(Object arg) {
            setChanged();
            super.notifyObservers(arg);
            clearChanged();
        }
    }
}
