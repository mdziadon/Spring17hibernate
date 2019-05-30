package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    @Query("select b from Book b where b.title = ?1")
    List<Book> findByTitleQuery(String title);

    List<Book> findByCategoryId(Long id);

    @Query("select b from Book b where b.category.id = :categoryId")
    List<Book> findByCategoryIdQuery(@Param("categoryId") Long id);

    List<Book> findByAuthorsId(Long id);

    List<Book> findByPublisherId(Long id);

    List<Book> findByRatingGreaterThanEqual(int rating);

    Book findFirstByCategoryIdOrderByTitle(Long id);

    List<Book> findAllByProposition(boolean proposition);

    @Modifying
    @Query(value = "delete from book_authors where book_id = ?1", nativeQuery = true)
    void deleteBookRelations(Long id);

}
