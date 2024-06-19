package org.library.management.system;

import org.library.management.system.model.Books;
import org.library.management.system.model.Member;
import org.library.management.system.service.LibraryService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        LibraryService service = new LibraryService();
        Books book1 = service.addBook("Java Fundamentals","John Doe");
        Books book2 = service.addBook("Advanced Java","Jane Smith");

        Member member1 = service.registerMember("Alice Johnson");
        Member member2 = service.registerMember("Bob Smith");


        service.borrowedBook(book1.getBookId(), member1.getMemberId());
        service.borrowedBook(book2.getBookId(),member1.getMemberId());
        System.out.println("Borrowed Books by Alice Jonson : "+service.getBorrowedBooks(member1.getMemberId()));
        System.out.println("Borrowed Books by Bob Smith : "+member2.getBorrowedBooks());

        service.returnBook(book2.getBookId(),member1.getMemberId(),4);
        System.out.println("Is Advanced Java book Available? : "+service.isBookAvailable(book2.getBookId()));
        System.out.println("Advanced Java average rating : "+service.getBookRating(book2.getBookId()));

        System.out.println("Books borrowed by Alice Johnson : "+service.getBorrowedBooks(member1.getMemberId()));
    }
}
