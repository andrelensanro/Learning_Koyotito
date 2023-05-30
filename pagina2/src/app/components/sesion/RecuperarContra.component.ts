import { Component, Inject, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Component({
    selector: 'app-RecuperarContra',
    templateUrl: './RecuperarContra.component.html',
  styleUrls: ['./RecuperarContra.component.css']
  })


  
  export class RecuperarContraComponent implements OnInit{

    constructor(private toastr: ToastrService){}

    ngOnInit(): void{

    }
    Correcto(){
      this.toastr.success('El correo ha sido enviado.', 'Éxito',{timeOut: 7000});
    }


    Error(){
      this.toastr.error('El correo no tiene una cuenta con nosotros.', 'Error',{timeOut: 7000});
    }
}