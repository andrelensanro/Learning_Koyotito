import { Observable } from 'rxjs';
import { Usuario } from './../models/usuario';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  private url = "http://localhost:8098/usuario"

  constructor(private http:HttpClient) { }

  login(usuario:Usuario):Observable<Usuario>{
    return this.http.post<Usuario>(`${this.url+"/login"}`,usuario);
  }


}
