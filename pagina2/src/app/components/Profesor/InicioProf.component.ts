import { Component, Inject, OnInit } from '@angular/core';
import {MatDialog, MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import { AuthService } from '../services/authService.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-InicioProf',
  templateUrl: './InicioProf.component.html',
  styleUrls: ['./InicioProf.component.css']
})
export class InicioProfComponent implements OnInit{
  menuType: String = "General";
  constructor(private route: Router, public dialog: MatDialog, private authService: AuthService) {}
//constructor(private authService :AuthService){}


ngOnInit(): void{
  this.route.events.subscribe((val:any)=>{
    if(val.url.includes('home')){
      this.menuType="General";
    }else{
      this.menuType="General_Otro";
    }
  })
}
  
/*
  display(){
    if (this.authService.isLoggedIn()) {
      return "Cerrar sesión";      
    }
    return "Iniciar sesión";
  }
  */

  
  longText = `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog
  from Japan. A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was
  originally bred for hunting.`;
}