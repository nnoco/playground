package day1;

public class BookRepositoryImpl implements BookRepository{

	public Book findById(String bookId) {
		System.out.println("책 정보 가져왔다 치고");
		return new Book();
	}

}
