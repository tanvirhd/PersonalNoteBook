package com.pdst.personalnotebook.ui;
//testing commit
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
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
import com.pdst.personalnotebook.viewmodel.ViewModelNote;

import java.util.ArrayList;
import java.util.List;

public class ActivityHome extends AppCompatActivity {

    private static final String TAG = "ActivityHome";

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

    private ViewModelNote viewModelNote;

    boolean isOpen=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        init();

        btnCreateNewCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityHome.this, "new category create", Toast.LENGTH_SHORT).show();
                openCreateNewCategoryDialogBox();
            }
        });

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


        viewModelNote.deleteNoteById(modelNoteList.get(0).id);
        adapterNoteRecy.notifyDataSetChanged();

        Toast.makeText(ActivityHome.this, ""+modelNoteList.get(0).id, Toast.LENGTH_SHORT).show();



    }

    @Override
    protected void onResume() {
        super.onResume();

        /*viewModelNote.getAllNotes().observe(this, new Observer<List<ModelNote>>() {
            @Override
            public void onChanged(List<ModelNote> modelNotes) {
                modelNoteList.clear();
                modelNoteList.addAll(modelNotes);
                adapterNoteRecy.notifyDataSetChanged();

                Log.d(TAG, "onChanged: ActivityHome Notes" + modelNoteList.get(0).getNoteTitle());
                Toast.makeText(ActivityHome.this, "getting data", Toast.LENGTH_SHORT).show();
            }
        });*/


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

    private void init() {
        // Note Category horizontal recyclerView
        recyclerViewCategory=findViewById(R.id.categoryRecy);
        btnCreateNewCategory=findViewById(R.id.ivCreteNewCategory);
        recyclerViewNote=findViewById(R.id.noteRecy);
        categoryList=new ArrayList<>();

        // New Category Create Section
        recyclerViewCategory.setLayoutManager(new LinearLayoutManager(ActivityHome.this,LinearLayoutManager.HORIZONTAL,false));
        adapterNoteCategoryRecy=new AdapterNoteCategoryRecy(categoryList,ActivityHome.this);
        recyclerViewCategory.setAdapter(adapterNoteCategoryRecy);

        // All Notes Vertical recyclerView
        modelNoteList= new ArrayList<>();
        recyclerViewNote.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
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


        modelNoteList.add(new ModelNote(
              "note 1"
        ));
        modelNoteList.add(new ModelNote(
                "note 2"
        ));


        viewModelNote= new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelNote.class);

    }


}