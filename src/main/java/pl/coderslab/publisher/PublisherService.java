package pl.coderslab.publisher;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PublisherService {

    private PublisherDao publisherDao;

    public PublisherService(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    public void savePublisher(Publisher publisher) {
        publisherDao.savePublisher(publisher);
    }

    public void updatePublisher(Publisher publisher) {
        publisherDao.updatePublisher(publisher);
    }

    public Publisher findPublisher(Long id) {
        return publisherDao.findPublisher(id);
    }

    public void deletePublisher(Long id) {
        publisherDao.deletePublisher(id);
    }

    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }
}
