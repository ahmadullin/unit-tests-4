package seminars.fourth.book;

import org.junit.Test;
import seminars.fourth.book.Book;
import seminars.fourth.book.BookRepository;
import seminars.fourth.book.BookService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {
    @Test
    public void testFindBookById() {
        // Создаем мок-объект BookRepository
        BookRepository mockBookRepository = mock(BookRepository.class);

        // Создаем экземпляр BookService и передаем ему мок-объект BookRepository
        BookService bookService = new BookService(mockBookRepository);

        // Создаем тестовые данные
        String id = "1";
        Book book = new Book("1", "Book1", "Author1");

        // Проверяем результат
        Book result = bookService.findBookById(id);

        // Проверяем, что найденная книга соответствует тестовым данным
        assertEquals(book, result);

        // Вызываем метод findBookById с аргументом, который не существует в BookRepository
        try {
            bookService.findBookById("3");
            fail("Expected exception to be thrown");
        } catch (Exception e) {
            // Проверяем, что была выброшена ошибка, которую ожидаем
            assertEquals(e.getMessage(), "Book with id 3 not found");
        }
    }
}