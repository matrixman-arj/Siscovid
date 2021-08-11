package br.mil.eb.decex.siscovid.repository.helper.om;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.mil.eb.decex.siscovid.model.OrganizacaoMilitar;
import br.mil.eb.decex.siscovid.repository.filter.OMFilter;
import br.mil.eb.decex.siscovid.repository.paginacao.PaginacaoUtil;


public class OMsImpl  implements OMsQueries{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<OrganizacaoMilitar> filtrar(OMFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(OrganizacaoMilitar.class);
		
		paginacaoUtil.preparar(criteria, pageable);	
		adicionarFiltro(filtro, criteria);
		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	
	private Long total(OMFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(OrganizacaoMilitar.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(OMFilter filtro, Criteria criteria) {
		if (filtro != null) {
			
			if (!StringUtils.isEmpty(filtro.getSigla())) {
				criteria.add(Restrictions.ilike("sigla", filtro.getSigla(), MatchMode.ANYWHERE));
		 }			 
			 
			 if (!StringUtils.isEmpty(filtro.getDescricao())) {
					criteria.add(Restrictions.ilike("descricao", filtro.getDescricao(), MatchMode.ANYWHERE));
			 }			 
		}
	}
	
}
