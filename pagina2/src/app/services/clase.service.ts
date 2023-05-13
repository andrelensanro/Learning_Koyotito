import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Clase } from '../models/clase';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClaseService {
  private url = "http://localhost:8098/clase"
  constructor(private http:HttpClient) { }

  create(clase:Clase):Observable<Object>{
    return this.http.post(`${this.url+"/crear"}`,clase);
  }

  edit(clase:Clase):Observable<Object>{
    return this.http.post(`${this.url+"/editar"}`,clase);
  }




}
