package expertostech.autenticacao.jwt.repository;

import expertostech.autenticacao.jwt.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    @Query("select u from Usuario u where u.login = :login")
    public Optional<UsuarioModel> findLogin(@Param("login") String login);

}
