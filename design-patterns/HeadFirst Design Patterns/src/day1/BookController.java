package day1;

public class BookController extends Controller{
	BookService bookService;
	
	public void requestBookInfo(String bookId) {
		bookService.getBookInfo(bookId);
	}
}
