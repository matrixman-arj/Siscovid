package br.mil.eb.decex.siscovid.repository.helper.usuario;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.filter.UsuarioFilter;


public class UsuariosImpl  implements UsuariosQueries{
	
	@PersistenceContext
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Pessoa> filtrar(UsuarioFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Pessoa.class);
		
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistro = paginaAtual * totalRegistrosPorPagina;
		
		criteria.setFirstResult(primeiroRegistro);
		criteria.setMaxResults(totalRegistrosPorPagina);
		
		adicionarFiltro(filtro, criteria);
		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	
	private Long total(UsuarioFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Pessoa.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(UsuarioFilter filtro, Criteria criteria) {
		if (filtro != null) {
			
			if (!StringUtils.isEmpty(filtro.getIdentidade())) {
				criteria.add(Restrictions.eq("identidade", filtro.getIdentidade()));
			}
			
			 if (filtro.getPosto() != null) {
				 criteria.add(Restrictions.eq("posto", filtro.getPosto()));
			 }
			 
			 if (!StringUtils.isEmpty(filtro.getNomeGuerra())) {
					criteria.add(Restrictions.ilike("nomeGuerra", filtro.getNomeGuerra(), MatchMode.ANYWHERE));
			 }
			 
			 if (isOrganizacaoMilitarPresente(filtro)) {
				 criteria.add(Restrictions.eq("om", filtro.getOm()));
			 }
			 
			 if (!StringUtils.isEmpty(filtro.getEmail())) {
					criteria.add(Restrictions.eq("email", filtro.getEmail()));
			 }
			 
			 if (filtro.getPerfil() != null) {
				 criteria.add(Restrictions.eq("perfil", filtro.getPerfil()));
			 }
		}
	}
		
	private boolean isOrganizacaoMilitarPresente(UsuarioFilter filtro) {
		return filtro.getOm() !=null && filtro.getOm().getCodigo() !=null;
	}
	
	
	
}
