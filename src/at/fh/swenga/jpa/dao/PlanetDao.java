package at.fh.swenga.jpa.dao;
 
import java.util.List;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
 
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
 
import at.fh.swenga.jpa.model.PlanetModel;
 
@Repository
@Transactional
public class PlanetDao {
 
	@PersistenceContext
	protected EntityManager entityManager;
 
	public List<PlanetModel> getPlanets() {
		TypedQuery<PlanetModel> typedQuery = entityManager.createQuery("select e from PlanetModel e",
				PlanetModel.class);
		List<PlanetModel> typedResultList = typedQuery.getResultList();
		return typedResultList;
	}
 
	public List<PlanetModel> searchPlanets(String searchString) {
		TypedQuery<PlanetModel> typedQuery = entityManager.createQuery(
				"select e from PlanetModel e where e.name like :search or e.surface like :search",
				PlanetModel.class);
		typedQuery.setParameter("search", "%" + searchString + "%");
		List<PlanetModel> typedResultList = typedQuery.getResultList();
		return typedResultList;
	}
 
	public PlanetModel getPlanet(int i) throws DataAccessException {
		return entityManager.find(PlanetModel.class, i);
	}
 
	public void persist(PlanetModel planet) {
		entityManager.persist(planet);
	}
 
	public PlanetModel merge(PlanetModel planet) {
		return entityManager.merge(planet);
	}
 
	public void delete(PlanetModel planet) {
		entityManager.remove(planet);
	}
 
	public int deleteAllPlanets() {
		int count = entityManager.createQuery("DELETE FROM PlanetModel").executeUpdate();
		return count;
	}
 
	public void delete(int id) {
		PlanetModel planet = getPlanet(id);
		if (planet != null)
			delete(planet);
	}
}