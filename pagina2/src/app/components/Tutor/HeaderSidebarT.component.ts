import { Component } from '@angular/core';


@Component({
  selector: 'app-HeaderSidebarT',
  templateUrl: './HeaderSidebarT.component.html',
  styleUrls: ['./HeaderSidebarT.component.scss']
})
export class  HeaderSidebarTComponent{
  menuType: String = "General";
  constructor() {}
}