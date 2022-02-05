package com.pdst.personalnotebook.model;

import java.util.List;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class ModelNote {
    @PrimaryKey (autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    private String noteTitle;

    @ColumnInfo(name = "body")
    private String noteBody;

    @ColumnInfo(name = "modifiedOn")
    private String modifiedOn;

    @ColumnInfo(name = "CategoryId")
    private int categoryId;

    @ColumnInfo(name = "isPinned")
    private boolean isPinned;

    @ColumnInfo(name = "hasAttachment")
    private boolean hasAttachment;

    /*@ColumnInfo(name = "attachmentPath")
    private List<String> attachmentPath;*/

    @ColumnInfo(name = "isProtected")
    private boolean isProtected;

    @ColumnInfo(name = "notePassword")
    private String notePassword;

    @Ignore
    public ModelNote(String noteTitle, String noteBody, String modifiedOn, int categoryId, boolean isPinned, boolean hasAttachment, boolean isProtected, String notePassword) {

        this.noteTitle = noteTitle;
        this.noteBody = noteBody;
        this.modifiedOn = modifiedOn;
        this.categoryId = categoryId;
        this.isPinned = isPinned;
        this.hasAttachment = hasAttachment;
        /*this.attachmentPath = attachmentPath;*/
        this.isProtected = isProtected;
        this.notePassword = notePassword;
    }

    public ModelNote(String noteTitle) {
        this.noteTitle = noteTitle;
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

    /*public List<String> getAttachmentPath() {
        return attachmentPath;
    }*/

    /*public void setAttachmentPath(List<String> attachmentPath) {
        this.attachmentPath = attachmentPath;
    }*/

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
