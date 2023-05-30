import { RepCrearClaseComponent } from 'app/components/Profesor/Clase/ClasesProfesor/RepCrearClase.component';
import { MediaService } from './media.service';
import { Component, OnInit } from '@angular/core';
import { Usuario } from 'app/models/usuario';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-media',
  templateUrl: './media.component.html',
  styleUrls: ['./media.component.css']
})
export class MediaComponent implements OnInit {
  url?:string;
  url1?:string;
  url2?:string;
  idUsuario?:number;



  constructor(
    private mediaService: MediaService,
    private route: ActivatedRoute
  ){}


  ngOnInit() {
    this.idUsuario = parseInt(this.route.snapshot.paramMap.get('idUsuario')!);
    console.log("El id del usuario " + this.idUsuario);
  }

  upload(event: any){
    const file = event.target.files[0];
    if(file){
      const formData = new FormData();
      formData.append('file', file);

      this.mediaService.uploadFile(formData, this.idUsuario!)
          .subscribe(response => {
            this.url=response.url;
          })
    }
  }

}
