package com.example.cse227first;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed2;
    Button b1;
    RecyclerView rv;
    RecyclerView.LayoutManager layoutManager;
    MyAdapter adapter;
    ArrayList<PersonData> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        b1=findViewById(R.id.button1);
        rv=findViewById(R.id.recyclerview);
        al=new ArrayList<>();
        adapter=new MyAdapter(this,al);
        layoutManager=new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(adapter);
    }


    public void dothis(View view)
    {
        String name=ed1.getText().toString();
        int reg=Integer.parseInt(ed2.getText().toString());
        PersonData personData=new PersonData(name,reg);
        al.add(personData);
        adapter.notifyDataSetChanged();
    }
}
