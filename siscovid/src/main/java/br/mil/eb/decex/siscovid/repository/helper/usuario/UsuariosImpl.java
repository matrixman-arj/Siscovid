package br.mil.eb.decex.siscovid.repository.helper.usuario;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
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
	public List<Pessoa> filtrar(UsuarioFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Pessoa.class);
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
		return criteria.list();
	}
	
	private boolean isOrganizacaoMilitarPresente(UsuarioFilter filtro) {
		return filtro.getOm() !=null && filtro.getOm().getCodigo() !=null;
	}
	
	
	
}
