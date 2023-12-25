package ifrn.pi.posa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ifrn.pi.posa.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

		Usuario findByEmail(String email);
		
	}

