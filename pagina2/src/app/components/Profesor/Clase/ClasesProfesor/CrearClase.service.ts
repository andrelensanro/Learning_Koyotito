import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CrearClaseService {
  constructor(private http: HttpClient){}


  uploadFiles(formData: FormData): Observable<any>{
    return this.http.post('http://localhost:8080/media/upload', formData);
  }
}