import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MediaService {
  constructor(
    private http: HttpClient
  ) { }
  
    uploadFile(formData: FormData, idUsuario: number):Observable<any>{
      return this.http.post(`http://localhost:8098/media/upload/${idUsuario}`, formData)
    }
}
