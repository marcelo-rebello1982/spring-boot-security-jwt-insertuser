package expertostech.autenticacao.jwt.service;

import expertostech.autenticacao.jwt.data.UserDetailsData;
import expertostech.autenticacao.jwt.model.UsuarioModel;
import expertostech.autenticacao.jwt.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsDataImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

//    public UserDetailsDataImpl(UsuarioRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioModel> usuario = repository.findLogin(username);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException("Usuário [" + username + "] não encontrado");
        }
        return new UserDetailsData(usuario);
    }
}
