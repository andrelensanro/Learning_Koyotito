import { Component, Inject, OnInit } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-ClasesA',
  templateUrl: './Clases.component.html',
  styleUrls: ['../FondoA.component.scss', './Clases.component.scss']
})
export class ClasesAComponent{
  clase(){
    console.log(localStorage.getItem("clase"));
    return localStorage.getItem("clase");
  }
}