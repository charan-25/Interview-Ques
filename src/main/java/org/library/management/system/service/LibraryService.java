package org.library.management.system.service;

import org.library.management.system.model.Books;
import org.library.management.system.model.Member;


import javax.sound.midi.MetaMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryService {
    private Map<Integer, Books> books = new HashMap<>();
    private Map<Integer, Member> members = new HashMap<>();
    private int bookIdCounter = 1,memberIdCounter=1;


    public Books addBook(String title,String author){
        Books book = new Books(bookIdCounter++,title,author,true);
        books.put(book.getBookId(),book);
        return book;
    }

    public Member registerMember(String name){
        Member member = new Member(memberIdCounter++,name);
        members.put(member.getMemberId(),member);
        return member;
    }

    public boolean borrowedBook(int bookId,int memberId){
        Books book = books.get(bookId);
        Member member = members.get(memberId);

        if(book!= null && member!=null && book.isAvailable()){
            book.setAvailable(false);
            member.getBorrowedBooks().add(bookId);
            return true;
        }
        return false;
    }

    public boolean isBookAvailable(int bookId){
        Books books1 = books.get(bookId);
        return books != null && books1.isAvailable();
    }


    public double getBookRating(int bookId){
        Books book = books.get(bookId);
        return book != null ? book.getAverageRating() : 0;
    }

    public boolean returnBook(int bookId,int memberId,int rating){
        Books book = books.get(bookId);
        Member member = members.get(memberId);
        if(book != null && member != null && member.getBorrowedBooks().remove(Integer.valueOf(bookId))){
            book.setAvailable(true);
            book.addRating(rating);
            return true;
        }
        return false;
    }

    public List<Books> getBorrowedBooks(int memberId){
        Member member = members.get(memberId);
        List<Books> result = new ArrayList<>();
        if(member!= null){
            for(Integer bookId: member.getBorrowedBooks())
                result.add(books.get(bookId));
        }
        return result;
    }
}
