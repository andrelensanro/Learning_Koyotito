import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario';
import { Observable} from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
 
  private url = "http://localhost:8098/usuario"

  constructor(private http:HttpClient) { }

  /* Registrar: solo retorna el id del usuario */
  registrar(usuario:Usuario):Observable<Usuario>{
    return this.http.post<Usuario>(`${this.url+"/registro"}`,usuario);
  }

  getUsuario(idUsuario:number):Observable<Usuario>{
    return this.http.get<Usuario>(`${this.url+"/consultar/${"+ idUsuario+"}"}`).pipe(
      map((data:Usuario) =>{
        const usuario:Usuario = {
          idUsuario: data['idUsuario'],
          nombre: data['nombre'],
          apellido1:data['apellido1'],
          apellido2:data['apellido2'],
          correo:data['correo'],
          password: data['password'],
          num_denuncias: data['num_denuncias'],
          idTipoUsuario:data['idTipoUsuario'],
          instPseudonimo: data['instPseudonimo']
        };
        return usuario;
      })
    )
  }


}
