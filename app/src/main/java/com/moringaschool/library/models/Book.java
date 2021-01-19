package com.moringaschool.library.models;

public class Book {

    private String name;
    private String Description;
    private String rating;
    private int nb_pages;
    private String kategori;
    private String publisher;
    private String image_url;

    public Book(){

    }

    public Book(String name, String description, String rating, int nb_pages, String kategori, String publisher, String image_url){
      this.name = name;
      this.Description = description;
      this.kategori = kategori;
      this.nb_pages = nb_pages;
      this.rating = rating;
      this.image_url = image_url;
      this.publisher = publisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getNb_pages() {
        return nb_pages;
    }

    public void setNb_pages(int nb_pages) {
        this.nb_pages = nb_pages;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void add(Book book) {
    }
}
