package br.unifor.pin.doaweb.manager.instituicao;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.unifor.pin.doaweb.bussines.CampanhaBO;
import br.unifor.pin.doaweb.entity.Campanhas;
import br.unifor.pin.doaweb.utils.Navigation;

@RequestScoped
@ManagedBean(name = "listCampanha")
@Component(value = "listCampanha")
public class ListCampanhaManager {

	@Autowired
	private CampanhaBO campanhaBO;

	private List<Campanhas> ltCampanhas;

	private Campanhas campanha;

	public String listarMinhasCampanhas() {
		ltCampanhas = campanhaBO.buscarCampPorInst(campanhaBO
				.getInstituicaoCampanha());
		return Navigation.LISTCAMPINST;
	}

	public void excluir(Campanhas campanha) {
		campanhaBO.excluirCampanha(campanha);
		ltCampanhas = campanhaBO.buscarCampPorInst(campanhaBO
				.getInstituicaoCampanha());
	}

	public List<Campanhas> getLtCampanhas() {
		return ltCampanhas;
	}

	public void setLtCampanhas(List<Campanhas> ltCampanhas) {
		this.ltCampanhas = ltCampanhas;
	}

	public Campanhas getCampanha() {
		return campanha;
	}

	public void setCampanha(Campanhas campanha) {
		this.campanha = campanha;
	}

}