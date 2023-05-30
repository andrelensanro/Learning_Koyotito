import { Component } from '@angular/core';


@Component({
  selector: 'app-ConfigP',
  templateUrl: './ConfigP.component.html',
  styleUrls: ['.././FondoP.component.scss', './ConfigP.component.scss']
})
export class ConfigPComponent{
  menuType: String = "General";
  constructor() {}
}