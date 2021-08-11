package br.mil.eb.decex.siscovid.repository.helper.us;

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

import br.mil.eb.decex.siscovid.model.UnidadeCivilSaude;
import br.mil.eb.decex.siscovid.repository.filter.UCSFilter;
import br.mil.eb.decex.siscovid.repository.paginacao.PaginacaoUtil;


public class UCSsImpl  implements UCSsQueries{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<UnidadeCivilSaude> filtrar(UCSFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(UnidadeCivilSaude.class);
		
		paginacaoUtil.preparar(criteria, pageable);			
		adicionarFiltro(filtro, criteria);
		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	
	private Long total(UCSFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(UnidadeCivilSaude.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(UCSFilter filtro, Criteria criteria) {
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
