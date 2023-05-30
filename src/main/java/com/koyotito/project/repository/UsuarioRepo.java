package com.koyotito.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Long>{
	
	@Query(value = "SELECT * from usuario where usuario.correo=:correo", nativeQuery = true)
	public Usuario findByCorreo(String correo);
	
	@Query(value = "SELECT profesor_idProfesor "
			+ "FROM usuario "
			+ "WHERE usuario.idUsuario=:idUsuario", nativeQuery = true)
	public Long getId_profesor(@Param("idUsuario") Long usuario);
	
}
