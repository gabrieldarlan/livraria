package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.livraria.dao.UsuarioDao;
import br.com.caelum.livraria.modelo.Usuario;
import br.com.caelum.livraria.util.RedirectView;

@ManagedBean
@SessionScoped
public class LoginBean {

	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public RedirectView efetuarLogin() {
		System.out.println("chamando login" + this.usuario.getEmail());

		boolean existe = new UsuarioDao().existe(this.usuario);
		if (existe) {
			this.usuario=new Usuario();
			return new RedirectView("livro");
		}

		return new RedirectView("login");
	}

}
