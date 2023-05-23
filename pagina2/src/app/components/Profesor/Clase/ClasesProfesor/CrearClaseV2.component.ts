import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpEventType, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CrearClaseService } from './CrearClase.service';
import { response } from 'express';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';

declare  var jQuery:  any;
interface EventListener {
    (evt: Event): void;
}

interface EventListenerObject {
    handleEvent(evt: Event): void;
}

@Component({
    selector: 'app-CrearClaseV2',
    templateUrl: "./CrearClaseV2.component.html",
    styleUrls: ['./CrearClaseV2.component.scss', '../../FondoP.component.scss',]
  })
  
  export class CrearClaseV2Component{
    url?: string;
    url2?: string;
    url3?: string;
    url4?: string;
    url5?: string;
    url6?: string;
    url7?: string;
    url8?: string;
    url9?: string;
    url10?: string;
    constructor(private httpClient: HttpClient, private crearClase: CrearClaseService) {
      this.form = new FormBuilder().group({
        chips: [['chip'], []]
    });
     }
    
    
    upload(event: any){
      const file = event.target.files[0];

      if(file){
        const formData = new FormData();
        formData.append('file', file);

        this.crearClase.uploadFiles(formData)
        .subscribe(response => {
          console.log('response', response);
          this.url = response.url;
        })
      }
    }


    form!: FormGroup;
    //items = ['Javascript', 'Typescript'];
    /*
    public onSelect(item:any) {
        console.log('tag selected: value is ' + item);
    }
*/

    grupos = new FormControl('');

  ListaGrupo: string[] = ['Grupo 1', 'Grupo 2', 'Grupo 3', 'Grupo 4', 'Grupo 5', 'Grupo 6'];




  
  selectedFile!: File;
  retrievedImage: any;
  base64Data: any;
  retrieveResonse: any;
  message!: string;
  imageName: any;

  //Gets called when the user selects an image
  public onFileChanged(event: any) {
    //Select File
    this.selectedFile = event.target.files[0];
  }


  //Gets called when the user clicks on submit to upload the image
  onUpload() {
    console.log(this.selectedFile);
    
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    const uploadImageData = new FormData();
    uploadImageData.append('imageFile', this.selectedFile, this.selectedFile.name);
  
    //Make a call to the Spring Boot Application to save the image
    this.httpClient.post('http://localhost:8080/image/upload', uploadImageData, { observe: 'response' })
      .subscribe((response) => {
        if (response.status === 200) {
          this.message = 'Image uploaded successfully';
        } else {
          this.message = 'Image not uploaded successfully';
        }
      }
      );


  }

    //Gets called when the user clicks on retieve image button to get the image from back end
    getImage() {
    //Make a call to Sprinf Boot to get the Image Bytes.
    this.httpClient.get('http://localhost:8080/image/get/' + this.imageName)
      .subscribe(
        res => {
          this.retrieveResonse = res;
          this.base64Data = this.retrieveResonse.picByte;
          this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
        }
      );
  }
/*
    public getInputValue(inputValue:string, divEl:InnerHTML){
      console.log(inputValue);
      var filas: number =+inputValue;
      const rowQty = filas;
      let html = `<table id="tableEl-${rowQty}" border="1">`;
      for (let i = 0; i < rowQty; i++) {
        html += `<tr><td>${i+1}</td><td id="campo-${i + 1}"><div class="=container w-50 ,x-auto pt-5">
        <div class="mb-5">
          <label for="image" class="form-label">Imagen</label>
          <input type="file" id="image" class="form-control" accept="image/*" (change)="this.upload($event)">
        </div>
      
        <div *ngIf="url">
          <img [src]="url" alt="" class="img-fluid img-thumbnail">
        </div>
      </div>
      </td></tr>`;
      }
      html += `</table>`;
      divEl.innerHTML = html;
    }
*/
/*



    fileData: File = null!;

     
    fileProgress(fileInput: any) {
        this.fileData = <File>fileInput.target.files[0];
    }
     
    onSubmit() {
        const formData = new FormData();
        formData.append('file', this.fileData);
        this.http.post('url/to/your/api', formData)
          .subscribe(res => {
            console.log(res);
            alert('SUCCESS !!');
          })
    }*/



    /* Bien mal hehco */

    upload3(event: any){
      const file = event.target.files[0];

      if(file){
        const formData = new FormData();
        formData.append('file', file);

        this.crearClase.uploadFiles(formData)
        .subscribe(response => {
          console.log('response', response);
          this.url = response.url3;
        })
      }
    }
    upload4(event: any){
      const file = event.target.files[0];

      if(file){
        const formData = new FormData();
        formData.append('file', file);

        this.crearClase.uploadFiles(formData)
        .subscribe(response => {
          console.log('response', response);
          this.url = response.url4;
        })
      }
    }
    upload5(event: any){
      const file = event.target.files[0];

      if(file){
        const formData = new FormData();
        formData.append('file', file);

        this.crearClase.uploadFiles(formData)
        .subscribe(response => {
          console.log('response', response);
          this.url = response.url5;
        })
      }
    }
    upload6(event: any){
      const file = event.target.files[0];

      if(file){
        const formData = new FormData();
        formData.append('file', file);

        this.crearClase.uploadFiles(formData)
        .subscribe(response => {
          console.log('response', response);
          this.url = response.url6;
        })
      }
    }
    upload7(event: any){
      const file = event.target.files[0];

      if(file){
        const formData = new FormData();
        formData.append('file', file);

        this.crearClase.uploadFiles(formData)
        .subscribe(response => {
          console.log('response', response);
          this.url = response.url7;
        })
      }
    }
    upload8(event: any){
      const file = event.target.files[0];

      if(file){
        const formData = new FormData();
        formData.append('file', file);

        this.crearClase.uploadFiles(formData)
        .subscribe(response => {
          console.log('response', response);
          this.url = response.url8;
        })
      }
    }
    upload9(event: any){
      const file = event.target.files[0];

      if(file){
        const formData = new FormData();
        formData.append('file', file);

        this.crearClase.uploadFiles(formData)
        .subscribe(response => {
          console.log('response', response);
          this.url = response.url9;
        })
      }
    }
    upload10(event: any){
      const file = event.target.files[0];

      if(file){
        const formData = new FormData();
        formData.append('file', file);

        this.crearClase.uploadFiles(formData)
        .subscribe(response => {
          console.log('response', response);
          this.url = response.url10;
        })
      }
    }
  }