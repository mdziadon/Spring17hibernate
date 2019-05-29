package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook(Book book) {
        entityManager.persist(book);
    }

    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    public Book findBook(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void deleteBook(Long id) {
        Book book = findBook(id);
        if (book != null) {
            entityManager.remove(book);
        }
    }

    public List<Book> findBooks() {
        Query query = entityManager.createQuery("select b from Book b where b.proposition = false");
        return query.getResultList();
    }

    public List<Book> findPropositions() {
        Query query = entityManager.createQuery("select b from Book b where b.proposition = true");
        return query.getResultList();
    }

    public List<Book> findBooksByRating(int rating) {
        Query query = entityManager.createQuery("select b from Book b join fetch b.authors where b.rating >= :rating and b.proposition = false");
        query.setParameter("rating", rating);
        return query.getResultList();
    }
}
