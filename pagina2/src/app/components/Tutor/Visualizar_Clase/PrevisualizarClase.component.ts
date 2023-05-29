import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";
import { MatDialog } from "@angular/material/dialog";
import { ToastrService } from "ngx-toastr";
import { DenunciasTComponent } from "../Denuncias/Denuncias.component";
import { AprobarTComponent } from "../Aprobar/Aprobar.component";

@Component({
    selector: 'app-PrevisualizarClase',
    templateUrl: './PrevisualizarClase.component.html',
    styleUrls: ['./PrevisualizarClase.component.scss', '../FondoT.component.scss','../Denuncias/Denuncias.component.scss']
  })
  export class  PrevisualizarClaseTComponent{
    form!: FormGroup;
    constructor(private http: HttpClient, private toastr: ToastrService, public dialog: MatDialog) {
        this.form = new FormBuilder().group({
            chips: [['chip'], []]
        });
    }
    disabled = true;
    items = ['Javascript', 'Typescript'];

    DenunciaDialog(): void{
      const dialogRef = this.dialog.open(DenunciasTComponent, {
        //  data: {name: this.name},
        });
    }


    AprobarDialog(): void{
      const dialogRef = this.dialog.open(AprobarTComponent, {
        //  data: {name: this.name},
        });
    }
    MeGusta(){
      this.toastr.success('Guardado en Me gusta.', 'Éxito',{timeOut: 7000});
    }
    toppings = new FormControl('');

    toppingList: string[] = ['Contenido inapropiado', 'Texto erróneo', 'Contenido ofensivo', 'Imagen errónea', 'No se distingue la imagen'];
  }