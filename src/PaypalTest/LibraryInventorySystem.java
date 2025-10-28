//package PaypalTest;
//
//public class LibraryInventorySystem {
//    import java.io.*;
//import java.util.*;
//    interface IBook {
//        void setId(int id);
//        int getId();
//        void setTitle(String title);
//        String getTitle();
//        void setAuthor(String author);
//        String getAuthor();
//        void setCategory(String category);
//        String getCategory();
//        void setPrice(int price);
//        int getPrice();
//    }
//    interface ILibrarySystem {
//        void addBook(IBook book, int quantity);
//        void removeBook(IBook book, int quantity);
//        int calculateTotal();
//        Map<String, Integer> categoryTotalPrice();
//        List<BooksInfo> booksInfo();
//        List<CategoryAuthorWithCount> categoryAndAuthorWithCount();
//    }
//    class BooksInfo {
//        String title;
//        int quantity;
//        int price;
//
//        BooksInfo(String title, int quantity, int price) {
//            this.title = title;
//            this.quantity = quantity;
//            this.price = price;
//        }
//    }
//    class CategoryAuthorWithCount {
//        String category;
//        String author;
//        int count;
//
//        CategoryAuthorWithCount(String category, String author, int count) {
//            this.category = category;
//            this.author = author;
//            this.count = count;
//        }
//    }
//    class Book implements IBook {
//        int id;
//        String title;
//        String author;
//        String category;
//        int price;
//        @Override
//        public void setId(int id) {
//            // TODO Auto-generated method stub
//            this.id=id;
//        }
//        @Override
//        public int getId() {
//            // TODO Auto-generated method stub
//            return id;
//        }
//        @Override
//        public void setTitle(String title) {
//            // TODO Auto-generated method stub
//            this.title=title;
//
//        }
//        @Override
//        public String getTitle() {
//            // TODO Auto-generated method stub
//            return title;;
//        }
//        @Override
//        public void setAuthor(String author) {
//            // TODO Auto-generated method stub
//            this.author=author;
//
//        }
//        @Override
//        public String getAuthor() {
//            // TODO Auto-generated method stub
//            return author;
//        }
//        @Override
//        public void setCategory(String category) {
//            // TODO Auto-generated method stub
//            this.category=category;
//
//        }
//        @Override
//        public String getCategory() {
//            // TODO Auto-generated method stub
//            return category;
//        }
//        @Override
//        public void setPrice(int price) {
//            // TODO Auto-generated method stub
//            this.price=price;
//
//        }
//        @Override
//        public int getPrice() {
//            // TODO Auto-generated method stub
//            return price;
//        }
//
//    }
//    class LibrarySystem implements ILibrarySystem {
//        private Map<IBook,Integer>_book;
//        private Map<String, List<IBook>> categoryToBooks;
//        private Map<String, List<IBook>> authorToBooks;
//        @Override
//        public void addBook(IBook book, int quantity) {
//            // TODO Auto-generated method stub
//            if(this._book==null){
//                this._book=new HashMap<>();
//                this.categoryToBooks=new HashMap<>();
//                this.authorToBooks=new HashMap<>();
//            }
//            this._book.put(book, quantity);
//            this.categoryToBooks.computeIfAbsent(book.getCategory(), x-> new ArrayList<>()).add(book);
//            this.authorToBooks.computeIfAbsent(book.getAuthor(), x-> new ArrayList<>()).add(book);
//        }
//        @Override
//        public void removeBook(IBook book, int quantity) {
//            // TODO Auto-generated method stub
//            if(this._book.containsKey(book)){
//                if(this._book.get(book)<=quantity){
//                    this._book.remove(book);
//                }else{
//                    this._book.put(book, this._book.get(book)-quantity);
//                }
//            }
//        }
//        @Override
//        public int calculateTotal() {
//            // TODO Auto-generated method stub
//            int amt = 0;
//            for(Map.Entry<IBook,Integer> entry:this._book.entrySet()){
//                IBook book = entry.getKey();
//                int price = book.getPrice();
//                amt+=(price*entry.getValue());
//            }
//            return amt;
//        }
//        @Override
//        public Map<String, Integer> categoryTotalPrice() {
//            // TODO Auto-generated method stub
//            Map<String,Integer> cToPrice =new HashMap<>();
//            for(Map.Entry<String,List<IBook>> entry:this.categoryToBooks.entrySet()){
//                String category = entry.getKey();
//                int categoryPrice=0;
//                for(IBook b:entry.getValue()){
//                    categoryPrice+=_book.get(b)*b.getPrice();
//                }
//                cToPrice.put(category, categoryPrice);
//            }
//            return cToPrice;
//        }
//
//        @Override
//        public List<BooksInfo> booksInfo() {
//            // TODO Auto-generated method stub
//            List<BooksInfo> ls = new ArrayList<>();
//            for(Map.Entry<IBook,Integer> entry:this._book.entrySet()){
//                IBook b = entry.getKey();
//                ls.add(new BooksInfo(b.getTitle(), entry.getValue(), b.getPrice()));
//            }
//            Collections.sort(ls,new Comparator<BooksInfo>() {
//                @Override
//                public int compare(BooksInfo a, BooksInfo b) {
//                    if(a.title.equals(b.title)){
//                        return a.quantity-b.quantity;
//                    }
//                    return a.title.compareTo(b.title);
//                }
//
//            });
//            return ls;
//        }
//        @Override
//        public List<CategoryAuthorWithCount> categoryAndAuthorWithCount() {
//            // TODO Auto-generated method stub
//            List<CategoryAuthorWithCount> ls = new ArrayList<>();
//            for(Map.Entry<String,List<IBook>> entry:this.authorToBooks.entrySet()){
//
//            }
//            return ls;
//        }
//
//    }
//    public class Solution {
//        public static void main(String[] args) throws IOException{
//            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            PrintWriter out = new PrintWriter(System.out);
//            ILibrarySystem librarySystem = new LibrarySystem();
//            int bCount = Integer.parseInt(br.readLine().trim());
//            for (int i = 1; i <= bCount; i++) {
//                String[] a = br.readLine().trim().split(" ");
//                IBook e = new Book();
//                e.setId(Integer.parseInt(a[0]));
//                e.setTitle(a[1]);
//                e.setAuthor(a[2]);
//                e.setCategory(a[3]);
//                e.setPrice(Integer.parseInt(a[4]));
//                librarySystem.addBook(e, Integer.parseInt(a[5]));
//            }
//            out.println("Book Info:");
//            List<BooksInfo> booksInfo = librarySystem.booksInfo();
//            for (BooksInfo entry : booksInfo) {
//                String title = entry.title;
//                int quantity = entry.quantity;
//                int price = entry.price;
//                out.println("Book Name:" + title + ", Quantity:" + quantity + ", Price:" + price);
//            }
//            out.println("Category Total Price:");
//            Map<String, Integer> categoryTotalPrice = librarySystem.categoryTotalPrice();
//            for (Map.Entry<String, Integer> entry : categoryTotalPrice.entrySet()) {
//                String category = entry.getKey();
//                int totalPrice = entry.getValue();
//                out.println("Category:" + category + ", Total Price:" + totalPrice);
//            }
//            List<CategoryAuthorWithCount> categoryAndAuthorWithCount = librarySystem.categoryAndAuthorWithCount();
//            out.println("Category And Author With Count:");
//            for (CategoryAuthorWithCount entry : categoryAndAuthorWithCount) {
//                String category = entry.category;
//                String author = entry.author;
//                int count = entry.count;
//                out.println("Category:" + category + ", Author:" + author + ", Count:" + count);
//            }
//            int total = librarySystem.calculateTotal();
//            out.println("Total Price: " + total);
//            out.flush();
//            out.close();
//        }
//    }
//
//}
