package service;

import java.util.List;

<<<<<<< Updated upstream
import domain.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class MovieService {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_config");
    private EntityManager em = emf.createEntityManager();

    public List<Movie> searchMoviesByTitle(String movieTitle) {
        TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.title LIKE :title", Movie.class)
        							.setParameter("title", "%" + movieTitle + "%");
        return query.getResultList();
    }

    public List<Movie> getNothing() {
        return null;
    }

    public void close() {
        em.close();
        emf.close();
    }
}
=======
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import domain.Movie;

public class MovieService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_config");
    private EntityManager em = emf.createEntityManager();

    public List<Movie> searchMoviesByTitle(String movieTitle) {
        try {
            TypedQuery<Movie> query = em.createQuery("SELECT m FROM Movie m WHERE m.title LIKE :title", Movie.class)
                    .setParameter("title", "%" + movieTitle + "%");
            return query.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        if (em.isOpen()) {
            em.close();
        }
        if (emf.isOpen()) {
            emf.close();
        }
    }

	public List<Movie> getNothing() {
		// TODO Auto-generated method stub
		return null;
	}
}
>>>>>>> Stashed changes
