package br.com.luciano.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.luciano.filter.ProfessorFilter;
import br.com.luciano.model.Professor;

public class Professores implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Professor guardar(Professor professor) {
		return this.manager.merge(professor);
	}
	
	public List<Professor> buscarFotoProfessor(String nome) {
		return this.manager.createQuery("select p from Professor p.foto where p.nome like(p:nome) = :nome", Professor.class)
			.setParameter("nome", nome.toLowerCase() + "%").getResultList();

	}

	/* não esta sendo usado */
	public List<Professor> buscarTodosProfessores() {
		return this.manager.createQuery("from Professor order by codigo asc", Professor.class).getResultList();
	}

	public Professor buscarPorCodigo(Long codigo) {
		return this.manager.find(Professor.class, codigo);
	}
	
	public Professor findById(Class clazz, Long codigo) {
		Professor obj = this.manager.find(Professor.class, codigo);
        manager.clear();
        return obj;
    }
	
	@SuppressWarnings("unchecked")
	public List<Professor> filtrarProfessor(ProfessorFilter filtro) {
		Session session = this.manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Professor.class);
		
		if(filtro.getCodigo() != null) {
			criteria.add(Restrictions.ge("codigo", filtro.getCodigo()));
		}
		
		if (filtro.getTipoSeries() != null && filtro.getTipoSeries().length > 0) {
			// adicionamos uma restrição "in", passando um array de constantes da enum StatusPedido
			criteria.add(Restrictions.in("tipoSerie", filtro.getTipoSeries()));
		}
		
		if (filtro.getTipoTurmas() != null && filtro.getTipoTurmas().length > 0) {
			// adicionamos uma restrição "in", passando um array de constantes da enum StatusPedido
			criteria.add(Restrictions.in("tipoTurma", filtro.getTipoTurmas()));
		}
		
		if (filtro.getTipoTurnos() != null && filtro.getTipoTurnos().length > 0) {
			// adicionamos uma restrição "in", passando um array de constantes da enum StatusPedido
			criteria.add(Restrictions.in("tipoTurno", filtro.getTipoTurnos()));
		}
		
		return criteria.addOrder(Order.desc("codigo")).list();
	}
	
	public Professor buscarPorDescricaoAcessorio(String foto) {
		try{
		return this.manager.createQuery("from Professor where lower(foto) = :foto", Professor.class)
				.setParameter("foto", foto.toLowerCase())
				.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

}
