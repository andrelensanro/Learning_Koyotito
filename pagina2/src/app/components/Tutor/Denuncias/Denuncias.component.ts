import { Component, Inject, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-DenunciasT',
  templateUrl: './Denuncias.component.html',
  styleUrls: ['./Denuncias.component.scss']
})


export class DenunciasTComponent{
  toppings = new FormControl('');

  toppingList: string[] = ['Contenido inapropiado', 'Texto erróneo', 'Contenido ofensivo', 'Imagen errónea', 'No se distingue la imagen'];


  onChangeValue() {
    this.isDisabled();
  }
  isDisabled() {
  }
}