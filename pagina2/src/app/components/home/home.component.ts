import { Component } from '@angular/core';
import { MenuComponent } from '../menu/menu.component';
import { RegistroComponent } from '../registro/registro.component';
import { Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import { AuthService } from '../services/authService.component';
import { inicioSesionComponent } from '../menu/inicioSesion.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent{
  menuType: String = "General";
  constructor(private route: Router, public dialog: MatDialog, private authService: AuthService) {}
//constructor(private authService :AuthService){}

  openDialog(): void {
    const dialogRef = this.dialog.open(inicioSesionComponent, {
    //  data: {name: this.name},
    });

  }

  RegistroDialog(): void{
    const dialogRef = this.dialog.open(RegistroComponent, {
      //  data: {name: this.name},
      });
  }



ngOnInit(): void{

}

}