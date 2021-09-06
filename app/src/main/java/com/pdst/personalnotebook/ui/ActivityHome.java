package com.pdst.personalnotebook.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.pdst.personalnotebook.Adapter.AdapterNoteCategoryRecy;
import com.pdst.personalnotebook.R;
import com.pdst.personalnotebook.model.ModelCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActivityHome extends AppCompatActivity {

    private List<ModelCategory> categoryList;
    private AdapterNoteCategoryRecy adapterNoteCategoryRecy;
    private RecyclerView recyclerViewCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerViewCategory=findViewById(R.id.categoryRecy);
        initCategoryList();

        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(ActivityHome.this,LinearLayoutManager.HORIZONTAL,false));
        adapterNoteCategoryRecy=new AdapterNoteCategoryRecy(categoryList,ActivityHome.this);
        recyclerViewCategory.setAdapter(adapterNoteCategoryRecy);

    }

    private void initCategoryList() {
        categoryList=new ArrayList<>();
        categoryList.add(
                new ModelCategory(new Random().nextInt(),"All Notes")
        );

        categoryList.add(
                new ModelCategory(new Random().nextInt(),"Check List")
        );

        categoryList.add(
                new ModelCategory(new Random().nextInt(),"Work")
        );

        categoryList.add(
                new ModelCategory(new Random().nextInt(),"Personal")
        );

        categoryList.add(
                new ModelCategory(new Random().nextInt(),"School")
        );

        categoryList.add(
                new ModelCategory(new Random().nextInt(),"Memories")
        );


    }


}