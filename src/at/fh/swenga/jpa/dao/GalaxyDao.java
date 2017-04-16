package at.fh.swenga.jpa.dao;
 
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import at.fh.swenga.jpa.model.Galaxy;
 
@Repository
@Transactional
public class GalaxyDao {
 
	@PersistenceContext
	protected EntityManager entityManager;
 
	public List<Galaxy> getGalaxys() {
 
		TypedQuery<Galaxy> typedQuery = entityManager.createQuery(
				"select d from Galaxy d", Galaxy.class);
		List<Galaxy> typedResultList = typedQuery.getResultList();
		return typedResultList;
	}
 
	public Galaxy getGalaxy(String name) {
		try {
 
			TypedQuery<Galaxy> typedQuery = entityManager.createQuery(
					"select d from Galaxy d where d.name = :name",
					Galaxy.class);
			typedQuery.setParameter("name", name);
			Galaxy department = typedQuery.getSingleResult();
			return department;
		} catch (NoResultException e) {
			return null;
		}
	}
 
}