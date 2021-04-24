import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-packages',
  templateUrl: './packages.component.html',
  styleUrls: ['./packages.component.css']
})
export class PackagesComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  package=[
    {'id':1,'name':'Silver Wash','description':'Well remove the dirt and grit from your paint,glass,plastic trims, wheels, chrome and exhaust tip. If you are your car often, carrying lots of passengers or just love dustless dash and spotless carpet this service is for you  *TC applied *Exterior steam washing *Interior steam cleaning *Interior vacuuming *Tyre dressing *Deodorizing','image':'../../assets/4.jpg'},
    {'id':2,'name':'Gold Wash','description':'Well remove the dirt and grit from your paint,glass,plastic trims, wheels, chrome and exhaust tip. If you are your car often, carrying lots of passengers or just love dustless dash and spotless carpet this service is for you  *TC applied  *Silver wash+ *Engine room cleaning *Vehicle body waxing *AC vent sanitizing','image':'../../assets/3.jpg'},
    {'id':3,'name':'Platinum Wash','description':'Well remove the dirt and grit from your paint,glass,plastic trims, wheels, chrome and exhaust tip. If you are your car often, carrying lots of passengers or just love dustless dash and spotless carpet this service is for you  *TC applied *Gold wash+ *Wheel dressing *Seat shampooing','image':'../../assets/1.jpg'},
  ]
}
