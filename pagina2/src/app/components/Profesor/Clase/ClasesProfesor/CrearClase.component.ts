import { HttpClient, HttpEventType, HttpResponse } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Observable } from "rxjs";
import { CrearClaseService } from "./CrearClase.service";
import { FormControl } from "@angular/forms";

@Component({
    selector: 'app-CrearClase',
    templateUrl: "./CrearClase.component.html",
    styleUrls: ['./CrearClase.component.scss']
  })
  
  export class CrearClaseComponent implements OnInit{
  
  selectedFiles?: FileList;
  selectedFileNames: string[] = [];

  progressInfos: any[] = [];
  message: string[] = [];

  previews: string[] = [];
  imageInfos?: Observable<any>;

  constructor(private uploadService: CrearClaseService) { }
    

    selectFiles(event: any): void {
      this.message = [];
      this.progressInfos = [];
      this.selectedFileNames = [];
      this.selectedFiles = event.target.files;
    
      this.previews = [];
      if (this.selectedFiles && this.selectedFiles[0]) {
        const numberOfFiles = this.selectedFiles.length;
        for (let i = 0; i < numberOfFiles; i++) {
          const reader = new FileReader();
    
          reader.onload = (e: any) => {
            console.log(e.target.result);
            this.previews.push(e.target.result);
          };
    
          reader.readAsDataURL(this.selectedFiles[i]);
    
          this.selectedFileNames.push(this.selectedFiles[i].name);
        }
      }
    }
    uploadFiles(): void {
      this.message = [];
    
      if (this.selectedFiles) {
        for (let i = 0; i < this.selectedFiles.length; i++) {
          this.upload(i, this.selectedFiles[i]);
        }
      }
    }
    upload(idx: number, file: File): void {
      this.progressInfos[idx] = { value: 0, fileName: file.name };
    
      if (file) {
        const formData = new FormData();
        formData.append('file', file);
        this.uploadService.uploadFiles(formData).subscribe(
          (event: any) => {
            if (event.type === HttpEventType.UploadProgress) {
              this.progressInfos[idx].value = Math.round(100 * event.loaded / event.total);
            } else if (event instanceof HttpResponse) {
              const msg = 'Uploaded the file successfully: ' + file.name;
              this.message.push(msg);
             // this.imageInfos = this.uploadService.getFiles();
            }
          },
          (err: any) => {
            this.progressInfos[idx].value = 0;
            const msg = 'Could not upload the file: ' + file.name;
            this.message.push(msg);
          });
      }
    }
    ngOnInit(): void {
     // this.imageInfos = this.uploadService.getFiles();
    }

    grupos = new FormControl('');

  ListaGrupo: string[] = ['Grupo 1', 'Grupo 2', 'Grupo 3', 'Grupo 4', 'Grupo 5', 'Grupo 6'];



    
    datos = new Tarjeta(); 
}


  export class Tarjeta{
    TipoLetra: string = "Arial";
    TamLetra: string = "12";
    Instruccion : string | undefined;
    Respuesta: string | undefined;
    Idioma: string = "Español";
    Titulo: string | undefined;
    Tags: string | undefined;
  }