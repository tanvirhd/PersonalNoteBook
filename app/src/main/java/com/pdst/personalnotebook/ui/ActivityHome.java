package com.pdst.personalnotebook.ui;
//testing commit
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
    private ImageView btnCreateNewCategory;

    private List<ModelNote> modelNoteList;
    private AdapterNoteRecy adapterNoteRecy;
    private RecyclerView recyclerViewNote;

    private FloatingActionButton mainAddFab, addNewNoteFab,addNewChecklistFab;
    private Animation fabOpen,fabClose,rotateForward, rotateBackward;

    private TextView addNewNoteFabText, addNewChecklistFabText;

    boolean isOpen=false;

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

        // New Category Create Section
        btnCreateNewCategory=findViewById(R.id.ivCreteNewCategory);

        btnCreateNewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityHome.this, "new category create", Toast.LENGTH_SHORT).show();
                openCreateNewCategoryDialogBox();
            }
        });



        // All Notes Vertical recyclerView
        recyclerViewNote=findViewById(R.id.noteRecy);
        recyclerViewNote.setLayoutManager(
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        );
        adapterNoteRecy=new AdapterNoteRecy(modelNoteList,ActivityHome.this);
        recyclerViewNote.setAdapter(adapterNoteRecy);






        // Floating Action Button
        mainAddFab= (FloatingActionButton) findViewById(R.id.fab_main_button);
        addNewNoteFab= (FloatingActionButton) findViewById(R.id.fab_add_new_note);
        addNewChecklistFab= (FloatingActionButton) findViewById(R.id.fab_add_new_checklist);

        addNewNoteFabText=(TextView)findViewById(R.id.tv_fab_new_noteText);
        addNewChecklistFabText=(TextView)findViewById(R.id.tv_fab_new_checklistText);


        fabOpen=AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose=AnimationUtils.loadAnimation(this,R.anim.fab_close);

        rotateForward=AnimationUtils.loadAnimation(this,R.anim.fab_rotate_forward);
        rotateBackward=AnimationUtils.loadAnimation(this,R.anim.fab_rotate_backward);


        mainAddFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
            }
        });

        addNewNoteFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                animateFab();
                Toast.makeText(ActivityHome.this,"Note Clicked",Toast.LENGTH_SHORT).show();
            }
        });

        addNewChecklistFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                animateFab();
                Toast.makeText(ActivityHome.this,"CheckList Clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }



    private void animateFab(){
        if(isOpen){

            mainAddFab.startAnimation(rotateForward);
            addNewNoteFab.startAnimation(fabClose);
            addNewChecklistFab.startAnimation(fabClose);
            addNewNoteFab.setClickable(true);
            addNewChecklistFab.setClickable(true);
            addNewNoteFabText.startAnimation(fabClose);
            addNewChecklistFabText.startAnimation(fabClose);
            isOpen=false;

        }else{

            mainAddFab.startAnimation(rotateBackward);
            addNewNoteFab.startAnimation(fabOpen);
            addNewChecklistFab.startAnimation(fabOpen);
            addNewNoteFab.setClickable(false);
            addNewChecklistFab.setClickable(false);
            addNewNoteFabText.startAnimation(fabOpen);
            addNewChecklistFabText.startAnimation(fabOpen);
            isOpen=true;

        }
    }

    public void openCreateNewCategoryDialogBox(){
        DialogFragmentNewCategoryCreate dialogFragmentNewCategoryCreate = new DialogFragmentNewCategoryCreate();
        dialogFragmentNewCategoryCreate.show(getSupportFragmentManager(),"create new Category");
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
        /*modelNoteList.add(
                new ModelNote(
                        "Barir Kaj koresis? Ki obstha tor ?",
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
                        false,
                        "1234"
                )
        );


        modelNoteList.add(
                new ModelNote(
                        "Land Line",
                        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
                                "Aperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo vAperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicaboAperiam" +
                                "consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo ",
                        "12/07/2021",
                        3,
                        false,
                        false,
                        Arrays.asList("abch","jhacj","jbaksck"),
                        false,
                        "1234"
                )
        );


        modelNoteList.add(
                new ModelNote(
                        "Peronal",
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


        modelNoteList.add(
                new ModelNote(
                        "Numbers",
                        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
                                "Aperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo vAperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicaboAperiam" +
                                "consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo ",
                        "12/07/2021",
                        3,
                        false,
                        false,
                        Arrays.asList("abch","jhacj","jbaksck"),
                        false,
                        "1234"
                )
        );


        modelNoteList.add(
                new ModelNote(
                        "Numbers",
                        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. ",
                        "12/07/2021",
                        3,
                        false,
                        true,
                        Arrays.asList("abch","jhacj","jbaksck"),
                        false,
                        "1234"
                )
        );


        modelNoteList.add(
                new ModelNote(
                        "Work",
                        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
                                "Aperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo vAperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicaboAperiam" +
                                "consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo consequuntur deleniti dicta dolor dolorum esse eum expedita explicaboconsequuntur deleniti dicta dolor dolorum esse eum expedita explicabo",
                        "12/07/2021",
                        3,
                        false,
                        true,
                        Arrays.asList("abch","jhacj","jbaksck"),
                        false,
                        "1234"
                )
        );


        modelNoteList.add(
                new ModelNote(
                        "Math Lecture Note",
                        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
                                "Aperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo vAperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicaboAperiam",
                        "12/07/2021",
                        3,
                        false,
                        true,
                        Arrays.asList("abch","jhacj","jbaksck"),
                        true,
                        "1234"
                )
        );


        modelNoteList.add(
                new ModelNote(
                        "Working Hour",
                        "Lorem ipsum dolor sit amet, consectetur adipisicing elit. " +
                                "Aperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicabo vAperiam consequuntur deleniti dicta dolor dolorum esse eum expedita explicaboAperiam" +
                                "consequuntur deleniti dicta dolor dolorum esse eum expedita explicaboconsequuntur deleniti dicta dolor dolorum esse eum expedita explicaboconsequuntur deleniti dicta dolor dolorum esse eum expedita explicaboconsequuntur deleniti dicta dolor dolorum esse eum expedita explicaboconsequuntur deleniti dicta dolor dolorum esse eum expedita explicabo ",
                        "12/07/2021",
                        3,
                        false,
                        true,
                        Arrays.asList("abch","jhacj","jbaksck"),
                        false,
                        "1234"
                )
        );*/

    }


}