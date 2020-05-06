package com.example.task2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button submit;
    int flag=0;

    //recyclerview
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    public myAdapter adapter;

    String regexStr = "^[a-z0-9_-]{3,15}$";
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submit = (Button) findViewById(R.id.submit_button);
        //map to store values
        final Map<String,String> submitmap = new HashMap<>();

        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //dummy data
        Model obj1 = new Model("Enter username", regexStr, "User Name");
        Model obj2 = new Model("Enter email", EMAIL_PATTERN, "Email ID");



        final ArrayList<EditText> arr=new ArrayList<EditText>();
        final ArrayList<Model> list = new ArrayList<Model>();
        list.add(obj1);
        list.add(obj2);


        mAdapter= new myAdapter(list, arr);
        recyclerView.setAdapter(mAdapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=1;
                submitmap.clear();
                for (int i = 0; i < list.size(); i++){
                    String s= myAdapter.textlist.get(i).getEdit();
                    String regexs= myAdapter.textlist.get(i).getRegex();
                    if(s==null) {
                        Toast.makeText(MainActivity.this, "Please type something", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    if(regexs.isEmpty())
                    {
                        submitmap.put(myAdapter.textlist.get(i).getName(), myAdapter.textlist.get(i).getEdit());
                        if (i == (list.size() - 1))
                            Toast.makeText(MainActivity.this, "Successfull", Toast.LENGTH_SHORT).show();


                    }
                    else {
                        boolean vcheck = validateregex(s, regexs);
                        if (!vcheck) {
                            myAdapter.edittest.get(i).setError("Invalid");
                        } else {
                            submitmap.put(adapter.textlist.get(i).getName(), adapter.textlist.get(i).getEdit());
                            if (i == (list.size() - 1))
                                Toast.makeText(MainActivity.this, "Successfull", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

    }
    public static boolean validateregex(String name, String r){
        Pattern pattern;
        pattern = Pattern.compile(r);
        Matcher mtch = pattern.matcher(name);
        return mtch.matches();
    }
}
