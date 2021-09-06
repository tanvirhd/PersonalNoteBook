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

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteBody() {
        return noteBody;
    }

    public void setNoteBody(String noteBody) {
        this.noteBody = noteBody;
    }

    public String getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(String modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    public boolean isHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    public List<String> getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(List<String> attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public boolean isProtected() {
        return isProtected;
    }

    public void setProtected(boolean aProtected) {
        isProtected = aProtected;
    }

    public String getNotePassword() {
        return notePassword;
    }

    public void setNotePassword(String notePassword) {
        this.notePassword = notePassword;
    }
}
