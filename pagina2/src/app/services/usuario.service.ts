import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from 'app/models/usuario';
import { Observable, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private url = "http://localhost:8098/usuario"

  constructor(private http:HttpClient) { }

  login(usuario:Usuario):Observable<Usuario>{
    if(usuario?.correo)
      return this.http.post<Usuario>(this.url+'/login', usuario);
    return throwError(() => new Error('El usuario no existe'));
  }

  registro(usuario:Usuario):Observable<Usuario>{
    return this.http.post<Usuario>(this.url+'/registro', usuario);
  }
}
