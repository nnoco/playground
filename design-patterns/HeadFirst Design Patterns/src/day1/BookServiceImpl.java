package day1;

public class BookServiceImpl implements BookService{
	BookRepository bookRepository = new BookRepositoryImpl();

	public Book getBookInfo(String bookId) {
		return bookRepository.findById(bookId);
	}
}
