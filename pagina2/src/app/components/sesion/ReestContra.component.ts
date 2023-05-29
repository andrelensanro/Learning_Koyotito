import { Component, Inject, OnInit } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Component({
    selector: 'app-ReestContra',
    templateUrl: './ReestContra.component.html'
  })


  
  export class ReestContraComponent implements OnInit{

    constructor(private toastr: ToastrService){}

    ngOnInit(): void{

    }
    Correcto(){
      this.toastr.success('Se ha reestablecido su contraseña.', 'Éxito',{timeOut: 17000});
    }


    Error(){
      this.toastr.error('Las contraseñas no coinciden.', 'Error',{timeOut: 7000});
    }
}