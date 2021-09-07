package com.pdst.personalnotebook.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pdst.personalnotebook.Adapter.AdapterNoteCategoryRecy;
import com.pdst.personalnotebook.Adapter.AdapterNoteRecy;
import com.pdst.personalnotebook.R;
import com.pdst.personalnotebook.model.ModelCategory;
import com.pdst.personalnotebook.model.ModelNote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ActivityHome extends AppCompatActivity {

    private List<ModelCategory> categoryList;
    private AdapterNoteCategoryRecy adapterNoteCategoryRecy;
    private RecyclerView recyclerViewCategory;

    private List<ModelNote> modelNoteList;
    private AdapterNoteRecy adapterNoteRecy;
    private RecyclerView recyclerViewNote;

    private FloatingActionButton mainAddFab, addNewNoteFab,addNewChecklistFab;
    private TextView addNewNoteFabText, addNewChecklistFabText;

    private Animation fabOpenAnimation,fabCloseAnimation,fabRotateForward,fabRotateBackward;
    private boolean isOpen=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Note Category horizontal recyclerView
        recyclerViewCategory=findViewById(R.id.categoryRecy);
        initCategoryList();

        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(ActivityHome.this,LinearLayoutManager.HORIZONTAL,false));
        adapterNoteCategoryRecy=new AdapterNoteCategoryRecy(categoryList,ActivityHome.this);
        recyclerViewCategory.setAdapter(adapterNoteCategoryRecy);


        // All Notes Vertical recyclerView
        recyclerViewNote=findViewById(R.id.noteRecy);
        recyclerViewNote.setLayoutManager(
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        );
        adapterNoteRecy=new AdapterNoteRecy(modelNoteList,ActivityHome.this);
        recyclerViewNote.setAdapter(adapterNoteRecy);


        // Floating Action Button
        mainAddFab=findViewById(R.id.fab_main_button);
        addNewNoteFab=findViewById(R.id.fab_add_new_note);
        addNewChecklistFab=findViewById(R.id.fab_add_new_checklist);

        addNewNoteFabText=findViewById(R.id.tv_fab_new_noteText);
        addNewChecklistFabText=findViewById(R.id.tv_fab_new_checklistText);

        fabOpenAnimation= AnimationUtils.loadAnimation(ActivityHome.this,R.anim.fab_open);
        fabCloseAnimation= AnimationUtils.loadAnimation(ActivityHome.this,R.anim.fab_close);

        fabRotateForward= AnimationUtils.loadAnimation(ActivityHome.this,R.anim.fab_rotate_forward);
        fabRotateBackward= AnimationUtils.loadAnimation(ActivityHome.this,R.anim.fab_rotate_backward);




        mainAddFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(isOpen){

//                    addNewNoteFab.setAnimation(fabCloseAnimation);
//                    addNewChecklistFab.setAnimation(fabCloseAnimation);
//                    addNewNoteFabText.setVisibility(View.INVISIBLE);
//                    addNewChecklistFabText.setVisibility(View.INVISIBLE);

                    mainAddFab.startAnimation(fabRotateBackward);
                    addNewNoteFab.startAnimation(fabCloseAnimation);
                    addNewChecklistFab.startAnimation(fabCloseAnimation);
                    addNewNoteFabText.startAnimation(fabCloseAnimation);
                    addNewChecklistFabText.startAnimation(fabCloseAnimation);

                    isOpen=false;
                }else{

//                    addNewNoteFab.setAnimation(fabOpenAnimation);
//                    addNewChecklistFab.setAnimation(fabOpenAnimation);
//                    addNewNoteFabText.setVisibility(View.VISIBLE);
//                    addNewChecklistFabText.setVisibility(View.VISIBLE);

                    mainAddFab.startAnimation(fabRotateForward);
                    mainAddFab.startAnimation(fabRotateBackward);
                    addNewNoteFab.startAnimation(fabCloseAnimation);
                    addNewChecklistFab.startAnimation(fabCloseAnimation);
                    addNewNoteFabText.startAnimation(fabCloseAnimation);
                    addNewChecklistFabText.startAnimation(fabCloseAnimation);

                    isOpen=true;
                }
            }
        });

    }

    private void initCategoryList() {
        categoryList=new ArrayList<>();

        categoryList.add(
                new ModelCategory(1,"All Notes")
        );

        categoryList.add(
                new ModelCategory(2,"Check List")
        );

        categoryList.add(
                new ModelCategory(3,"Work")
        );

        categoryList.add(
                new ModelCategory(4,"Personal")
        );

        categoryList.add(
                new ModelCategory(5,"School")
        );

        categoryList.add(
                new ModelCategory(6,"Memories")
        );


        modelNoteList= new ArrayList<>();
        modelNoteList.add(
                new ModelNote(
                        "Barir Kaj",
                         "Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
                                 "Aperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo ",
                        "12/07/2021",
                        1,
                        false,
                        true,
                        Arrays.asList("abch","jhacj","jbaksck"),
                        false,
                        "1234"
                )
        );

        modelNoteList.add(
                new ModelNote(
                        "lekha Pora",
                        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
                                "Aperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo " +
                                "illum, nemo nesciunt odit officia quae quis quod rem tempore velit voluptatem.",
                        "12/07/2021",
                        6,
                        false,
                        false,
                        Arrays.asList("abch","jhacj","jbaksck"),
                        true,
                        "1234"
                )
        );

        modelNoteList.add(
                new ModelNote(
                        "Home Task",
                        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. ",
                        "12/07/2021",
                         4,
                        false,
                        true,
                         Arrays.asList("abch","jhacj","jbaksck"),
                        false,
                        "1234"
                )
        );


        modelNoteList.add(
                new ModelNote(
                        "Pen",
                        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
                                "Aperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo " +
                                "illum, nemo nesciunt odit officia quae quis quod rem tempore velit voluptatem." +
                                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo Aperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo",

                        "12/07/2021",
                         6,
                        true,
                        true,
                         Arrays.asList("abch","jhacj","jbaksck"),
                        false,
                        "1234"
                )
        );

        modelNoteList.add(
                new ModelNote(
                        "Numbers",
                        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
                                "Aperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo vAperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicaboAperiam" +
                                "consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo ",
                        "12/07/2021",
                         3,
                        false,
                        true,
                         Arrays.asList("abch","jhacj","jbaksck"),
                        true,
                        "1234"
                )
        );

    }


}