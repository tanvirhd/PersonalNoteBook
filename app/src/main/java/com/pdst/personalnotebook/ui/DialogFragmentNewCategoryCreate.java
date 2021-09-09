package com.pdst.personalnotebook.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.pdst.personalnotebook.R;

public class DialogFragmentNewCategoryCreate extends AppCompatDialogFragment {

    private EditText newCategoryName;
    private TextView btnNewCategoryCreate;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(),R.style.CustomAlertDialog);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_new_category_create,null);


        builder.setView(view)
                .setTitle("New Category");

        newCategoryName =view.findViewById(R.id.editText_new_category_text);
        btnNewCategoryCreate=view.findViewById(R.id.btnCreateNewCategory);

        btnNewCategoryCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code Required
            }
        });

        return builder.create();
    }
}
