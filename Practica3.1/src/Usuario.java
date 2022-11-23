
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

    @GeneratedValue(generator = "ID")
    private int id;
    private String nombre;
    private String contrasena;
    private String usuario;
    private String email;

    public Usuario(){};

    public Usuario(int id, String nombre, String contrasena, String usuario, String email) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.usuario = usuario;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
