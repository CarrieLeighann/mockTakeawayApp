package com.example.clb.takeawayapp;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        displayMenuView();

    }

    private void displayMenuView(){

        final RecyclerView menu = findViewById(R.id.menu_list);

        final LinearLayoutManager menuLayoutManager = new LinearLayoutManager(this);
        menu.setLayoutManager(menuLayoutManager);

        List<MenuOption> menuData = getMenuData();

        final MenuRecyclerAdapter adapter = new MenuRecyclerAdapter(this, menuData);

        menu.setAdapter(adapter);

        DividerItemDecoration divider = new DividerItemDecoration(this, menuLayoutManager.getOrientation());

        menu.addItemDecoration(divider);

    }

    private List<MenuOption> getMenuData() {

        List<MenuOption> menu = new ArrayList<>();

        JSONObject menuData = readLines("menu.txt");

        try {
            JSONArray menuList = menuData.getJSONArray("menu");

            for (int i = 0; i < menuList.length(); i++){

                MenuOption option = new MenuOption((menuList.getJSONObject(i).getString("name")), (menuList.getJSONObject(i).getString("price")));

                menu.add(option);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

           return menu;
    }

    public JSONObject readLines(String filename) {
        StringBuilder stringBuilder = new StringBuilder();
        AssetManager assets = this.getAssets();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(assets.open(filename)));

        while(true) {
            String line = reader.readLine();
            if(line == null) {
                break;
            }

            stringBuilder.append(line);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject menuJSON = null;

        try {
            menuJSON = new JSONObject(stringBuilder.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return menuJSON;
    }

}
