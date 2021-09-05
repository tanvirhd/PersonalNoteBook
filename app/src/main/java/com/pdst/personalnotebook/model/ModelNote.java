package com.pdst.personalnotebook.model;

import java.util.List;

public class ModelNote {
    private String noteTitle;
    private String noteBody;
    private String modifiedOn;
    private int categoryId;

    private boolean isPinned;
    private boolean hasAttachment;
    private List<String> attachmentPath;

    private boolean isProtected;
    private String notePassword;

    public ModelNote(String noteTitle, String noteBody,
                     String modifiedOn, int categoryId,
                     boolean isPinned, boolean hasAttachment,
                     List<String> attachmentPath, boolean isProtected, String notePassword) {

        this.noteTitle = noteTitle;
        this.noteBody = noteBody;
        this.modifiedOn = modifiedOn;
        this.categoryId = categoryId;
        this.isPinned = isPinned;
        this.hasAttachment = hasAttachment;
        this.attachmentPath = attachmentPath;
        this.isProtected = isProtected;
        this.notePassword = notePassword;
    }
}
