package com.koyotito.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.koyotito.project.model.Usuario;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, Integer>{
	public Optional<Usuario> findByCorreo(String email);
	@Query(value = "SELECT profesor_idProfesor "
			+ "FROM usuario "
			+ "WHERE usuario.idUsuario = :idUsuario", nativeQuery = true)
	public int getId_profesor(@Param("idUsuario") int usuario);
}
