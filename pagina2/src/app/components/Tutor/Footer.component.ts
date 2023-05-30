import { Component } from "@angular/core";

@Component({
    selector: 'app-Footer',
    templateUrl: './Footer.component.html',
    styleUrls: ['./Footer.component.scss']
  })
  export class  FooterComponent{
    SelClase(): void{
      localStorage.setItem("clase","");
  }
  }