package com.example.algovise1.ui.home;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.algovise1.Algorithm;
import com.example.algovise1.R;
import com.example.algovise1.algorithms.LinearSearch;
import com.example.algovise1.databinding.FragmentVisualBinding;
import com.example.algovise1.visualiser.SearchVisualiser;
import com.google.android.material.textfield.TextInputEditText;

public class VisualFragment extends Fragment implements View.OnClickListener {

    private FragmentVisualBinding binding;
    View root;
    Paint paint = new Paint();
    RelativeLayout relativeLayout;
    LinearSearch algorithm;
    View view;
    String startCommand = Algorithm.COMMAND_START_ALGORITHM;
    public VisualFragment() { }
    public static VisualFragment newInstance(String algorithm) {
        VisualFragment fragment = new VisualFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Algorithm.KEY_ALGORITHM, algorithm);
        fragment.setArguments(bundle);
        return fragment;
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //HomeViewModel homeViewModel =
        //        new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentVisualBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        Button b = (Button) root.findViewById(R.id.btn_Play);
        b.setOnClickListener(this);
        relativeLayout = (RelativeLayout) root.findViewById(R.id.rect);
        relativeLayout.setVisibility(View.VISIBLE);
        view = new SearchVisualiser(getActivity());
        relativeLayout.addView(view);
        algorithm = new LinearSearch((SearchVisualiser) view, getActivity());
       // ((LinearSearch) algorithm).prepareHandler();
        return root;
    }

   /* @Override
    public void onClick(View view) {
        //view.setBackgroundColor(Color.GREEN);
        EditText txtEdit = (EditText) root.findViewById(R.id.text_input);
        Boolean found = searchArray(Integer.parseInt(txtEdit.getText().toString()));
        if(found==true)
            view.setBackgroundColor(Color.GREEN);
    }

    private class Rectangle extends View {
        public Rectangle(Context context) {
            super(context);
        }

        @Override
        public void onDraw(Canvas canvas) {
            int[] arr = {3,1,8,4,2,9};
            canvas = drawRectangles(canvas,arr);
            *//*canvas.drawLine(30,0,30+160,0,paint);
            paint.setColor(Color.BLACK);
            paint.setTextSize(50);
            canvas.drawText("4", 50, 30 , paint);*//*
            super.onDraw(canvas);
        }
        public Canvas drawRectangles(Canvas canvas, int[] arr){
            int x = 30;
            int y = 0, width = 160;
            int newWidth=0;
            Rect rect;
            Paint paint1 = new Paint();
            paint1.setColor(Color.BLACK);
            paint1.setTextSize(50);
            for(int i=0;i<arr.length;i++)
            {
                rect = new Rect(x+newWidth+10,150,newWidth+width+20,y);
                if(){

                }
                else {

                }
                canvas.drawRect(rect,paint);
                canvas.drawText(String.valueOf(arr[i]), rect.centerX()-20, rect.centerY()+20 , paint1);
                newWidth += x+width;
            }
            return canvas;
        }
    }*/
   public void setupFragment(String algorithmKey) {

       //viewPager.setOffscreenPageLimit(3);
       //bottomBar.selectTabAtPosition(0, false);
       //setupViewPager(viewPager);

       //codeFragment.setCode(algorithmKey);
       //algoFragment.setCodeDesc(algorithmKey);

       assert algorithmKey != null;

       //final AlgorithmVisualizer visualizer;

       /*appBarLayout.removeAllViewsInLayout();

       View toolbar = LayoutInflater.from(getActivity()).inflate(R.layout.toolbar, appBarLayout, false);
       appBarLayout.addView(toolbar);*/

       //((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) toolbar);
       ActionBar ab = ((AppCompatActivity) getActivity()).getSupportActionBar();
       assert ab != null;
       ab.setTitle("");
       ab.setDisplayHomeAsUpEnabled(true);
       ab.setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);
       //fab.setVisibility(View.VISIBLE);


       switch (algorithmKey) {
           /*case Algorithm.BINARY_SEARCH:
               visualizer = new SearchVisualiser(getActivity());
               //appBarLayout.addView(visualizer);
               algorithm = new BinarySearch((BinarySearchVisualizer) visualizer, getActivity(), logFragment);
               ((BinarySearch) algorithm).setData(DataUtils.createArray(15, true));
               break;*/
           case Algorithm.LINEAR_SEARCH:
               //visualizer = new SearchVisualiser(getActivity());
               //appBarLayout.addView(visualizer);
               algorithm = new LinearSearch((SearchVisualiser) view, getActivity());
               //((LinearSearch) algorithm).setData(DataUtils.createArray(15, false));
               break;
           /*case Algorithm.BUBBLE_SORT:
               visualizer = new SortingVisualizer(getActivity());
               appBarLayout.addView(visualizer);
               algorithm = new BubbleSort((SortingVisualizer) visualizer, getActivity(), logFragment);
               ((BubbleSort) algorithm).setData(DataUtils.createRandomArray(15));
               break;
           case Algorithm.INSERTION_SORT:
               visualizer = new SortingVisualizer(getActivity());
               appBarLayout.addView(visualizer);
               algorithm = new InsertionSort((SortingVisualizer) visualizer, getActivity(), logFragment);
               ((InsertionSort) algorithm).setData(DataUtils.createRandomArray(15));
               break;
           case Algorithm.SELECTION_SORT:
               visualizer = new SortingVisualizer(getActivity());
               appBarLayout.addView(visualizer);
               algorithm = new SelectionSort((SortingVisualizer) visualizer, getActivity(), logFragment);
               ((SelectionSort) algorithm).setData(DataUtils.createRandomArray(15));
               break;
           case Algorithm.QUICKSORT:
               visualizer = new SortingVisualizer(getActivity());
               appBarLayout.addView(visualizer);
               algorithm = new QuickSort((SortingVisualizer) visualizer, getActivity(), logFragment);
               ((QuickSort) algorithm).setData(DataUtils.createRandomArray(15));
               break;
           case Algorithm.BST_SEARCH:
               visualizer = new BSTVisualizer(getActivity());
               appBarLayout.addView(visualizer);
               algorithm = new BSTAlgorithm((BSTVisualizer) visualizer, getActivity(), logFragment);
               ((BSTAlgorithm) algorithm).setData(DataUtils.createBinaryTree());
               break;
           case Algorithm.BST_INSERT:
               visualizer = new BSTVisualizer(getActivity(), 280);
               ArrayVisualizer arrayVisualizer = new ArrayVisualizer(getActivity());
               appBarLayout.addView(visualizer);
               appBarLayout.addView(arrayVisualizer);
               algorithm = new BSTAlgorithm((BSTVisualizer) visualizer, getActivity(), logFragment);
               ((BSTAlgorithm) algorithm).setArrayVisualizer(arrayVisualizer);
               ((BSTAlgorithm) algorithm).setData(DataUtils.createBinaryTree());
               break;
           case Algorithm.LINKED_LIST:
               visualizer = new LinkedListVisualizer(getActivity());
               LinkedListControls controls = new LinkedListControls(getActivity(), bottomBar, fab);
               appBarLayout.addView(visualizer);
               appBarLayout.addView(controls);
               algorithm = new LinkedList((LinkedListVisualizer) visualizer, getActivity(), logFragment);
               ((LinkedList) algorithm).setData(DataUtils.createLinkedList());
               controls.setLinkedList((LinkedList) algorithm);
               break;
           case Algorithm.STACK:
               visualizer = new StackVisualizer(getActivity());
               StackControls stackcontrols = new StackControls(getActivity(), bottomBar, fab);
               appBarLayout.addView(visualizer);
               appBarLayout.addView(stackcontrols);
               algorithm = new Stack(5, (StackVisualizer) visualizer, getActivity(), logFragment);
               ((Stack) algorithm).setData(DataUtils.createStack());
               stackcontrols.setStack((Stack) algorithm);
               fab.setVisibility(View.GONE);
               break;
           */
           default:
               view = null;
       }

       /*Algorithm.setInterval(Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(getActivity())
               .getString(SettingsFragment.KEY_INTERVAL, "500")));
       algorithm.setStarted(false);
       fab.setImageResource(R.drawable.ic_play_arrow_white_24dp);
       logFragment.clearLog();*/

       /*algorithm.setCompletionListener(new AlgoCompletionListener() {
           @Override
           public void onAlgoCompleted() {
               fab.setImageResource(R.drawable.ic_settings_backup_restore_white_24dp);
               if (visualizer != null)
                   visualizer.onCompleted();

           }
       });*/

       /*fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (!algorithm.isStarted()) {
                   algorithm.sendMessage(startCommand);
                   fab.setImageResource(R.drawable.ic_pause_white_24dp);
                   logFragment.clearLog();
                   bottomBar.selectTabAtPosition(1, true);//move to log fragment
               } else {
                   if (algorithm.isPaused()) {
                       algorithm.setPaused(false);
                       fab.setImageResource(R.drawable.ic_pause_white_24dp);
                   } else {
                       algorithm.setPaused(true);
                       fab.setImageResource(R.drawable.ic_play_arrow_white_24dp);
                   }
               }
           }
       });*/

       /*View shadow = LayoutInflater.from(getActivity()).inflate(R.layout.shadow, appBarLayout, false);
       appBarLayout.addView(shadow);*/

   }

    public boolean searchArray(int key){
       int[] arr = {3,1,8,4,2,9};
       /*for(int i=0;i<arr.length;i++){
           paint.setColor(Color.GREEN);
       }*/
        paint.setColor(Color.GREEN);

       return false;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        //algorithm.sendMessage(startCommand);
        algorithm.search();
    }
}