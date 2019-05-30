package pl.coderslab.author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findByEmail(String email);

    Author findByPesel(String pesel);

    List<Author> findByLastName(String lastName);

    @Query("select a from Author a where a.email like ?1%")
    List<Author> findByEmailQuery(String emailPrefix);

    @Query("select a from Author a where a.pesel like ?1%")
    List<Author> findByPeselQuery(String peselPrefix);

}
