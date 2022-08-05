package com.example.algovise1;

import android.content.Intent;
import android.os.Bundle;

import com.example.algovise1.ui.home.VisualFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.algovise1.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import android.graphics.Canvas;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DrawerLayout mDrawerLayout;
    ExpandableListAdapter mMenuAdapter;
    ExpandableListView expandableList;
    List<ExpandedMenuModel> listDataHeader;
    HashMap<ExpandedMenuModel, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Navigation Drawer with expandable lists for various algorithms
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        expandableList = (ExpandableListView) findViewById(R.id.navigation_menu);
        NavigationView navigationView = (NavigationView) findViewById(R.id.sideNav_view);
        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }
        final VisualFragment algoFragment = VisualFragment.newInstance(Algorithm.LINEAR_SEARCH);
        //getSupportFragmentManager().beginTransaction().replace(R.id.container, algoFragment).commit();
        prepareListData();
        mMenuAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, expandableList);

        expandableList.setAdapter(mMenuAdapter);

        expandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                switch (groupPosition) {
                    case 0:
                        switch (childPosition) {
                            case 0:
                                algoFragment.setupFragment(Algorithm.BINARY_SEARCH);
                                break;
                            case 1:
                                algoFragment.setupFragment(Algorithm.LINEAR_SEARCH);
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition) {
                            case 0:
                                algoFragment.setupFragment(Algorithm.BUBBLE_SORT);
                                break;
                            case 1:
                                algoFragment.setupFragment(Algorithm.INSERTION_SORT);
                                break;
                            case 2:
                                algoFragment.setupFragment(Algorithm.SELECTION_SORT);
                                break;
                            case 3:
                                algoFragment.setupFragment(Algorithm.QUICKSORT);
                                break;
                        }
                        break;
                    /*case 2:
                        switch (childPosition) {
                            case 0:
                                algoFragment.setStartCommand(BSTAlgorithm.START_BST_SEARCH);
                                algoFragment.setupFragment(Algorithm.BST_SEARCH);
                                break;
                            case 1:
                                algoFragment.setStartCommand(BSTAlgorithm.START_BST_INSERT);
                                algoFragment.setupFragment(Algorithm.BST_INSERT);
                                break;
                        }
                        break;*/
                    case 3:
                        switch (childPosition) {
                            case 0:
                                algoFragment.setupFragment(Algorithm.LINKED_LIST);
                                break;
                            case 1:
                                algoFragment.setupFragment(Algorithm.STACK);
                                break;
                        }
                        break;

                    /*case 6:
                        switch (childPosition) {
                            case 0:
                                mDrawerLayout.closeDrawers();
                                Handler handler = new Handler();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //Helpers.showAbout(MainActivity.this);
                                    }
                                }, 350);
                                break;
                            case 1:
                                Intent intent = new Intent(Intent.ACTION_VIEW);
                                Uri data = Uri.parse("https://github.com/naman14/AlgorithmVisualizer-Android");
                                intent.setData(data);
                                startActivity(intent);
                                break;
                            case 2:
                                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                                break;
                            case 3:
                                startActivity(new Intent(MainActivity.this, DonateActivity.class));
                                break;
                        }
                        break;*/

                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });
        expandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        //Bottom navigation for fragments
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<ExpandedMenuModel>();
        listDataChild = new HashMap<ExpandedMenuModel, List<String>>();

        ExpandedMenuModel item1 = new ExpandedMenuModel();
        item1.setName("Search");
        listDataHeader.add(item1);

        ExpandedMenuModel item2 = new ExpandedMenuModel();
        item2.setName("Sorting");
        listDataHeader.add(item2);

        ExpandedMenuModel item3 = new ExpandedMenuModel();
        item3.setName("Tree");
        listDataHeader.add(item3);

        ExpandedMenuModel item4 = new ExpandedMenuModel();
        item4.setName("List");
        listDataHeader.add(item4);

        /*ExpandedMenuModel item5 = new ExpandedMenuModel();
        item5.setName("Graph");
        listDataHeader.add(item5);*/

        /*ExpandedMenuModel item6 = new ExpandedMenuModel();
        item6.setName("Backtracking");
        listDataHeader.add(item6);*/

        ExpandedMenuModel item10 = new ExpandedMenuModel();
        item10.setName("About");
        listDataHeader.add(item10);

        List<String> heading1 = new ArrayList<>();
        heading1.add("Binary search");
        heading1.add("Linear Search");

        List<String> heading2 = new ArrayList<String>();
        heading2.add("Bubble Sort");
        heading2.add("Insertion Sort");
        heading2.add("Selection Sort");
        heading2.add("Quicksort");
        List<String> heading3 = new ArrayList<String>();
        heading3.add("BST Search");
        heading3.add("BST Insert");

        List<String> heading4 = new ArrayList<String>();
        heading4.add("Linked List");
        heading4.add("Stack");

        /*List<String> heading5 = new ArrayList<String>();
        heading5.add("BFS Traversal");
        heading5.add("DFS Travsersal");
        heading5.add("Dijkstra");
        heading5.add("Bellman Ford");

        List<String> heading6 = new ArrayList<String>();
        heading6.add("N Queens Problem");*/

        List<String> heading10 = new ArrayList<String>();
        heading10.add("About");
        heading10.add("Settings");

        listDataChild.put(listDataHeader.get(0), heading1);
        listDataChild.put(listDataHeader.get(1), heading2);
        listDataChild.put(listDataHeader.get(2), heading3);
        listDataChild.put(listDataHeader.get(3), heading4);
        listDataChild.put(listDataHeader.get(4), heading10);

    }
}