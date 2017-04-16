package at.fh.swenga.jpa.dao;
 
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
 
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import at.fh.swenga.jpa.model.Universe;
 
@Repository
@Transactional
public class UniverseDao {
 
	@PersistenceContext
	protected EntityManager entityManager;
 
	public List<Universe> getUniverses() {
 
		TypedQuery<Universe> typedQuery = entityManager.createQuery(
				"select p from Universe p", Universe.class);
		List<Universe> typedResultList = typedQuery.getResultList();
		return typedResultList;
	}
 
	public Universe getUniverse(String name) {
		try {
			TypedQuery<Universe> typedQuery = entityManager.createQuery(
					"select p from Universe p where p.name = :name",
					Universe.class);
			typedQuery.setParameter("name", name);
			Universe universe = typedQuery.getSingleResult();
			return universe;
		} catch (NoResultException e) {
			return null;
		}
 
	}
}