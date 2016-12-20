package kh.com.kshrd.hikvision.service.impl;

import kh.com.kshrd.hikvision.service.HikvisionService;

/**
 * Created by sophatvathana on 19/12/16.
 */
public class HikvisionServiceImpl implements HikvisionService{
    int i = 0;
    @Override
    public void hello(String name){
        i++;
        System.out.println("Hello World " + name + " : " + i);
    }
}
