package com.goodyun.fex01materialdesign;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle drawerToggle;
    TabLayout tabLayout;
    ViewPager pager;
    MyAdapter adapter;
    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //navigationview만들기
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.layout_drawer);
        navigationView = findViewById(R.id.nav);
        navigationView.setItemIconTintList(null);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);

        drawerToggle.syncState();

        //tab만들기

        tabLayout = findViewById(R.id.layout_tab);
//        TabLayout.Tab tab = null;
//        tab = tabLayout.newTab().setTag("tab1").setText("Home").setIcon(R.mipmap.ic_launcher);
//        tabLayout.addTab(tab);
//
//        tab = tabLayout.newTab().setTag("tab2").setText("Theme").setIcon(R.mipmap.ic_launcher);
//        tabLayout.addTab(tab);
//
//        tab = tabLayout.newTab().setTag("tab3").setText("Talk").setIcon(R.mipmap.ic_launcher);
//        tabLayout.addTab(tab);

        pager = findViewById(R.id.pager);
        adapter = new MyAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        tabLayout.setupWithViewPager(pager);
        getSupportActionBar().setTitle("집");


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getText().equals("Home")) {
                    getSupportActionBar().setTitle("집");
                } else if (tab.getText().equals("Theme")) {
                    getSupportActionBar().setTitle("테마");
                } else if (tab.getText().equals("Talk")) {
                    getSupportActionBar().setTitle("토크");
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }//onCreate

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_main, menu);

        MenuItem item = menu.findItem(R.id.menu_search);
        sv = (SearchView) item.getActionView();
        sv.setQueryHint("input");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "검색하라", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {

            case R.id.menu_no1:

                break;
            case R.id.menu_no2:

                break;
            case R.id.menu_no3:

                break;
            case R.id.menu_jang:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("다이얼 로그");
                builder.setIcon(android.R.drawable.ic_dialog_alert);


                builder.setMessage("Do you wanna Quit ??");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast t = Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT);
                        t.show();

                    }
                });


                builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast t = Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT);
                        t.show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
