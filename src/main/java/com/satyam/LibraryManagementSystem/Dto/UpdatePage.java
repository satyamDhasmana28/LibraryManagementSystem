package com.satyam.LibraryManagementSystem.Dto;

public class UpdatePage {
    private int id;
    private int pages;

    public UpdatePage() {
    }

    public UpdatePage(int id, int pages) {
        this.id = id;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
