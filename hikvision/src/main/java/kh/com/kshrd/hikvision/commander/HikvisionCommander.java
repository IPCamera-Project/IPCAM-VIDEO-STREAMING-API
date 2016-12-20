package kh.com.kshrd.hikvision.commander;

import kh.com.kshrd.hikvision.service.HikvisionService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sophatvathana on 19/12/16.
 */
public class HikvisionCommander {
    private final HikvisionService service;
    private String name;
    //private final Timer timer;

    public HikvisionCommander(HikvisionService service, String name) {
        super();

        this.service = service;
        this.name = name;

       // timer = new Timer(1000, this);
    }

    public void setName(){
        service.hello(name);
    }
//    public void startTimer() {
//        timer.start();
//    }

//    public void stopTimer() {
//        timer.stop();
//    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        service.hello(name);
//    }
}