import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario';
import { Observable, throwError} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
 
  private url = "http://localhost:8098/usuario"

  constructor(private http:HttpClient) { }


  registrar(usuario:Usuario):Observable<Usuario>{
    return this.http.post<Usuario>(`${this.url+"/registro"}`,usuario);
  }

  login(usuario:Usuario):Observable<Object>{
    return this.http.post(`${this.url+"/login"}`,usuario);
  }

}
