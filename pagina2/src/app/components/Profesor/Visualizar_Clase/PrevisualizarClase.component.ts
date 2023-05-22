import { HttpClient } from "@angular/common/http";
import { Component } from "@angular/core";
import { FormBuilder, FormControl, FormGroup } from "@angular/forms";
import { MatDialog } from "@angular/material/dialog";
import { ToastrService } from "ngx-toastr";
import { DenunciasPComponent } from "../Denuncias/DenunciasP.component";
import { AprobarPComponent } from "../Aprobar/Aprobar.component";

@Component({
    selector: 'app-PrevisualizarClase',
    templateUrl: './PrevisualizarClase.component.html',
    styleUrls: ['./PrevisualizarClase.component.scss', '../FondoP.component.scss','../Denuncias/Denuncias.component.scss']
  })
  export class  PrevisualizarClaseComponent{
    form!: FormGroup;
    constructor(private http: HttpClient, private toastr: ToastrService, public dialog: MatDialog) {
        this.form = new FormBuilder().group({
            chips: [['chip'], []]
        });
    }
    disabled = true;
    items = ['Javascript', 'Typescript'];

    DenunciaDialog(): void{
      const dialogRef = this.dialog.open(DenunciasPComponent, {
        //  data: {name: this.name},
        });
    }


    AprobarDialog(): void{
      const dialogRef = this.dialog.open(AprobarPComponent, {
        //  data: {name: this.name},
        });
    }
    MeGusta(){
      this.toastr.success('Guardado en Me gusta.', 'Éxito',{timeOut: 7000});
    }
    toppings = new FormControl('');

    toppingList: string[] = ['Contenido inapropiado', 'Texto erróneo', 'Contenido ofensivo', 'Imagen errónea', 'No se distingue la imagen'];
  }