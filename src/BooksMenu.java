import java.util.Scanner;

public class BooksMenu {
    public static Book compareBooks(Book b1, Book b2){
        if(b1.getPrice() < b2.getPrice())
        {
            return b2;
        }
        else if (b1.getPrice() > b2.getPrice())
        {
            return b1;
        }
        else
        {
            return null;
        }

    }
    public static void main(String[]args) {
//        Book book1 = new Book("Atomic Habits", "Jeam", 230.4f); use of constructor
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[10];
        int bookIndex = 0;
        while (true) {
            System.out.print("Press 1 to view books.\nPress 2 to add books.\nPress 3 to compare 2 books\nPress 4 to remove a book\nPress any key to exit\nEnter your choice: ");
            int userAction = Integer.parseInt(sc.nextLine());
            if (userAction == 1) {
                if (books[0] == null) {
                    System.out.println("==========\nNo Books Found!\n==========");
                } else {
                    for (int i = 0; i < bookIndex; i++) {
                        System.out.println("Index: " + i);
                        System.out.println(books[i]);
                        System.out.println("==============");

                    }
                }


            } else if (userAction == 2) {
                if (bookIndex == 10) {
                    System.out.println("10 books already added");
                    continue;
                }
                System.out.println("Index: "+bookIndex);
                System.out.println("Enter book title: ");
                String titleBook = sc.nextLine();
                System.out.println("Enter author's name: ");
                String authorBook = sc.nextLine();
                System.out.println("Enter the price: ");
                float priceBook = Float.parseFloat(sc.nextLine());
                Book tempBook = new Book();
                tempBook.setTitle(titleBook);
                tempBook.setAuthor(authorBook);
                tempBook.setPrice(priceBook);
                books[bookIndex++] = tempBook;

            } else if (userAction == 3) {
                System.out.print("Enter the index of the first book to compare: ");
                int book1Index = Integer.parseInt(sc.nextLine());
                System.out.print("Enter the index of the second book to compare: ");
                int book2Index = Integer.parseInt(sc.nextLine());
                Book expensiveBook = compareBooks(books[book1Index], books[book2Index]);
                if(expensiveBook != null){
                if (books[book1Index] != null && book1Index < bookIndex && book2Index < bookIndex && books[book2Index] != null) {
                    System.out.println("The expensive book is: "+expensiveBook);
                }
                else{
                    System.out.println("Invalid Entry");
                }
                }else{
                    System.out.println("Both books are of equal prices!");
                }
           }
            else if (userAction == 4) {
            System.out.println("Enter the index of the book to delete: ");
            int deleteIndex = Integer.parseInt(sc.nextLine());
            if (deleteIndex >= 0 && deleteIndex < bookIndex) {
                for (int i = deleteIndex; i < bookIndex - 1; i++) {
                    books[i] = books[i + 1];
                }
                books[bookIndex - 1] = null;
                bookIndex--;
                System.out.println("Book removed successfully");
            }
            else {
                System.out.println("Invalid Entry!");
            }


            }
            else{
                break;
        }

    }}
}
