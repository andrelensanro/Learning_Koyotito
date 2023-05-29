import { Component, Inject, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-DenunciasP',
  templateUrl: './DenunciasP.component.html',
  styleUrls: ['./Denuncias.component.scss']
})


export class DenunciasPComponent{

  toppings = new FormControl('');

  toppingList: string[] = ['Contenido inapropiado', 'Texto erróneo', 'Contenido ofensivo', 'Imagen errónea', 'No se distingue la imagen'];

  constructor(private toastr: ToastrService){}

  Denuncia(){
    this.toastr.info('Denuncia dada de alta.', 'Éxito',{timeOut: 7000});
  }
}