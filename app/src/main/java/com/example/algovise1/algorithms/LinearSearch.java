package com.example.algovise1.algorithms;

import android.app.Activity;

import com.example.algovise1.Algorithm;
import com.example.algovise1.DataHandler;
import com.example.algovise1.visualiser.SearchVisualiser;

import java.util.ArrayList;
import java.util.List;

public class LinearSearch extends Algorithm implements DataHandler {
    private SearchVisualiser visualiser;
    private int[] array;
    //private Thread td;
    private List<Integer> positions = new ArrayList<>();

    public LinearSearch(SearchVisualiser visualiser, Activity activity){
        this.visualiser = visualiser;
        this.activity = activity;
    }

    public void search() {
        int[] arr = {3,1,8,4,2,9};
        //int rnd = new Random().nextInt(array.length);
        int data = 4;

        int len = arr.length ;

        for (int i = 0 ; i<len ; i++) {

            highlight(0, i-1);
            highlightTrace(i);
            //addLog("Searching at index - " + i);

            if (arr[i] == data){
                //addLog("Result - True");
                //addLog("Value found at position - " + i);
                break;
            }
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            sleep();
        }
    }
    private void highlight(int minIndex, int maxIndex) {
        positions.clear();
        for (int i = minIndex; i <= maxIndex; i++) {
            positions.add(i);
        }

        //activity.runOnUiThread(new Runnable() {
            //@Override
            //public void run() {
                visualiser.highlight(positions);
            //}
        //});
    }
    private void highlightTrace(final int pos) {
        //activity.runOnUiThread(new Runnable() {
            //@Override
            //public void run() {
                visualiser.highlightTrace(pos);
            //}
        //});
    }

    @Override
    public void onDataRecieved(Object data) {
        this.array = (int[]) data;
    }

    @Override
    public void onMessageReceived(String message) {
        if (message.equals(Algorithm.COMMAND_START_ALGORITHM)) {
            startExecution();
            search();
        }
    }

    public void prepareHandler() {
        prepareHandler(this);
    }
}
