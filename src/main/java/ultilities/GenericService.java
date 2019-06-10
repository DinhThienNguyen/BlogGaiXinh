package ultilities;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@SuppressWarnings("unchecked")
public abstract class GenericService<E, B> {
	private final Class<E> entityClass;

	@PersistenceContext(name = "BlogGaiXinh")
	EntityManager em;

	public GenericService(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	public abstract E toEntity(B bom);

	public abstract B toBom(E entity);

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public E save(E entity) {
		this.em.persist(entity);
		this.em.flush();
		return entity;
	}

	public E update(E entity) {
		this.em.merge(entity);
		this.em.flush();
		return entity;
	}

	public List<B> findAll() {
		Query query = em.createQuery("SELECT e from " + this.entityClass.getSimpleName() + " e", entityClass);
		List<E> resultList = query.getResultList();
		return toBoms(resultList);
	}

	public B findById(Integer id) {
		E entity = em.find(entityClass, id);
		return toBom(entity);
	}

	public B findByExternalCode(String externalCode) {
		Query query = em.createQuery(
				"SELECT e from " + this.entityClass.getSimpleName() + " e WHERE e.externalCode = :externalCode",
				entityClass);
		query.setParameter("externalCode", externalCode);
		E entity = (E) query.getSingleResult();
		return toBom(entity);
	}

	public B getLatestEntityId() {
		E entity = (E) em.createQuery("SELECT e from " + this.entityClass.getSimpleName() + " e ORDER BY e.id desc")
				.setMaxResults(1).getSingleResult();
		return toBom(entity);
	}

	public void removeById(Integer id) {
		E entity = em.find(entityClass, id);
		if (Objects.nonNull(entity)) {
			em.remove(entity);
		}
	}

	public List<E> toEntities(List<B> boms) {
		if (Objects.isNull(boms)) {
			return Collections.emptyList();
		}
		return boms.stream().map(this::toEntity).collect(Collectors.toList());
	}

	public List<B> toBoms(List<E> entities) {
		if (Objects.isNull(entities)) {
			return Collections.emptyList();
		}
		return entities.stream().map(this::toBom).collect(Collectors.toList());
	}

}
