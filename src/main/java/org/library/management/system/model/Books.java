package org.library.management.system.model;

public class Books {

    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private double ratingSum;
    private int ratingCount;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public double getRatingSystem() {
        return ratingSum;
    }

    public void setRatingSystem(double ratingSum) {
        this.ratingSum = ratingSum;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Books(int bookId, String title, String author, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
        this.ratingSum = 0;
        this.ratingCount = 0;
    }

    public Books() {
    }

    public void addRating(int rating){
        this.ratingSum += rating;
        this.ratingCount++;
    }

    public double getAverageRating(){
        return ratingCount == 0 ? 0 : ratingSum/ratingCount;
    }
}
