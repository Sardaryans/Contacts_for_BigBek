package com.example.nare.contacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView1,recyclerView;
    private RecyclerView.Adapter adapter1,adapter;
    private List<Item_class> items1,items;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView1 = (RecyclerView)findViewById(R.id.recycler1);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);


        recyclerView1.setHasFixedSize(true);
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        items1 = new ArrayList<>();

        items1.add(new Item_class("Maritea Kocharyan",R.drawable.img1));
        items1.add(new Item_class("Ani Simonyan",R.drawable.img2));
        items1.add(new Item_class("Aghvan Harutyunyan",R.drawable.img3));
        items1.add(new Item_class("Arpi Zhamkochyan",R.drawable.img4));
        items1.add(new Item_class("Seroj Adamyan",R.drawable.img5));
        items1.add(new Item_class("Sieva Adamyan",R.drawable.img7));
        items1.add(new Item_class("Edit Telimyan",R.drawable.img8));
        items1.add(new Item_class("Arsen Levonyan",R.drawable.img9));
        items1.add(new Item_class("Arman Shahinyan",R.drawable.img10));
        items1.add(new Item_class("Anahit Mkhitaryann",R.drawable.img11));
        items1.add(new Item_class("Lilit Hovanyan",R.drawable.img12));
        items1.add(new Item_class("Hem Hovhanisyan",R.drawable.img13));

        Collections.sort(items1,new SortByName());

        adapter1 = new MyAdapter(items1,this);
        recyclerView1.setAdapter(adapter1);



        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        items = new ArrayList<>();

        String tox="",text="";

        try {
            FileInputStream fis = openFileInput("arxiv");
            InputStreamReader streamReader = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            while ((tox = bufferedReader.readLine())!=null){
                text+=tox;
            }



        } catch (Exception e) {

        }
        String[]array=text.split(" ");



        try {

            for (int i = 0; i < array.length; i++) {
                items.add(new Item_class(items1.get(Integer.parseInt(array[i])).getName(), items1.get(Integer.parseInt(array[i])).getImg(),R.mipmap.star));
                items1.get(Integer.parseInt(array[i])).setStar_img(R.mipmap.star);
            }
        }
        catch (Exception e){

        }
        Collections.sort(items,new SortByName());

        adapter = new MyAdapter(items,this);

        recyclerView.setAdapter(adapter);
    }


}
