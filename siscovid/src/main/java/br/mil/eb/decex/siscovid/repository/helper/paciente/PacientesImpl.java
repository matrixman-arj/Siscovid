package br.mil.eb.decex.siscovid.repository.helper.paciente;

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

import br.mil.eb.decex.siscovid.model.Pessoa;
import br.mil.eb.decex.siscovid.repository.filter.PacienteFilter;
import br.mil.eb.decex.siscovid.repository.paginacao.PaginacaoUtil;


public class PacientesImpl  implements PacientesQueries{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Autowired
	private PaginacaoUtil paginacaoUtil;


	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public Page<Pessoa> filtrar(PacienteFilter filtro, Pageable pageable) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Pessoa.class);
		
		paginacaoUtil.preparar(criteria, pageable);	
		adicionarFiltro(filtro, criteria);
		
		return new PageImpl<>(criteria.list(), pageable, total(filtro));
	}
	
	private Long total(PacienteFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Pessoa.class);
		adicionarFiltro(filtro, criteria);
		criteria.setProjection(Projections.rowCount());
		return (Long) criteria.uniqueResult();
	}

	private void adicionarFiltro(PacienteFilter filtro, Criteria criteria) {
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
		}
	}
		
	private boolean isOrganizacaoMilitarPresente(PacienteFilter filtro) {
		return filtro.getOm() !=null && filtro.getOm().getCodigo() !=null;
	}
	
	
	
}
