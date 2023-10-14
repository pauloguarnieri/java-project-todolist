package io.github.pauloguarnieri.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.github.pauloguarnieri.todolist.user.IUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// import jakarta.servlet.Filter;
// import jakarta.servlet.ServletRequest;
// import jakarta.servlet.ServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // codigo que é apagado:
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'"); 
        
        var servletPath = request.getServletPath();

        if(servletPath.startsWith("/tasks/")){


            // Pegar a autenticação (usuário e senha)
            var authorization = request.getHeader("Authorization");

            var authEncoded = authorization.substring("Basic".length()).trim();
        
            byte[] authDecode = Base64.getDecoder().decode(authEncoded);
        
            var authString = new String(authDecode);
        
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];
 
            // validar usuário
            var user = this.userRepository.findByUsername(username);
            if(user == null){
                response.sendError(401);

            }else {
                // validar senha
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if(passwordVerify.verified){
                    
                    // Segue viagem
                    request.setAttribute("idUser", user.getId());
                    filterChain.doFilter(request, response);
                } else {
                    response.sendError(401);
                }

            }
        }else {
        filterChain.doFilter(request, response);
        }

        // System.out.println("Authorization");
        // System.out.println(username);
        // System.out.println(password);

    }

    
}

// metodo menos aprimorado exemplo 1

// public class FilterTaskAuth  implements Filter  {

//     @Override
//     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//             throws IOException, ServletException {
            
//          //Executar alguma ação
        
//          System.out.println("Chegou no filtro");
//             chain.doFilter(request, response);
//     }
// }