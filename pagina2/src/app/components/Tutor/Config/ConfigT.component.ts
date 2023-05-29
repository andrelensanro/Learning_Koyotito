import { Component } from '@angular/core';


@Component({
  selector: 'app-ConfigT',
  templateUrl: './ConfigT.component.html',
  styleUrls: ['.././FondoT.component.scss', './ConfigT.component.scss']
})
export class ConfigTComponent{
  menuType: String = "General";
  constructor() {}
}