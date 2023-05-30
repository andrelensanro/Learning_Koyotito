import { Component, Inject, OnInit } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-Clases',
  templateUrl: './Clases.component.html',
  styleUrls: ['../FondoT.component.scss', './Clases.component.scss']
})
export class ClasesComponent{
  clase(){
    console.log(localStorage.getItem("clase"));
    return localStorage.getItem("clase");
  }
}